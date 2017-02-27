package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case ("-c"): {
                addPeople(args);
                break;
            }
            case ("-u"): {
                updateData(args);
                break;
            }
            case ("-d"): {
                deleteById(args);
                break;
            }
            case ("-i"): {
                infoById(args);
                break;
            }
        }
    }
    public static synchronized void addPeople(String args[]) throws ParseException  {
        int count = 2;
        while (count < args.length) {
            if(args[count].equals("м")) {
                allPeople.add(Person.createMale(args[count-1],simple.parse(args[count+1])));
            } else if(args[count].equals("ж")) {
                allPeople.add(Person.createFemale(args[count-1],simple.parse(args[count+1])));
            }
            System.out.println(allPeople.size()-1);
            count += 3;
        }

    }
    public static synchronized void updateData(String args[]) throws ParseException {
        int count = 1;
        while (count < args.length) {
            if(args[count+2].equals("м")) {
                allPeople.set(Integer.parseInt(args[count]),Person.createMale(args[count+1],simple.parse(args[count+3])));
            } else if(args[count+2].equals("ж")) {
                allPeople.set(Integer.parseInt(args[count]),Person.createFemale(args[count+1],simple.parse(args[count+3])));
            }
            count += 4;
        }
    }
    public static synchronized void deleteById(String args[])  {
        int count = 1;
        while (count < args.length) {
            try
            {
                allPeople.get(Integer.parseInt(args[count])).setBirthDay(null);
            } catch (IndexOutOfBoundsException e) {
                e.getMessage();
            }
            count++;
        }
    }
    public static synchronized void infoById(String args[])  {
        int count = 1;
        while (count < args.length) {
            Person personPrint = allPeople.get(Integer.parseInt(args[count]));
            SimpleDateFormat simplePrint = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(personPrint.getName() + " " + (personPrint.getSex().equals(Sex.MALE) ? "м" : "ж") + " "
                                + simplePrint.format(personPrint.getBirthDay()));
            count++;
        }
    }
}

package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   //     System.out.println("Ввести с клавиатуры строку name.");
        String name = reader.readLine();
    //    System.out.println("Ввести с клавиатуры дату рождения (три числа): y, m, d.");
    //    String dateParse = reader.readLine();
        int year = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine());
        int day = Integer.parseInt(reader.readLine());
   //     Solution.myNameIs(name, dateParse);
        Solution.myNameIs(name, year, month, day);
    }
    public static void myNameIs(String name, int y, int m, int d) {
        System.out.println("Меня зовут " + name + "\n" + "Я родился " + d + "." + m + "." + y);
    }
    /*
    public static void myNameIs(String name, String strDate) {
        String delims = "[,.]";
        String[] arrayDate = strDate.split(delims);
        int year = Integer.parseInt(arrayDate[0]);
        int month = Integer.parseInt(arrayDate[1]);
        int day = Integer.parseInt(arrayDate[2]);
        System.out.println("Меня зовут " + name + "\n" + "Я родился " + day + "." + month + "." + year);
    } */
}

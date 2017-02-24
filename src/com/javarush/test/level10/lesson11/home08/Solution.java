package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] list = new ArrayList[3];
        ArrayList<String> array1 = new ArrayList<String>();
        ArrayList<String> array2 = new ArrayList<String>();
        ArrayList<String> array3 = new ArrayList<String>();

        array1.add("Hello");
        array1.add("Hi");
        array1.add("Baby");

        array2.add("Stas");
        array2.add("Gora");
        array2.add("Geka");

        array3.add("1243");
        array3.add("brt67");
        array3.add("45346346463");

        list[0] = array1;
        list[1] = array2;
        list[2] = array3;

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}
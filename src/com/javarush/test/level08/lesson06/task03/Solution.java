package com.javarush.test.level08.lesson06.task03;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Измерить сколько времени занимает 10 тысяч вставок для каждого списка
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert  должен вернуть время его исполнения в миллисекундах.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList aList = new ArrayList();
        LinkedList lList = new LinkedList();

        insert10000(aList);
        insert10000(lList);

        System.out.println(getTimeMsOfInsert(aList));
        System.out.println(getTimeMsOfInsert(lList));
    }

    public static long  getTimeMsOfInsert(List list)
    {
        Date currentTime = new Date();

        remove10000(list);

        Date newTime = new Date ();
        long timeMsOfInsert = newTime.getTime() - currentTime.getTime();
        return timeMsOfInsert;
    }

    public static void insert10000(List list)
    {
        for (int i=0;i<10000;i++)
        {
            list.add(0, new Object());
        }
    }
    public static void get10000(List list)
    {
        for(int i = 0; i < 10000; i++) {
            list.get(i);
        }
    }

    public static void set10000(List list)
    {
        for(int i = 0; i < 10000; i++) {
            list.set(i,i+1);
        }

    }

    public static void remove10000(List list)
    {
        int size = list.size();
        for(int i = 0; i < size; i++) {
            list.remove(size -1 -i);
        }
    }
}

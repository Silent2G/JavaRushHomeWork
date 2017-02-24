package com.javarush.test.level08.lesson06.task02;

import java.util.*;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list)
    {
        int insert = 100;
        for(int i = 0; i < 10000; i++) {
            list.add(insert);
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

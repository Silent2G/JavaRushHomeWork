package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("january", 1);
        map.put("february", 2);
        map.put("march", 3);
        map.put("april", 4);
        map.put("may", 5);
        map.put("june", 6);
        map.put("july", 7);
        map.put("august", 8);
        map.put("september", 9);
        map.put("october", 10);
        map.put("november", 11);
        map.put("december", 12);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if(month.toLowerCase().equals(pair.getKey())) {
                System.out.println(month + " is " + pair.getValue() + " month");
            }
        }
    }

}

package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/
import java.util.*;
import java.text.SimpleDateFormat;
public class Solution
{
    public static void main(String[] args)
    {
        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd MM yyyy");
        System.out.println(simple.format(date));
    }
}


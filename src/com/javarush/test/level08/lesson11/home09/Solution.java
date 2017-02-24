package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {
        boolean res = false;
        Date yearStartTime = new Date(date);
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(0);
        yearStartTime.setMonth(0);

        Date currentDate = new Date(date);
        //System.out.println("currentDate = " + currentDate);

        long msDay = 24*60*60*1000;
        long msTimeDistance = (currentDate.getTime()) - yearStartTime.getTime();
       // System.out.println("currentDate.getTime() " + currentDate.getTime());
       // System.out.println("yearStartTime.getTime() " + yearStartTime.getTime());
       // System.out.println("msTimeDistance = " + msTimeDistance);

       // System.out.println("msDay = " + msDay);
        int dayCount = (int)(msTimeDistance/msDay);
       // System.out.println("dayCount = " + dayCount);
        if (dayCount % 2 == 0) {
            res = false;
        } else if(dayCount % 2 != 0) {
            res = true;
        }

        return res;
    }
}

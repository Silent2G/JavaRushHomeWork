package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        String d = reader.readLine();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);
        int numberC = Integer.parseInt(c);
        int numberD = Integer.parseInt(d);

        int [] array = {numberA, numberB, numberC, numberD};

        maxNumbers(array);

    }
    public static void maxNumbers (int [] a) {
        int max = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] >= max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}

package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);
        int numberC = Integer.parseInt(c);

        int[] array = {numberA, numberB, numberC};
        sort(array);
    }
    public static void sort(int [] a) {
        for(int i = 0; i < a.length; i++) {
            int min = a[i];
            int min_i = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j]< min) {
                   min = a[j];
                   min_i = j;
                }
            }
            if(i != min_i) {
                int replase = a[i];
                a[i] = a[min_i];
                a[min_i] = replase;
            }
        }
        for(int i = a.length-1; i >=0; i--) {
            System.out.println(a[i]);
        }
    }
}

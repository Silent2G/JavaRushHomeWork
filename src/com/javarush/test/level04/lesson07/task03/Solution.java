package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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

        theAmountOfPositiveNumbers(numberA, numberB, numberC);
    }
    public static void theAmountOfPositiveNumbers(int a, int b, int c) {
        int count = 0;
        if(a > 0) {
            count = ++count;
        }
        if(b > 0) {
            count = ++count;
        }
        if(c > 0) {
            count  = ++count;
        }
        System.out.println(count);
    }
}

package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int countPlus = 0;
        int countMinus = 0;
        if(a >= 0) {
            countPlus = ++countPlus;
        } else if(a < 0) {
            countMinus = ++countMinus;
        }
        if(b >= 0) {
            countPlus = ++countPlus;
        } else if(b < 0) {
            countMinus = ++countMinus;
        }
        if(c >= 0) {
            countPlus  = ++countPlus;
        } else if (c < 0) {
            countMinus = ++countMinus;
        }
        System.out.println("количество отрицательных чисел: " + countMinus);
        System.out.println("количество положительных чисел: " + countPlus);
    }
}

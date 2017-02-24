package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        minNumbers(numberA, numberB);
    }
    public static void minNumbers(int a, int b) {
        if(a < b ) {
            System.out.println(a);
        } else if (a == b) {
            System.out.println(a);
        } else if(a > b) {
            System.out.println(b);
        }
    }
}
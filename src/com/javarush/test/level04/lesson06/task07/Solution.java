package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
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

        sequenceNumber(numberA, numberB, numberC);
    }
    public static void sequenceNumber(int a, int b, int c) {
        if(a == b && b != c) {
            System.out.println(3);
        } else if(b == c && a != c) {
            System.out.println(1);
        } else if(a == c && b != a) {
            System.out.println(2);
        }
    }
}

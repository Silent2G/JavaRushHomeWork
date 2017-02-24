package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);
        int numberC = Integer.parseInt(c);

        middle(numberA, numberB, numberC);
    }
    public static void middle(int a, int b, int c) {
        if(a > b && a < c) {
            System.out.println(a);
        } else if(a < b && a > c) {
            System.out.println(a);
        } else if(b < a && b > c) {
            System.out.println(b);
        } else if(b > a && b < c) {
            System.out.println(b);
        } else if(c < a && c > b) {
            System.out.println(c);
        } else if(c > a && c < b) {
            System.out.println(c);
        }
    }
}

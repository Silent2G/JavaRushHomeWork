package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      //  System.out.println("Введите число больше 0");
        int max = Integer.parseInt(reader.readLine());
        int maximum = 0;
        int buffer = 0;
        for(int i = 0;i < max; i++) {
                buffer = Integer.parseInt(reader.readLine());
                if(i == 0) {
                    maximum = buffer;
                }
                if(buffer > maximum)
                    maximum = buffer;

        }
        System.out.println(maximum);
    }
}

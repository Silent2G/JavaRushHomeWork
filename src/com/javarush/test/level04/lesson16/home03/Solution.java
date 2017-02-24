package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sum(reader);
    }
    public static void sum(BufferedReader buffer) throws Exception{
        int sum = 0;
        for(; true; ) {
            String s = buffer.readLine();
            int number = Integer.parseInt(s);
            if(number == -1) {
                break;
            } else {
                sum = number + sum;
            }
        }
        sum = sum + (-1);
        System.out.println(sum);
    }
}

package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        String sNum = reader.readLine();
        int number  = Integer.parseInt(sNum);

        nWords(word, number);
    }
    public static void nWords(String a, int b) {
        while(b > 0) {
            System.out.println(a);
            b--;
        }
    }
}

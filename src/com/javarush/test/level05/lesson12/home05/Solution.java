package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution.sum(reader);
    }
    public static void sum(BufferedReader reader) throws Exception {
        String word;
        int sum = 0;
        for(;true;) {
            word = reader.readLine();
            if(word.equals("сумма")) {
                break;
            } else {
                sum += Integer.parseInt(word);
            }
        }
        System.out.println(sum);
    }
}

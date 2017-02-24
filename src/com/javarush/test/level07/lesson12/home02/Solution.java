package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberN = Integer.parseInt(reader.readLine());
        int numberM = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listM = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < numberN; i++) {
            list.add(reader.readLine());
        }
        for(int i = 0; i < numberM; i++) {
            listM.add(list.get(i));
        }
        for(int i = numberM; i < list.size(); i++) {
            result.add(list.get(i));
        }
        result.addAll(listM);
        for(String s : result) {
            System.out.println(s);
        }
    }
}

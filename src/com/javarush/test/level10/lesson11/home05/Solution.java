package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        String res = "";
        for(int i = 0; i < list.size(); i++) {
            res = res.concat(list.get(i));
        }

        res = res.toLowerCase();
        char[] arrayRes = res.toCharArray();

        ArrayList<Character> listCharter = new ArrayList<Character>();
        ArrayList<Integer> listInteger = new ArrayList<Integer>();

        for(int i = 0; i < abcArray.length; i++) {
            int countChar = 0;
            for(int j = 0; j < arrayRes.length; j++ ) {
                if(abcArray[i] == arrayRes[j]) {
                    countChar = ++countChar;
                }
            }
            listCharter.add(abcArray[i]);
            listInteger.add(countChar);
        }
        for(int i = 0; i < abcArray.length; i++) {
            System.out.println(listCharter.get(i) + " " + listInteger.get(i));
        }
    }

}

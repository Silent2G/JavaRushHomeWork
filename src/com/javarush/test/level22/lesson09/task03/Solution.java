package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "C:/Users/admin/Desktop/a.txt";
        reader.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(name),"UTF-8"));

        ArrayList<String> list = new ArrayList<String>();

        while(in.ready()){
             list.addAll(Arrays.asList(in.readLine().split(" ")));
        }
        in.close();

        String array[] = new String[list.size()];
        list.toArray(array);

        //...
        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if(words == null) {
            return new StringBuilder();
        }
        if(words.length > 0) {
            int count = 0;
            ArrayList<String> result = new ArrayList<>();

            ArrayList<String> list = (ArrayList<String>) Arrays.asList(words);

            for(int i = 0; i < list.size(); i++) {
                for(int j = i+1; j < list.size(); j++) {
                    String wordOne = list.get(i);
                    String wordTwo = list.get(j);
                    if(wordOne.charAt(wordOne.length()-1) == wordTwo.charAt(0)) {
                        count = ++count;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            return sb;
        } else return new StringBuilder();

    }
}

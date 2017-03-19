package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name  = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name);
        String res = "";
        while (fileReader.ready()) {
            res += (char)fileReader.read();
        }
        fileReader.close();

        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(res);
        int count = 0;
        while (matcher.find()) {
            count ++;
        }
        System.out.println(count);
    }
}

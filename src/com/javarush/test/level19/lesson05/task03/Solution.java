package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne  = reader.readLine();
        String nameTwo  = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(nameOne);
        String res = "";
        while (fileReader.ready()) {
            res += (char)fileReader.read();
        }
        fileReader.close();

        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(res);

        String burn = "";
        while (matcher.find()) {
            burn += res.substring(matcher.start(), matcher.end()) + " ";
        }
        FileWriter fileWriter = new FileWriter(nameTwo);
        fileWriter.write(burn);

        fileWriter.close();
    }
}

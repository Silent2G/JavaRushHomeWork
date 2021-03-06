package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        res = res.replace('.', '!');

        FileWriter fileWriter = new FileWriter(nameTwo);
        fileWriter.write(res);

        fileWriter.close();
    }
}

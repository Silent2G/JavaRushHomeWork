package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(nameOne);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();

        String text = new String(buffer);
        Pattern pattern = Pattern.compile("[-]?\\d++(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        String result = "";
        while (matcher.find()) {
            result += Math.round(Double.parseDouble(text.substring(matcher.start(),matcher.end()))) + " ";
        }
        byte[] array = result.getBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(nameTwo);
        fileOutputStream.write(array);
        fileOutputStream.close();
    }
}

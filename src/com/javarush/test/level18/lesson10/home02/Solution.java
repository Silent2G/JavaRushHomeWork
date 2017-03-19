package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int available = fileInputStream.available();
        byte[] buffer = new byte[available];
        fileInputStream.read(buffer);
        String text = new String(buffer);

        Pattern patternTwo = Pattern.compile("[ ]");
        Matcher matcherTwo = patternTwo.matcher(text);

        int countSpaces = 0;
        while (matcherTwo.find()) {
            countSpaces++;
        }
        double res = 0;

        try
        {
            res = ((double) countSpaces/ available) * 100;
        } catch (ArithmeticException e) {
            e.getMessage();
        }
        Locale.setDefault(new Locale("en"));
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        System.out.println(decimalFormat.format(res));

        fileInputStream.close();
    }
}

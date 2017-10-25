package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        boolean thread = true;
        while (thread) {
            try {
                line  = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(line);
            } catch (FileNotFoundException e) {
                thread = false;
                System.out.println(line);
                try {
                    reader.close();
                } catch (IOException o) {
                    o.printStackTrace();
                }
            }
        }
    }
}

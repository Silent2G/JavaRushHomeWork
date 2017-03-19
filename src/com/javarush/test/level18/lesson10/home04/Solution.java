package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        reader.close();

        FileInputStream inputStreamOne = new FileInputStream(nameOne);
        FileInputStream inputStreamTwo = new FileInputStream(nameTwo);

        byte[] buffer1 = new byte[inputStreamOne.available()];
        byte[] buffer2 = new byte[inputStreamTwo.available()];

        inputStreamOne.read(buffer1);
        inputStreamTwo.read(buffer2);

        inputStreamOne.close();
        inputStreamTwo.close();

        RandomAccessFile file = new RandomAccessFile(nameOne, "rw");
        file.seek(0);
        file.write(buffer2);
        file.write(buffer1);
        file.close();
    }
}

package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(nameOne);
        FileOutputStream outputStream = new FileOutputStream(nameTwo);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        int i = 1;
        while(i < buffer.length) {
            outputStream.write(buffer[i]);
            i += 2;
        }

        inputStream.close();
        outputStream.close();

    }
}

package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = /*reader.readLine();*/ "C:/Users/admin/Desktop/a.txt";
        String nameTwo = /*reader.readLine();*/ "C:/Users/admin/Desktop/b.txt";
        String nameThree = /*reader.readLine();*/ "C:/Users/admin/Desktop/c.txt";
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(nameOne);
        FileInputStream inputStreamTwo = new FileInputStream(nameTwo);
        byte[] buffer = new byte[inputStreamTwo.available()];
        inputStreamTwo.read(buffer);
        outputStream.write(buffer);

        FileInputStream inputStreamThree = new FileInputStream(nameThree);
        byte[] bufferTwo = new byte[inputStreamThree.available()];
        inputStreamThree.read(bufferTwo);
        outputStream.write(bufferTwo);

        outputStream.close();
        inputStreamTwo.close();
        inputStreamThree.close();
    }
}

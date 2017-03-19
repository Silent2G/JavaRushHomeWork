package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        String nameThree = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(nameOne);
        FileOutputStream outputStreamOne = new FileOutputStream(nameTwo);
        FileOutputStream outputStreamTwo = new FileOutputStream(nameThree);

        int bytes = inputStream.available();
        byte[] buffer = new byte[bytes];
        inputStream.read(buffer);

        int countOne = bytes % 2 == 0 ? bytes/2 : bytes/2 +1;
        int countTwo = bytes-countOne;

        outputStreamOne.write(buffer, 0, countOne);
        outputStreamTwo.write(buffer, countOne, countTwo);

        inputStream.close();
        outputStreamOne.close();
        outputStreamTwo.close();
    }
}

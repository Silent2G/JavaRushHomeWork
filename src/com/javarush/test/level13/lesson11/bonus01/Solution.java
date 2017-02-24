package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wayToFile = reader.readLine();
        BufferedReader readerFile = new BufferedReader(new FileReader(wayToFile));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(readerFile.ready()) {
            int num = Integer.parseInt(readerFile.readLine());
            if(num % 2 == 0) {
                list.add(num);
            }
        }

        readerFile.close();
        reader.close();
        for(int i = list.size()-1; i > 0; i --) {
            for(int j = 0; j < i; j++) {
                if(list.get(j) > list.get(j+1)) {
                    int buffer = list.get(j+1);
                    list.set(j+1, list.get(j));
                    list.set(j, buffer);
                }
            }
        }
        for(int i : list) {
            System.out.println(i);
        }

    }
}

package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wayFile = reader.readLine();
        ArrayList<String> list  = new ArrayList<String>();
        for(; true ;) {
            String word = reader.readLine();
            list.add(word);
            if(word.equals("exit")) break;
        }
        OutputStream outStream = new FileOutputStream(wayFile);
        while (true) {
            for(int i= 0; i < list.size(); i++) {
                outStream.write(list.get(i).getBytes());
                outStream.write(System.lineSeparator().getBytes()); //"/r/n"
            }
            break;
        }
        outStream.flush();
        outStream.close();
    }
}

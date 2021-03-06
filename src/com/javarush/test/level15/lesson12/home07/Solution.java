package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(Constants.FILE_NAME)));
            int c;
            String res = "";
            while((c = reader.read())!= -1) {
                if(c != 13 && c != 10) {
                    Character ch = (char)c;
                    res = res.concat(ch.toString());
                } else if(c == 10){
                    lines.add(res);
                    res = "";
                }
            }
            lines.add(res);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}

package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Файл в статическом блоке
*/


public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
            try {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(Statics.FILE_NAME)));
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
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}

package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution  {
    public static void main(String[] args) {

    }
    
    static {
        try {
            Solution.reset();
        } catch (Exception e) {

        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
        if(str.equals("helicopter")) {
            result = new Helicopter();
        } else if(str.equals("plane")) {
            int count = Integer.parseInt(reader.readLine());
            result = new Plane(count);
        }
        reader.close();
    }
}

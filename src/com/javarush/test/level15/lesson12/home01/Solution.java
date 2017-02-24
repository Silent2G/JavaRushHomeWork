package com.javarush.test.level15.lesson12.home01;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if(s.equals("exit")) break;
            list.add(s);
        }
        for(String s : list) {
            boolean digit = false;
            boolean dot = false;
            boolean string = false;
            char[] array = s.toCharArray();
            for(int i = 0; i < array.length; i++) {
                if(Character.isDigit(array[i])) {
                    digit = true;
                } else if(array[i] == '.') {
                    dot = true;
                } else if(array[i] != '-'){
                    string = true;
                }
            }
            if(digit && dot && !string) {
                double res = Double.parseDouble(s);
                print(res);
            } else if(digit && !dot && !string) {
                int res = Integer.parseInt(s);
                if(res > 0 && res < 128) {
                    print((short) res);
                } else if(res <= 0 || res >= 128) {
                    print(res);
                }
            } else if(string) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

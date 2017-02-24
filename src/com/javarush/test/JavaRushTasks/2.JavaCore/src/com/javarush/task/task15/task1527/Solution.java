package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String uRi = reader.readLine();
        reader.close();

        String text = "http://javarush.ru/alpha/index.html?obj=s5g/g&name=Amigo";
        Pattern p = Pattern.compile("[?][obj=]+[0-9a-zA-Z]*[.]*[0-9a-zA-Z]*|[?&][a-zA-Z]*");
        Matcher m = p.matcher(uRi);
        String res = "";
        Double alertDouble = null;
        String alertString = null;
        while (m.find()) {
            res =uRi.substring(m.start()+1, m.end());
            if(res.length() >= 3) {
                String obj = res.substring(0,3);
                if(obj.equals("obj")) {
                    System.out.print(obj + " ");
                    String number = res.substring(4);
                    try {
                        alertDouble = Double.parseDouble(number);
                    } catch (Exception e) {
                        alertString = number;
                    }
                } else {
                    System.out.print(res + " ");
                }
            } else {
                System.out.print(res + " ");
            }
        }
        System.out.println();
        if(alertDouble != null) {
            alert(alertDouble);
        } else if(alertString != null) {
            alert(alertString);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

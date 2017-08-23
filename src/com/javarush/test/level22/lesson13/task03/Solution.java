package com.javarush.test.level22.lesson13.task03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(checkTelNumber("6380501234")); // Вывод true
        System.out.println(checkTelNumber("(380)5012345")); // Вывод true
        System.out.println(checkTelNumber("+12(800)5012348")); // Вывод true
        System.out.println(checkTelNumber("+380501234578")); // Вывод true
        System.out.println(checkTelNumber("050ххх4567")); // Вывод false
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7")); // Вывод false
        System.out.println(checkTelNumber("+38)050(1234567")); // Вывод false
        System.out.println(checkTelNumber("050123456")); // Вывод false
        System.out.println(checkTelNumber("(0)501234567")); // Вывод false


    }

    public static boolean checkTelNumber(String telNumber) {
        String number = telNumber;
        int length = number.replaceAll("[^\\d]", "").length();

        if(length == 12) {
            Pattern p = Pattern.compile("^\\+{1}\\d*(\\(\\d{3}\\))?\\d*\\-?\\d+\\-?\\d+$");
            Matcher m = p.matcher(telNumber);
            return m.matches();
        } else if(length == 10){
            Pattern p = Pattern.compile("^\\d*(\\(\\d{3}\\))?\\d*\\-?\\d+\\-?\\d+$");
            Matcher m = p.matcher(telNumber);
            return m.matches();
        }

        return false;
    }
}

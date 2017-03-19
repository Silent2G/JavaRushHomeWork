package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        ArrayList<Integer> list = new ArrayList<Integer>();

        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            list.add(Integer.parseInt(result.substring(matcher.start(),matcher.end())));
        }
        System.setOut(consoleStream);
        Pattern pattern1 = Pattern.compile("[\\+\\-\\*]");
        Matcher matcher1 = pattern1.matcher(result);
        String sign = "";
        while (matcher1.find()) {
            sign = result.substring(matcher1.start(),matcher1.end());
        }

        Integer res = 0;
        if(sign.equals("+")) {
            res = list.get(0) + list.get(1);
        } else if(sign.equals("-")) {
            res = list.get(0) - list.get(1);
        } else if(sign.equals("*")) {
            res = list.get(0) * list.get(1);
        }
        result = result.substring(0,result.length()-2);
        System.out.println(result + " " + res.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("5 + 6 =");
        }
    }
}


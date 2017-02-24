package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        ArrayList<String> listString = new ArrayList<String>();
        ArrayList<Boolean> listTrueIfNumber = new ArrayList<Boolean>();
        //Разделение елементов массива на два листа: Интов и Стрингов, плюс наполняем Булеан лист для
        //                    сохранения порядка елементов в масиве, для дальнейшего вывода на екран.
        for(int i = 0; i < array.length; i++) {
            if(isNumber(array[i])) {
                listInteger.add(Integer.parseInt(array[i]));
                listTrueIfNumber.add(true);
            } else {
                listString.add(array[i]);
                listTrueIfNumber.add(false);
            }
        }
        // Сортировка листа Интов
        for(int i = 0; i < listInteger.size(); i++) {
            int max = listInteger.get(i);
            int max_i = i;
            for(int j = i+1; j < listInteger.size(); j++) {
                if(listInteger.get(j) > max) {
                    max = listInteger.get(j);
                    max_i = j;
                }
            }
            if(max_i != i) {
                int buffer = listInteger.get(max_i);
                listInteger.set(max_i, listInteger.get(i));
                listInteger.set(i, buffer);
            }
        }
        // Сортировка листа Стрингов
        for (int i = listString.size()-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(isGreaterThan(listString.get(j), listString.get(j+1))) {
                    String buffer = listString.get(j);
                    listString.set(j, listString.get(j+1));
                    listString.set(j+1, buffer);
                }
            }
        }
        // Заполняем наш массив обратно отсортированными элементами
        int countArray = 0;
        int countInt = 0;
        int countStr = 0;
        for(Boolean b : listTrueIfNumber) {
            if(b) {
                array[countArray] = listInteger.get(countInt).toString();
                countInt = ++countInt;
                countArray = ++countArray;
            } else {
                array[countArray] = listString.get(countStr);
                countStr = ++countStr;
                countArray = ++countArray;
            }
        }

}

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}

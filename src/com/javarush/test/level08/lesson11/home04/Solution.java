package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int count = 0;
        int number = 0;
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            if(count == 0) {
                number = iterator.next();
                count = ++count;
            }
            if(count > 1) {
                int next = iterator.next();
                if( next < number) {
                    number = next;
                }
            }
            count = ++count;
        }
        return number;
    }

    public static List<Integer> getIntegerList() throws IOException {
        List<Integer> list  = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int intN = Integer.parseInt(reader.readLine());
        for(int i = 0; i < intN; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        return list;
    }
}

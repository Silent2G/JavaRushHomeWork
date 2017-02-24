package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int[] array = {a,b,c,d,e};
        Solution.sortFive(array);
    }
    public static void sortFive(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
           int min = arr[i];
           int min_i = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if(i != min_i) {
                int buffer = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = buffer;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

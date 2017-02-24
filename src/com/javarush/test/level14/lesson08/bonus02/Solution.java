package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOne = Integer.parseInt(reader.readLine());
        int numberTwo = Integer.parseInt(reader.readLine());

        System.out.println(nOD(numberOne, numberTwo));
    }
    public static int nOD(int one, int two) {
        while(one != two) {
            if(one > two) {
                one = one - two;
             //   System.out.println(one);
            } else {
                two = two - one;
              //  System.out.println(two);
            }
        }
        return one;
    }
}

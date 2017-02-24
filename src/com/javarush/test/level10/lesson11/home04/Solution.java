package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] array = s.toCharArray();
        int charLength = array.length;
        int countI = 0;
        for(int i = 0; i < 40; i++) {
            char[] res = new char[charLength];
            for(int j = countI; j < array.length; j++) {
                res[j-countI] = array[j];
            }
            charLength = --charLength;
            countI = ++countI;
            String ss = new String(res);
            System.out.println(ss);
        }
    }

}

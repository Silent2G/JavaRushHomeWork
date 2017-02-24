package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 20;
        Integer b = 40;
        System.out.println(a);
        System.out.println(b);
    }

    public void print(int a) {
        System.out.println("int");
    }
    public void print(Integer a) {
        System.out.println("Integer");
    }
}

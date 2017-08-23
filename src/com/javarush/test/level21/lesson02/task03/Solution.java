package com.javarush.test.level21.lesson02.task03;

/* Все гениальное - просто!
Упростить. Переменные не переименовывать, комментарии не оставлять.
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = false;
        System.out.println(calculate(a,b,c,d));
        System.out.println(a && b && c && !d);
        System.out.println(!a && c);
        System.out.println(!b && c);
        System.out.println(c && d);
    }

}

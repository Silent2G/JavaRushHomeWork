package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }
    public int max(int a, int b) {int res; return res = (a > b) ?  a : b; }
    public long max(long a, long b) {long res; return res = (a > b) ?  a : b; }
    public double max(double a, double b) {double res; return res = (a > b) ?  a : b; }
}
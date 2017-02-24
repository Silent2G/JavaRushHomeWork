package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);
        int numberC = Integer.parseInt(c);
        Solution.lifeTriangle(numberA,numberB,numberC);

    }
    public static void lifeTriangle(int sideOne, int sideTwo, int sideThree) {

        int sumOne = sideOne + sideTwo;
        int sumTwo = sideTwo + sideThree;
        int sumThree = sideOne + sideThree;

        int count = 0;

        if(sumOne > sideThree) {
            count = ++count;
        }
        if(sumTwo > sideOne) {
            count = ++count;
        }
        if(sumThree > sideTwo) {
            count = ++count;
        }
        if(count == 3){
            System.out.println("Треугольник существует.");
        } else if(count < 3) {
            System.out.println("Треугольник не существует.");
        }
    }
}
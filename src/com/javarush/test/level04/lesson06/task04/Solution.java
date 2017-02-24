package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();

        equalsNames(nameOne,nameTwo);
    }
    public static void equalsNames (String a, String b) {
        if(a.equals(b) == true) {
            System.out.println("Имена идентичны");
        } else if(a.equals(b) == false && (a.length() == b.length())) {
            System.out.println("Длины имен равны");
        }
    }
}

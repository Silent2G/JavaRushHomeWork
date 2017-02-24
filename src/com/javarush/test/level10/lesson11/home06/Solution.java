package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        int weight;
        int height;
        String hair;

        Human() {}
        Human(String name) {
            this.name = name;
        }
        Human (int age) {
            this.age = age;
        }
        Human(boolean sex) {
            this.sex = sex;
        }
        Human(boolean sex, String hair) {
            this.sex = sex;
            this.hair = hair;
        }
        Human(boolean sex, String hair, int age) {
            this.sex = sex;
            this.hair = hair;
            this.age = age;
        }
        Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        Human(String name, int age, boolean sex, int weight) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }
        Human(String name, int age, boolean sex, int weight, int height) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }
        Human(String name, int age, boolean sex, int weight, int height, String hair) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.hair = hair;
        }


    }
}

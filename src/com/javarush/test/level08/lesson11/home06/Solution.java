package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> childrenChildren = new ArrayList<Human>();

        Human childOne = new Human("Suna", true, 25, childrenChildren);
        Human childTwo = new Human("JuniorSuna", true, 22, childrenChildren);
        Human childThree = new Human("Dochka", false, 19, childrenChildren);

        ArrayList<Human> children = new ArrayList<Human>();
        children.add(childOne);
        children.add(childTwo);
        children.add(childThree);

        Human father = new Human("Papa", true, 53, children);
        Human mother = new Human("Mama", false, 45, children);

        ArrayList<Human> childFatherLine = new ArrayList<Human>();
        childFatherLine.add(father);

        ArrayList<Human> childMotherLine = new ArrayList<Human>();
        childMotherLine.add(mother);

        Human grandFatherPapa = new Human("DedaPapa", true, 83, childFatherLine);
        Human grandFatherMama = new Human("DedaMama", true, 81, childMotherLine);

        Human grandMotherPapa = new Human("BabaPapa", false, 78, childFatherLine);
        Human grandMotherMama = new Human("BabaMama", false, 75, childMotherLine);

        System.out.println(childOne);
        System.out.println(childTwo);
        System.out.println(childThree);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(grandFatherPapa);
        System.out.println(grandFatherMama);
        System.out.println(grandMotherPapa);
        System.out.println(grandMotherMama);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFatherOne = new Human("Boris", true, 81, null, null);
        Human grandFatherTwo = new Human("Jonni", true, 75, null, null);

        Human grandMotherOne = new Human("Ania", false, 76, null, null);
        Human grandMotherTwo = new Human("Helga", false, 70, null, null);

        Human father = new Human("Vasia", true, 45, grandFatherOne, grandMotherOne);
        Human mother = new Human("Karolina", false, 40, grandFatherTwo, grandMotherTwo);

        Human sunOne = new Human("Rokky", true, 23, father, mother);
        Human sunTwo = new Human("Roman", true, 18, father, mother);
        Human daugter = new Human("Angela", false, 19, father, mother);

        System.out.println(grandFatherOne);
        System.out.println(grandFatherTwo);

        System.out.println(grandMotherOne);
        System.out.println(grandMotherTwo);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(sunOne);
        System.out.println(sunTwo);
        System.out.println(daugter);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}

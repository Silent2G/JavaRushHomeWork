package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }
    public Cat(String name, int age, int weight, int strength)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }
    public static void main(String[] args) {
        Cat cat1 = new Cat("Utilizator", 6,10,50);
        Cat cat2 = new Cat("Gelezobeton", 7,10,50);
        System.out.println(cat1.fight(cat2));
    }

    public boolean fight(Cat anotherCat)
    {
        boolean result = false;
        if(this.strength == anotherCat.strength && this.weight == anotherCat.weight && this.age == anotherCat.age) {
            System.out.println("Ничья");
        }
        if(this.strength > anotherCat.strength && this.weight > anotherCat.weight) {
            result = true;
        } else if(this.strength == anotherCat.strength && this.weight == anotherCat.weight) {
            if(this.age < anotherCat.age && this.age >=4) {
                result = true;
            } else if(this.age > anotherCat.age && anotherCat.age >=4) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
}

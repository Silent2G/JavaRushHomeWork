package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name = null;
    int weight;
    int age;
    String color = null;
    String adress = null;

    Cat(String name) {
        this.name = name;
    }
    Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 10;
    }
    Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.adress = null;
        this.age = 5;
    }
    Cat(int weight, String color, String adress) {
        this.weight = weight;
        this.color = color;
        this.adress = adress;
        this.name = null;
        this.age = 5;
    }
}

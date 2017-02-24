package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    double top;
    double left;
    double width;
    double height;

    Rectangle(double left, double top, double width, double height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    Rectangle(double left, double top, double width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }
    Rectangle(double left, double top) {
        this.left = left;
        this.top = top;
        this.width = 0;
        this.height = 0;
    }
    Rectangle(Rectangle object) {
        this.left = object.left;
        this.top = object.top;
        this.width = object.width;
        this.height = object.height;
    }

}

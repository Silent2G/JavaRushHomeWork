package com.javarush.test.level21.lesson16.big01;

/**
 * Created by admin on 06.04.2017.
 */
public class Horse
{
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;

    }
    public void move() {
        distance += speed * Math.random();
    }
    public void print() {
        for(int i = 0; i < distance; i++) {
            System.out.print(".");
        }
        System.out.println(getName());
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public String getName()
    {

        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

}

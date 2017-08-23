package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by admin on 06.04.2017.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;
    public static void main(String[] main) throws InterruptedException {
        game = new Hippodrome();
        Horse horseBella = new Horse("Bella", 3,0);
        Horse horseJhonny = new Horse("Jhonny", 3,0);
        Horse horseTurbo = new Horse("Turbo", 3,0);

        game.getHorses().add(horseBella);
        game.getHorses().add(horseJhonny);
        game.getHorses().add(horseTurbo);

        game.run();
        game.printWinner();
    }
    public ArrayList<Horse> getHorses() {
        return horses;
    }
    public void move() {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }
    public void run() throws InterruptedException{
        for(int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void print() {
        for(Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner() {
        int length = getHorses().size();
        double max = getHorses().get(0).distance;
        Horse result = null;
        for(int i = 0; i < length; i++) {
            if(getHorses().get(i).distance > max) {
                result = getHorses().get(i);
            }
        }
        return result;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}

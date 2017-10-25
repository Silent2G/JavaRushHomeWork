package com.javarush.test.level26.lesson15.big01.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 26.09.2017.
 */
class ExitCommand implements Command
{
    @Override
    public void execute()
    {
        System.out.println("Do you really want to EXIT ? Y/N");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String exit = reader.readLine();
                exit = exit.toUpperCase();
                if(exit.equals("Y")) {
                    System.out.println("Bye");
                    break;
                }
            }
            reader.close();

        } catch (IOException e) {}


    }
}

package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 25.09.2017.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {}

        return line;
    }
    public static String askCurrencyCode() throws IOException{

        boolean switcher = false;
        String currency = null;

        System.out.println("Enter currency please");

        while (!switcher) {
            currency = reader.readLine();
            if(currency.length() == 3) {
                switcher = true;
            } else {
                System.out.println("Wrong arguments, enter currency please");
            }
        }
        currency = currency.toUpperCase();

        return currency;
    }
    public static String[] getValidTwoDigits(String currencyCode) throws IOException {
        String[] res = null;
        System.out.println("Enter two numbers please");
        boolean switcher = true;

        String line = null;
        while (switcher) {
            line = reader.readLine();
            res = line.split(" ");

            switcher = false;
            if(res.length != 2) {
                switcher = true;
            } else {
                try {
                    int one = Integer.parseInt(res[0]);
                    int two = Integer.parseInt(res[1]);

                    if(one <= 0 || two <= 0) {
                        switcher = true;
                    }
                } catch (Exception e) {
                    switcher = true;
                }
            }
            if(switcher) {
                System.out.println("Wrong parameters, Enter two numbers please");
            }
        }

        return res;
    }
    public static Operation askOperation() throws IOException {

        while(true)
        {
            int chose = 0;
            System.out.println("Chose Operation: ");
            try {
                chose = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                continue;
            }

            try {
                return Operation.getAllowableOperationByOrdinal(chose);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }
}

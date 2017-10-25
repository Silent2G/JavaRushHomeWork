package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

/**
 * Created by admin on 26.09.2017.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
         //   String currencyCode = ConsoleHelper.askCurrencyCode();
          //  CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
          //  System.out.println(manipulator.getTotalAmount());

            Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
            if(collection.isEmpty())
                System.out.println("No money available.");
            for(CurrencyManipulator manipulator : collection) {
                if(manipulator.hasMoney()) {
                    System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                } else {
                    System.out.println("No money available.");
                }
            }

    }
}

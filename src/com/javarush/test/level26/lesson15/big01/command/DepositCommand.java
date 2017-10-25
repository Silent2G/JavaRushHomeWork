package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.io.IOException;

/**
 * Created by admin on 26.09.2017.
 */
class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        try {

            String currencyCode = ConsoleHelper.askCurrencyCode();
            String[] res = ConsoleHelper.getValidTwoDigits(currencyCode);
            CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            manipulator.addAmount(Integer.parseInt(res[0]), Integer.parseInt(res[1]));

        } catch (IOException e) {}


    }
}

package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by admin on 25.09.2017.
 */
public class CurrencyManipulatorFactory
{
    private static HashMap<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if(currencyManipulators.get(currencyCode) != null) {
            return currencyManipulators.get(currencyCode);
        } else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, manipulator);
            return manipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return currencyManipulators.values();
    }
}

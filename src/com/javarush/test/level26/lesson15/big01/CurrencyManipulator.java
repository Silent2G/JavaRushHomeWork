package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 25.09.2017.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        int wholeAmmount = denominations.get(denomination) != null ? denominations.get(denomination) + count : count;
        denominations.put(denomination, wholeAmmount);
    }

    public int getTotalAmount() {
        int count = 0;
        for(Integer key : denominations.keySet()) {
            count += key * denominations.get(key);
        }
        return count;
    }
    public boolean hasMoney() {
        int tmp = 0;
        for (Integer value : denominations.values()) {
            tmp += value; //Only for !0 check
        }
        return tmp != 0;
    }
}

package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int startSub = 0;
        int endSub = 0;
        if(string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        if((startSub = string.indexOf("\t")) > -1) {
           if((endSub = string.indexOf("\t", startSub + 1)) > -1) {
               return string.substring(startSub + 1, endSub);
           }
        }
        if(startSub == -1 || endSub == -1) {
            throw new TooShortStringException();
        }
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        try {
           // System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
           // System.out.println(getPartOfString("\t\t"));                    //
            System.out.println(getPartOfString("123\t123"));                //Exception
           // System.out.println(getPartOfString(null));                      //Exception
        } catch (TooShortStringException e) {
            System.out.println("exception");
        }
    }
}

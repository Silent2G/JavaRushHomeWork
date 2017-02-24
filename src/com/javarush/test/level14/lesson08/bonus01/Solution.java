package com.javarush.test.level14.lesson08.bonus01;

import javax.security.sasl.SaslException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

import static sun.misc.Unsafe.getUnsafe;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            int[] array = new int[5];
            array[5] = 10;
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            FileReader reader = new FileReader("C:\\SomeDir\\notes3.txt");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            Object[] array = new Object[5];
            array[0] = "Stas";
            Integer i = (Integer) array[0];
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            Double d = null;
            Math.round(d);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            getUnsafe();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            String five = "five";
            int i = Integer.parseInt(five);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            throw new IOException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            throw new SaslException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------------------------------------------------------------
        try
        {
            throw new RuntimeException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

    }
}

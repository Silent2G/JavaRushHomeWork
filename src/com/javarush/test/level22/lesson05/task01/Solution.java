package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        int count = 0;
        int index = -1;
        int startSubstring = 0;
        int endSubString = 0;

        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }

            for (int i = 0; i < 5; i++)
            {
                if (index == -1)
                {
                    index = string.indexOf(' ');
                }
                if (index > -1)
                {
                    count++;
                    if (count == 1)
                    {
                        startSubstring = index;
                    }
                    if (count == 4)
                    {
                        if ((index = string.indexOf(' ', index + 1)) == -1)
                        {
                            endSubString = string.length();
                        } else
                        {
                            endSubString = index;
                        }
                    }
                    if (count < 4)
                    {
                        if (string.indexOf(' ', index + 1) > index)
                        {
                            index = string.indexOf(' ', (index + 1));
                        } else
                        {
                            index = -2;
                        }
                    }

                }
            }
            if (count < 4)
            {
                throw new TooShortStringException();
            } else if (count >= 4)
            {
                return string.substring(startSubstring + 1, endSubString);
            }
        return null;
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        try
        {
            System.out.println(getPartOfString("today is a very good day!"));
        }
        catch (TooShortStringException e)
        {
            System.out.println("exception");
        }
        // System.out.println("Today is a very good day !".indexOf(" "));
    }
}

package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<String>();
        words.add("Georgiy");
        words.add("Stas");
        words.add("Evgeniy");
        words.add("Artem");
        words.add("Dmitriy");

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }

    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        boolean rBool;
        boolean lBool;
        int size = list.size();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < size; i++) {
            char [] array = list.get(i).toCharArray();
            rBool = false;
            lBool = false;
            for(int j = 0; j < array.length; j++) {
                if(array[j] == 'р') {
                    rBool = true;
                } else if(array[j] == 'л') {
                    lBool = true;
                }
            }
            if(rBool == true && lBool == false) {
                // тут нічього не має виконуватись
            }   else if (rBool == false && lBool == true) {
                result.add(list.get(i));
                result.add(list.get(i));
            } else {
                result.add(list.get(i));
            }
        }
        return result;
    }
}
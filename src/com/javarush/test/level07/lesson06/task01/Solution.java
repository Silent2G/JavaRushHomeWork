package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Stas");
        arrayList.add("Java");
        arrayList.add("junior");
        arrayList.add("developer");
        arrayList.add("now !");

        System.out.println(arrayList.size());
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

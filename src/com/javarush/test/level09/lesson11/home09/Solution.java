package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Myrzik", new Cat("Myrzik"));
        map.put("Sharik", new Cat("Sharik"));
        map.put("Tuzik", new Cat("Tuzik"));
        map.put("Gorik", new Cat("Gorik"));
        map.put("Slonik", new Cat("Slonik"));
        map.put("Viskas", new Cat("Viskas"));
        map.put("Boris", new Cat("Boris"));
        map.put("Arnold", new Cat("Arnold"));
        map.put("Barsik", new Cat("Barsik"));
        map.put("Tomas", new Cat("Tomas"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new HashSet<Cat>();
        Iterator<Map.Entry<String, Cat>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cat> pair = iterator.next();
            Cat cat = pair.getValue();
            set.add(cat);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}

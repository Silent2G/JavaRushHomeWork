package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Nesh", "Jhon");
        map.put("Rebot", "Pit");
        map.put("Extra", "Brus");
        map.put("Bull", "Pit");
        map.put("Bush", "Jordg");
        map.put("Putin", "Vova");
        map.put("Next", "Jhon");
        map.put("Li", "Jhon");
        map.put("Brad", "Pit");
        map.put("Exkrement", "Vova");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            if(name.equals(value)) {
                count = ++count;
            }
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            if(lastName.equals(key)) {
                count = ++count;
            }
        }
        return count;

    }
  /*  public static void main(String[] args) {
        HashMap map = createMap();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
        System.out.println(getCountTheSameFirstName(map, "Pit"));
        System.out.println(getCountTheSameLastName(map, "Putin"));
    } */
}

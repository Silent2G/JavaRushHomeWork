package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> mapResult = new HashMap<String, String>();
        HashMap<String, String> mapTwo = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            int count = 0;
            Iterator<Map.Entry<String, String>> iteratorTwo = mapTwo.entrySet().iterator();
            while(iteratorTwo.hasNext()) {
                Map.Entry<String, String> pairTwo = iteratorTwo.next();
                String valueTwo = pairTwo.getValue();
                if(value.equals(valueTwo)) {
                    count = ++count;
                }
            }
            if(count == 1) {
                mapResult.put(key, value);
            } //else if (count >= 2) {
               // removeItemFromMapByValue(map, value);
           // }
        }
        map.clear();
        map.putAll(mapResult);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
           // String key = pair.getKey();
            String valueTwo = pair.getValue();
            if(valueTwo.equals(value)) {
                iterator.remove();
                System.out.println(" remove ");
            }
        }
        map.clear();
        map.putAll(copy);
       /* for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }*/
    }
    public static void main(String[] args) {
        HashMap map = createMap();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
        removeTheFirstNameDuplicates(map);
        System.out.println("-------");
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();
        while(iterator2.hasNext()) {
            Map.Entry<String, String> pair = iterator2.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}

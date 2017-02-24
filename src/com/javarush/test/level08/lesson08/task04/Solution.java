package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Vorobiov", new Date("SEPTEMBER 1 1990"));
        map.put("Gricishun", new Date("APRIL 14 1992"));
        map.put("Krasniak", new Date("OCTOBER 9 1990"));
        map.put("Shpulko", new Date("DECEMBER 19 1933"));
        map.put("Nesh", new Date("JULY 1 1960"));
        map.put("Pupkin", new Date("AUGUST 8 1991"));
        map.put("Programmer", new Date("DECEMBER 18 2016"));
        map.put("Putin", new Date("AUGUST 23 1950"));
        map.put("Marley", new Date("AUGUST 22 1991"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            if(pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7) {
                iterator.remove();
            }
        }
    }
  /*  public static void main(String[] args) {
        HashMap map = createMap();
        removeAllSummerPeople(map);
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            Date date = pair.getValue();
            System.out.println(key + " - " + date);
        }
    }*/
}

package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name);

        ArrayList<Integer> bytes = new ArrayList<Integer>();
        HashMap<Integer,Integer> map  = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            bytes.add(inputStream.read());
        }
        inputStream.close();
        int countOne = 0;

        for(int i = 0; i < bytes.size(); i++) {
            int res = Collections.frequency(bytes, bytes.get(i));
            if(res > countOne) {
                if(map.size() == 0) {
                    map.put(bytes.get(i), res);
                    countOne = res;
                } else if(map.size() > 0) {
                    map.clear();
                    map.put(bytes.get(i), res);
                    countOne = res;
                }
            } else if(res == countOne) {
                map.put(bytes.get(i), res);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            Integer key = pair.getKey();
            System.out.println(key + " ");
        }
    }
}

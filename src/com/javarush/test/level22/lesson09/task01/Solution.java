package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(name),"UTF-8"));
        ArrayList<String> line = new ArrayList<String>();

        while(in.ready()){
            line.addAll(Arrays.asList((in.readLine().split(" "))));
        }
        in.close();

        HashMap<String, String> map = new HashMap<String, String>();

        for(int i = 0; i < line.size(); i++) {
           for(int j = i+1; j < line.size(); j++) {
               if(line.get(i).equals((new StringBuilder(line.get(j)).reverse()).toString())) {
                   if(!map.containsKey(line.get(j)) && !map.containsValue(line.get(i))) {
                       map.put(line.get(i), line.get(j));
                       break;
                   }
               }
           }
        }

        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, String> pair = iter.next();
            String key = pair.getKey();
            String value = pair.getValue();
            result.add(new Pair(key, value));
        }

        for(Pair p : result) {
            System.out.println(p.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static void main(String[] args) throws Exception{
        new Solution().fillInPropertiesMap();
    }

    public void fillInPropertiesMap() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        File file = new File(name);
        FileInputStream fileInputStream = new FileInputStream(file);
        Solution s = new Solution();
        s.load(fileInputStream);

        //FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Admin/Desktop/b.txt");
        //s.save(fileOutputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();

        for(Map.Entry<String,String> pair :properties.entrySet()) {
            prop.put(pair.getKey(),pair.getValue());
        }
        prop.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);

        for(Map.Entry<Object,Object> pair : prop.entrySet()) {
            properties.put((String) pair.getKey(),(String)pair.getValue());
        }
    }
}

package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        try {
            String line;

            while(!(line = reader.readLine()).equals("exit")){
                list.add(line);
            }
            reader.close();
            for(String s : list){
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();
            }
        } catch (Exception ignored){}

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (fileInputStream.available() > 0){
                    list.add(fileInputStream.read());
                }
                fileInputStream.close();

                int max = 0;
                int byteNumber = 0;
                int count;

                for(int i = 0; i < list.size(); i++){
                    count = Collections.frequency(list, list.get(i));
                    System.out.println(count);
                    if(count > max) {
                        max = count;
                        byteNumber = list.get(i);
                    }
                }

                resultMap.put(fileName, byteNumber);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
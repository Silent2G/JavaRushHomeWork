package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        String nameOne = null;
        String nameTwo = null;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            nameOne = reader.readLine();//"C:/Users/Admin/Desktop/a.txt";
            nameTwo = reader.readLine();//"C:/Users/Admin/Desktop/b.txt";
            reader.close();


            BufferedReader readerFiles = new BufferedReader(new FileReader(nameOne));
            String line;
            while ((line = readerFiles.readLine()) != null)
            {
                allLines.add(line);
            }
            readerFiles.close();
            readerFiles = new BufferedReader(new FileReader(nameTwo));
            while ((line = readerFiles.readLine()) != null)
            {
                forRemoveLines.add(line);
            }
            readerFiles.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try
        {
            new Solution().joinData();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void joinData () throws CorruptedDataException, IOException {
        int countTrue = 0;
        for(int i = 0; i < forRemoveLines.size(); i++) {
            for(int j = 0; j < allLines.size(); j++) {
                if(forRemoveLines.get(i).equals(allLines.get(j))) {
                    countTrue = ++countTrue;
                    break;
                }
            }
        }
        if(countTrue == forRemoveLines.size()) {
            for(int i = 0; i < forRemoveLines.size(); i++) {
                for(int j = 0; j < allLines.size();) {
                    if(forRemoveLines.get(i).equals(allLines.get(j))) {
                        allLines.remove(j);
                    } else j++;
                }
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

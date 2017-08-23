package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] array = new byte[fileInputStream.available()];
        fileInputStream.read(array);
        String s  = new String(array);
        byte[] buffer = s.getBytes("Windows-1251");
        String result = new String(buffer);
       // System.out.println(result);

        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] bufferWrite = result.getBytes("UTF-8");
        fileOutputStream.write(bufferWrite);
    }
}

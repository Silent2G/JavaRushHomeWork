package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        public Person read() throws IOException {
            String[] array  = scanner.nextLine().split(" ");
            Calendar date = new GregorianCalendar(Integer.parseInt(array[5]), Integer.parseInt(array[4])-1, Integer.parseInt(array[3]));
            return new Person(array[1],array[2],array[0], date.getTime());
        }

        public void close() throws IOException {
            scanner.close();
        }

    }


}

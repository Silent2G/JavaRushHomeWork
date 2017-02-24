package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    public static void main(String[] args) throws InterruptedException{
     //   ThreadOne one = new ThreadOne();
      //  ThreadTwo two = new ThreadTwo();
       // ThreadThree three = new ThreadThree();
     //   ThreadFour four = new ThreadFour();
      //  ThreadFive five = new ThreadFive();
      //  four.start();
       // System.out.println(four.isAlive());
      //  four.showWarning();
     //   Thread.sleep(1000);
      //  two.interrupt();
     //   System.out.println(four.isAlive());
    }
    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }
    public static class ThreadOne extends Thread {
        public void run() {
            while (true) {}
        }
    }
    public static class ThreadTwo extends Thread {
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {

            }
            System.out.println("InterruptedException");
        }
    }
    public static class ThreadThree extends Thread {
        public void run() {
            try {
                while (true){
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static class ThreadFour extends Thread implements Message{
        public void run () {
            while (!Thread.interrupted()) {}
        }

        @Override
        public void showWarning()
        {
            try
            {
                this.interrupt();
                this.join();
            } catch (InterruptedException e) {}
        }
    }
    public static class ThreadFive extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String symbol = "";
            int numbers = 0;
            while(true) {
                try
                {
                    symbol = reader.readLine();
                    if (symbol.equals("N"))
                    {
                        reader.close();
                        break;
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
                numbers += Integer.parseInt(symbol);
            }
            System.out.println(numbers);

        }
    }
}

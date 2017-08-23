package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        Solution solution = new Solution(5);

        File file = new File("C:/Users/Admin/Desktop/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(solution);
        fileOutputStream.close();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution loaded = (Solution)ois.readObject();
        fileInputStream.close();
        ois.close();

    }

    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        try
        {
            int i = 0;
            while (true)
            {
                Thread.sleep(1000);
                i = i+1;
                System.out.println(i);
                if(i == 5) {
                    System.out.println("end");
                    break;
                }
            }
        }catch (InterruptedException e) {
            e.getMessage();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, InterruptedException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }
}

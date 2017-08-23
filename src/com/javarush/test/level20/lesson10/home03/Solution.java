package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";
        public A() {}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream stream) throws IOException{
            stream.defaultWriteObject();
            stream.writeObject(this.name);
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
            stream.defaultReadObject();
            this.name = (String) stream.readObject();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        File file = new File("C:/Users/Admin/Desktop/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileInputStream fileInputStream = new FileInputStream(file);

        Solution solution = new Solution();
        B b = solution.new B("Burn");
        System.out.println(b.name);

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(b);
        fileOutputStream.close();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        B bb = (B) ois.readObject();
        fileInputStream.close();
        ois.close();
        System.out.println(bb.name);
    }
}

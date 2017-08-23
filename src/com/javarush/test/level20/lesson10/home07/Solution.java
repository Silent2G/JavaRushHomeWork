package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String name;

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution("C:/Users/Admin/Desktop/a.txt");
        solution.writeObject("bla bla bla");

        File file = new File("C:/Users/Admin/Desktop/b.txt");

        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        oos.writeObject(solution);
        solution.close();

        Solution loaded = (Solution) ois.readObject();
        ois.close();

        loaded.writeObject("zero");
    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.name = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

      //  out.writeObject(sol);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.name, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}

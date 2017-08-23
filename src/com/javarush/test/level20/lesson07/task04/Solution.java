package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        try
        {
            File file = new File("C:/Users/Admin/Desktop/a.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream fileInputStream = new FileInputStream(file);

            Solution savedObject = new Solution(10);

            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(savedObject);
            fileOutputStream.close();
            oos.close();

            Solution loadedObject = new Solution(25);

            System.out.println(loadedObject);

            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            loadedObject = (Solution) ois.readObject();
            fileInputStream.close();
            ois.close();

            System.out.println(savedObject.string);
            System.out.println(loadedObject.string);
            System.out.println(loadedObject.temperature);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      //  System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
   // private static Date freshDate;
    private transient int temperature;
   // private static int temp;
    String string;

   // public Solution(){}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;
     //   Solution.temp = temperature;
     //   Solution.freshDate = this.currentDate;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
    /*
    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(pattern);
        out.writeObject(currentDate);
        out.writeInt(temperature);
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        SimpleDateFormat format = new SimpleDateFormat(this.pattern);
        this.string = String.format("Today is %s, and current temperature is %s C", format.format(Solution.freshDate), Solution.temp);
    } */
}

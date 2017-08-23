package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person() {
            this.greetingString = "Hello, ";
        }

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
        private void writeObject(ObjectOutputStream stream) throws IOException{
            stream.defaultWriteObject();
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
            stream.defaultReadObject();
            //this.outputStream = System.out;
            //this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:/Users/Admin/Desktop/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileInputStream fileInputStream = new FileInputStream(file);

        Person person = new Person("Stanislav","Vorobiov","Ukraine", Sex.MALE);

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(person);
        fileOutputStream.close();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Person loaded = (Person) ois.readObject();
        fileInputStream.close();
        ois.close();

    }
}

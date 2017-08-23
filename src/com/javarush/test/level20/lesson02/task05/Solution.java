package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("C:/Users/Admin/Desktop/a.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String(); //string #1
            object.string2 = new String(); //string #2

            Object object1 = new Object();
            object1.string1 = new String(); //string #3
            object1.string2 = new String(); //string #4

            Object object2 = new Object();
            object2.string1 = new String(); //string #5
            object2.string2 = new String(); //string #6

            Object object3 = new Object();
            object3.string1 = new String(); //string #7
            object3.string2 = new String(); //string #8

            Object object4 = new Object();

            object4.string2 = new String(); //string #9

            object4.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String();   //string #10
            loadedObject.string2 = new String();   //string #11

          //  System.out.println(loadedObject.string1);
          //  System.out.println(loadedObject.string2);
            loadedObject.string1.print();
            loadedObject.string2.print();

            loadedObject.load(inputStream);

            System.out.println(loadedObject.string1);
           // loadedObject.string1.print();
            loadedObject.string2.print();

            System.out.println(Solution.countStrings);

            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            System.out.println(object.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.string1 != null) {
                writer.println(this.string1.number);
            } else writer.println("null");
            if (this.string2 != null) {
                writer.println(this.string2.number);
            } else writer.println("null");
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            java.lang.String line;
            int count = Solution.countStrings;
            if(!"null".equals(line = reader.readLine())) {
                int number = Integer.parseInt(line);
                Solution.countStrings = --number;
                this.string1 = new String();
            } else {
                this.string1 = null;
            }
            if(!"null".equals(line = reader.readLine())) {
                int number = Integer.parseInt(line);
                Solution.countStrings = --number;
                this.string2 = new String();
            } else {
                this.string2 = null;
            }
            Solution.countStrings = count;
            reader.close();
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}

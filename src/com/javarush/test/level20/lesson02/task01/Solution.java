package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if(ivanov.equals(somePerson))
                System.out.println(true);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {

        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public boolean equals(Object obj)
        {
            if(this == obj) {
                return true;
            }
            if(obj == null) {
                return false;
            }
            if(this.getClass() != obj.getClass()) {
                return false;
            }
            Human h = (Human) obj;

            if(!h.name.equals(this.name)) {
                return false;
            }
            if(h.assets.size() == this.assets.size()) {
                for(int i = 0; i < this.assets.size(); i++) {
                    if(!(h.assets.get(i).getName().equals(this.assets.get(i).getName()))) {
                        return false;
                    }
                    if(!(h.assets.get(i).getPrice() == this.assets.get(i).getPrice())) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String isNameNotNull = name != null ? "yes" : "no";
            writer.println(isNameNotNull);

            writer.println(name);

            int lenght = assets.size();
            writer.println(lenght);

            for(int i = 0; i < lenght; i++) {
                writer.println(assets.get(i).getName());
                writer.println(assets.get(i).getPrice());
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isAssetPresent = reader.readLine();

            if(isAssetPresent.equals("yes")) {
                name = reader.readLine();
                int length = Integer.parseInt(reader.readLine());

                for(int i = 0; i < length; i++) {
                   Asset asset = new Asset(reader.readLine());
                   asset.setPrice(Double.parseDouble(reader.readLine()));
                   assets.add(asset);
                }
            }
            reader.close();
        }
    }
}

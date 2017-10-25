package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("C:/Users/Admin/Desktop/a.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User userOne  = new User();
            userOne.setFirstName("Vorobiov");
            userOne.setLastName("Stanislav");
            userOne.setMale(true);
            userOne.setBirthDate(new Date(1990,8,01));
            userOne.setCountry(User.Country.UKRAINE);

            User userTwo  = new User();
            userTwo.setFirstName("Nesh");
            userTwo.setLastName("John");
            userTwo.setMale(true);
            userTwo.setBirthDate(new Date(1969,7,11));
            userTwo.setCountry(User.Country.OTHER);

            User userThree  = new User();
            userThree.setFirstName("Iron");
            userThree.setLastName("Rebeka");
            userThree.setMale(false);
            userThree.setBirthDate(new Date(1988,9,27));
            userThree.setCountry(User.Country.RUSSIA);

            javaRush.users.add(userOne);
            javaRush.users.add(userTwo);
            javaRush.users.add(userThree);

           // System.out.println(javaRush.users.get(0).getBirthDate());

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsersNotEmpty = this.users.size() > 0 ? "yes" : "no";
            writer.println(isUsersNotEmpty);
            if(this.users.size() > 0) {
                writer.println(this.users.size());
                for(int i = 0; i < this.users.size(); i++) {
                    String isGetFirstNameNotNull = this.users.get(i).getFirstName() != null ? "yes" : "no";
                    writer.println(isGetFirstNameNotNull);
                    if(isGetFirstNameNotNull.equals("yes"))
                        writer.println(this.users.get(i).getFirstName());

                    String isGetLastNameNotNull = this.users.get(i).getLastName() != null ? "yes" : "no";
                    writer.println(isGetLastNameNotNull);
                    if(isGetLastNameNotNull.equals("yes"))
                        writer.println(this.users.get(i).getLastName());

                    String isGetBirthDateNotNull = this.users.get(i).getBirthDate() != null ? "yes" : "no";
                    writer.println(isGetBirthDateNotNull);
                    if(isGetBirthDateNotNull.equals("yes")) {
                        writer.println(this.users.get(i).getBirthDate().getYear());
                        writer.println(this.users.get(i).getBirthDate().getMonth());
                        writer.println(this.users.get(i).getBirthDate().getDate());
                    }

                    writer.println(this.users.get(i).isMale());

                    String isGetCountryNotNull = this.users.get(i).getCountry() != null ? "yes" : "no";
                    writer.println(isGetCountryNotNull);
                    if(isGetCountryNotNull.equals("yes"))
                        writer.println(this.users.get(i).getCountry().getDisplayedName());

                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersNotEmpty = reader.readLine();
            if(isUsersNotEmpty.equals("yes")) {
                int usersLength = Integer.parseInt(reader.readLine());
                for(int i = 0; i < usersLength; i++) {
                    User user = new User();
                    if("yes".equals(reader.readLine())) {
                        user.setFirstName(reader.readLine());
                    }
                    if("yes".equals(reader.readLine())) {
                        user.setLastName(reader.readLine());
                    }
                    if("yes".equals(reader.readLine())) {
                        user.setBirthDate(new Date(Integer.parseInt(reader.readLine()),
                                Integer.parseInt(reader.readLine()),
                                Integer.parseInt(reader.readLine())));
                    }
                    user.setMale("true".equals(reader.readLine()));
                    if("yes".equals(reader.readLine())) {
                        String country = reader.readLine();
                        if(User.Country.UKRAINE.getDisplayedName().equals(country)) {
                            user.setCountry(User.Country.UKRAINE);
                        } else if(User.Country.RUSSIA.getDisplayedName().equals(country)) {
                            user.setCountry(User.Country.RUSSIA);
                        } else if(User.Country.OTHER.getDisplayedName().equals(country)) {
                            user.setCountry(User.Country.OTHER);
                        }
                    }
                    this.users.add(user);
                }
            }
            reader.close();
        }
    }
}

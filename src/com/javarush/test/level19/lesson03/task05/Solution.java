package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        public String getCountryCode() {
            String value = customer.getCountryName();
            String res = "";
            Iterator<Map.Entry<String,String>> iterator = countries.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry<String, String> pair = iterator.next();
                if(pair.getValue().equals(value)) {
                    res = pair.getKey();
                }
            }
            return res;
        }
        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }
        public String getDialString() {
            String s = contact.getPhoneNumber();
            char[] array = s.toCharArray();
            String res = "";
            for(int i = 0; i < array.length; i++) {
                if(Character.isDigit(array[i])) {
                    res += array[i];
                }
            }
            return "callto://+" + res;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
    public static void main(String[] args) {
        Customer customer = new Customer() {
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            public String getName() {
                return "Ivanov, Ivan";
            }

            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        RowItem rowItem = new DataAdapter(customer, contact);
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
    }
}
package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String [] args)
    {
        class iData implements IncomeData
        {
            String countryCode = "UA";
            String company = "JavaRush Ltd.";
            String firstName = "Ivan";
            String lastName = "Ivanov";
            int phoneCode = 38;
            int numPhone = 501234567;

            @Override
            public String getCountryCode()
            {
                return countryCode;
            }

            @Override
            public String getCompany()
            {
                return company;
            }

            @Override
            public String getContactFirstName()
            {
                return firstName;
            }

            @Override
            public String getContactLastName()
            {
                return lastName;
            }

            @Override
            public int getCountryPhoneCode()
            {
                return phoneCode;
            }

            @Override
            public int getPhoneNumber()
            {
                return numPhone;
            }
        }

        IncomeDataAdapter ap = new IncomeDataAdapter(new iData());
        System.out.println(ap.getName());
        System.out.println(ap.getCompanyName());
        System.out.println(ap.getCountryName());
        System.out.println(ap.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }
        public String getCompanyName() {
            return incomeData.getCompany();
        }
        public String getCountryName() {
            return countries.get(incomeData.getCountryCode());
        }
        public String getName() {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }
        public String getPhoneNumber() {
            int n = incomeData.getPhoneNumber();
            String number = String.format("%010d%n", n);
            return "+" + incomeData.getCountryPhoneCode() + "(" + number.substring(0,3) + ")" + number.substring(3,6)
                    + "-" + number.substring(6,8) + "-" + number.substring(8,10);
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
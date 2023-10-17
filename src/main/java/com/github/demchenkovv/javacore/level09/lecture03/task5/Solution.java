package com.github.demchenkovv.javacore.level09.lecture03.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();
            String countryCode = null;
            Optional<String> country = countries.entrySet().stream()
                    .filter(e -> e.getValue().equals(countryName))
                    .map(Map.Entry::getKey)
                    .findFirst();
            if (country.isPresent()) {
                countryCode = country.get();
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] splitted = contact.getName().split(", ");
            return splitted[1];
        }

        @Override
        public String getContactLastName() {
            String[] splitted = contact.getName().split(", ");
            return splitted[0];
        }

        @Override
        public String getDialString() {
            String phoneNum = contact.getPhoneNumber().replaceAll("\\D+", "");
            String dialString = "callto://+" + phoneNum;
            return dialString;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
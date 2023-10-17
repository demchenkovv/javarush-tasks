package com.github.demchenkovv.javacore.level09.lecture03.task3;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

// Помогло в использовании групп для регулярных выражений:
// https://stackoverflow.com/questions/5114762/how-do-format-a-phone-number-as-a-string-in-java

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", this.data.getContactLastName(), this.data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            int countryCode = this.data.getCountryPhoneCode();
            int phoneNumber = this.data.getPhoneNumber();
            String unformattedPhone = String.format("%010d", phoneNumber);
            String formattedPhoneNumber = "+" + countryCode + unformattedPhone.replaceFirst("(\\d{3})(\\d{3})(\\d{2})(\\d{2})$", "($1)$2-$3-$4");
            return formattedPhoneNumber;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}
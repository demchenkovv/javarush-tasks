package com.github.demchenkovv.javasyntaxzero.level16.lecture02.task2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Карманный телепорт
*/

public class Solution {

    public static final String INVENTED = "Пожалуйста, можете забрать ваш карманный телепорт. Спасибо за ожидание!";
    public static final String NOT_INVENTED = "Извините, телепорт еще не изобрели, приходите через 10 лет.";

    public static final Calendar INVENTION_DAY = new GregorianCalendar(2192, Calendar.JUNE, 12);

    public static void main(String[] args) {
        Calendar currentDay = Calendar.getInstance();
        //напишите тут ваш код
        boolean isTrue = isTeleportInvented(currentDay);
        while (!isTrue) {
            currentDay.add(Calendar.YEAR, 10);
            isTrue = isTeleportInvented(currentDay);
        }
    }

    static boolean isTeleportInvented(Calendar currentDay) {
        //напишите тут ваш код
        if (currentDay.before(INVENTION_DAY)) {
            System.out.println(NOT_INVENTED);
            return false;
        } else {
            System.out.println(INVENTED);
            return true;
        }
    }
}

/*
В классе Solution константа INVENTION_DAY содержит дату изобретения нового популярного гаджета — карманного телепорта.

Реализуй метод isTeleportInvented, который в качестве параметра принимает дату и сравнивает ее с INVENTION_DAY.
Если переданная дата следует после даты изобретения, нужно вывести надпись: "Пожалуйста, можете забрать ваш
карманный телепорт. Спасибо за ожидание!" — и вернуть true.
Если переданная дата предшествует дате изобретения, вывести: "Извините, телепорт еще не изобрели, приходите
через 10 лет." — и вернуть false.

В методе main в цикле вызови isTeleportInvented и передай currentDay в качестве параметра.
Если метод возвращает false, прибавь к currentDay 10 лет, иначе — выйди из цикла.

Требования:
•	Метод isTeleportInvented должен вывести соответствующую надпись и вернуть true, если переданная дата больше INVENTION_DAY.
•	Метод isTeleportInvented должен вывести соответствующую надпись и вернуть false, если переданная дата меньше INVENTION_DAY.
•	Каждый раз, когда isTeleportInvented возвращает false, нужно увеличивать currentDay на 10 лет.
•	Метод isTeleportInvented должен вызываться до тех пор, пока он не вернет true.
 */
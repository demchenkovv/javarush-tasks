package com.github.demchenkovv.javacore.level06.lecture03.task3;

import java.util.ArrayList;
import java.util.List;

/*
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {

        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));

        // Развернутое решение
//        SpecialThread specialThread1 = new SpecialThread();
//        SpecialThread specialThread2 = new SpecialThread();
//        SpecialThread specialThread3 = new SpecialThread();
//        SpecialThread specialThread4 = new SpecialThread();
//        SpecialThread specialThread5 = new SpecialThread();
//
//        list.add(new Thread(specialThread1));
//        list.add(new Thread(specialThread2));
//        list.add(new Thread(specialThread3));
//        list.add(new Thread(specialThread4));
//        list.add(new Thread(specialThread5));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}


/*
Список и нити
В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread, работающим
со своим объектом класса SpecialThread.


Requirements:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Класс SpecialThread изменять нельзя.
 */
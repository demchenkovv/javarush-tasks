package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo2;

/* Анонимные классы */
// Анонимные классы используются в месте их создания. Они не имеют имени.
// Являясь частным случаем локального класса, они преемствуют все ограничения локальных классов.
// Также могут обращаться к финальным локальным переменным внешнего класса и ко всем полям обрамляющего класса.
// Локальные переменные должны быть финальными для того, что бы пользователь класса был уверен в том, что пока
// он работает с данными, они не изменятся во внешнем коде, т.е. их состояние остаётся актуальным на всём
// протяжении жизни анонимного класса.
// После компиляции анонимный класс из примера выше выглядит как AnonymousClassDemo$1.class, но в программе мы
// не можем обратиться к нему по такому имени. ($1 имя лок. класса)

public class AnonymousClassDemo {
    static final int k = 0;

    public static void methodForDemoAnonClass() {
        new Thread(new Runnable() {
            int k = AnonymousClassDemo.k;

            public void run() {
                System.out.println("\nOuterClass#methodForDemoAnonClass(): start of the demonstration of the anonymous class");
                for (; ; ) {
                    k++;
                    if (k % 33 == 0) {
                        System.out.println(k);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

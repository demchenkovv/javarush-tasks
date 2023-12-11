package com.github.demchenkovv.multithreading.level07.lecture06.task2707;

/* 
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    /*
    TODO: Deadlock, определяем порядок захвата монитора
    Artem Murk:
    1) Создал 2 нити.
        Первая нить: синхронизирует по первому объекту, сплю (у меня 50 [200] мс),
                     синхронизирует по второму объекту.
        Вторая нить: вызывает проверяемый метод [someMethodWithSynchronizedBlocks]
    2) Запустил первую нить
    3) Засыпаю (на время < 50 [200] мс, у меня 10 [100] мс). Это необходимо для синхронизации
    по первому объекту, но не успело синхронизировать по второму объекту.
    4) Запускаю вторую нить.
    5) Засыпаю на определенное время. У меня 100 [300] мс - примерное время для отработки
    двух нитей.
    Итог: Если объекты синхронизируются по-разному то мы получим DeadLock. Если же все норм, то
    сначала отработает первая нить, а затем вторая, как и было описано в лекции. А потом проверкой
    состояния нити мы можем определить, true or false/
    */
    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (o2) {
                }
            }
        });

        Thread t2 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));

        t1.start();
        Thread.sleep(100);

        t2.start();
        Thread.sleep(300);

        return !t2.getState().equals(Thread.State.BLOCKED);
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}

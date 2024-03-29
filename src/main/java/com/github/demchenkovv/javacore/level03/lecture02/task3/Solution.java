package com.github.demchenkovv.javacore.level03.lecture02.task3;

/*
Пиво с колой не мешать
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        print(new Beer());
        print(new Cola());
    }

    private static void print(Drink drink) {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink {
        boolean isAlcoholic();
    }

    public static class Beer implements Drink {
        @Override
        public boolean isAlcoholic() {
            return true;
        }
    }

    public static class Cola implements Drink {
        @Override
        public boolean isAlcoholic() {
            return false;
        }
    }
}


/*
Пиво с колой не мешать
Реализуй интерфейс Drink в классах Beer и Cola.


Requirements:
1. Класс Beer должен реализовывать (implements) интерфейс Drink.
2. Класс Cola должен реализовывать (implements) интерфейс Drink.
3. В классе Beer должны быть реализованы все методы интерфейса Drink.
4. В классе Cola должны быть реализованы все методы интерфейса Drink.
 */
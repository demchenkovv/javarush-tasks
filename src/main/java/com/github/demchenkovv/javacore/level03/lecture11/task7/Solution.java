package com.github.demchenkovv.javacore.level03.lecture11.task7;

/*
Интерфейс Updatable в классе Screen
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen implements Updatable {

        @Override
        public void onSelect() {

        }

        @Override
        public void refresh() {

        }
    }
}


/*
Интерфейс Updatable в классе Screen
Реализуй интерфейс Updatable в классе Screen.


Requirements:
1. Интерфейс Updatable должен наследовать (extends) интерфейс Selectable.
2. Класс Screen должен реализовывать (implements) интерфейс Updatable.
3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
 */
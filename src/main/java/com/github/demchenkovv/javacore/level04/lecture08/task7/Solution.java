package com.github.demchenkovv.javacore.level04.lecture08.task7;

import java.util.ArrayList;
import java.util.List;

/*
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        apartments.forEach(Apartment::clean);
    }

    static interface Apartment {
        void clean();
    }

    static class OneRoomApt implements Apartment {
        public void clean() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        public void clean() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        public void clean() {
            System.out.println("3 rooms are cleaned");
        }
    }
}


/*
Клининговый центр
В этой задаче тебе нужно:
Реализовать метод cleanAllApartments().
Пройтись по списку объектов apartments:
для однокомнатных квартир (OneRoomApt) вызвать метод clean1Room();
для двухкомнатных квартир (TwoRoomApt) вызвать метод clean2Rooms();
для трехкомнатных квартир (ThreeRoomApt) вызвать метод clean3Rooms().
Использовать instanceof.

Requirements:
1. Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
2. В методе cleanAllApartments для всех однокомнатных аппартаментов (OneRoomApt), содержащихся в списке, необходимо вызвать метод clean1Room().
3. В методе cleanAllApartments для всех двухкомнатных аппартаментов (TwoRoomApt), содержащихся в списке, необходимо вызвать метод clean2Rooms().
4. В методе cleanAllApartments для всех трехкомнатных аппартаментов (ThreeRoomApt), содержащихся в списке, необходимо вызвать метод clean3Rooms().
5. Классы OneRoomApt, TwoRoomApt, ThreeRoomApt должны поддерживать (реализовывать) интерфейс Apartment.
 */
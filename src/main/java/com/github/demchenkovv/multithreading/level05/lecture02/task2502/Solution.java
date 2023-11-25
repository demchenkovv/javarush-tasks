package com.github.demchenkovv.multithreading.level05.lecture02.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            Set<Wheel> wheelSet = new HashSet<>(4);
            String[] wheelsArray = loadWheelNamesFromDB();
            if (wheelsArray.length != 4) {
                throw new IllegalArgumentException();
            }
            for (String s : wheelsArray) {
                wheelSet.add(Wheel.valueOf(s));
            }
            if (wheelSet.size() != 4) {
                throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>(wheelSet);
        }

        /** Предполагается, что это машина, у которой исключительно 4 колеса */
        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
//            return new String[]{};
//            return null;
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}

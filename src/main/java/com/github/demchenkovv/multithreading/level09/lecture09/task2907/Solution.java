package com.github.demchenkovv.multithreading.level09.lecture09.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    // Преобразовав double в String,
    public static BigDecimal getValue(double v1, double v2) {
        String val1 = String.valueOf(v1);
        String val2 = String.valueOf(v2);
        return new BigDecimal(val1).add(new BigDecimal(val2));

        /*
        Можно предположить, что запись new BigDecimal(0.1) в Java
        создает BigDecimal, который в точности равен 0.1 (немасштабированное
        значение 1 со шкалой 1),но на самом деле он равен:
        0.1000000000000000055511151231257827021181583404541015625

        Конструктор String, с другой стороны, совершенно предсказуем:
        запись new BigDecimal("0.1") создает BigDecimal, который в точности
        равен 0.1, как и следовало ожидать. Поэтому обычно рекомендуется
        использовать конструктор String.

        Раскомментируйте код ниже и убедитесь в этом сами:
         */

//        System.out.println("Real value v1 is : " + new BigDecimal(v1));
//        System.out.println("Real value v2 is : " + new BigDecimal(v2));
//        System.out.println("v1 + v2 = " + (new BigDecimal(v1).add(new BigDecimal(v2))));

    }
}

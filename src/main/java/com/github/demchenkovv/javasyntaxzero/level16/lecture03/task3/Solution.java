package com.github.demchenkovv.javasyntaxzero.level16.lecture03.task3;

import java.time.LocalDate;

/*
С годами моложе
*/

public class Solution {

    public static void main(String[] args) {
        LocalDate jubilee40Years = LocalDate.of(2010, 3, 13);

        LocalDate jubilee30Years = jubilee40Years.minusYears(10);

        System.out.println(Math.abs(jubilee30Years.getYear()));
    }
}

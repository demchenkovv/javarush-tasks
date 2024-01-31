package com.github.demchenkovv.collections.level04.lecture10.task3412;

/*
Добавление логирования в класс
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/*
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug(String.format("Solution constructor init: val1 = %d, val2 = %s, val3 = %tc.", value1, value2, value3));
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("calculateAndSetValue3() started.");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("value > Integer.MAX_VALUE; new value1 = " + value1);
        } else {
            value1 = (int) value;
            logger.debug("value < Integer.MAX_VALUE; new value1 = " + value1);
        }
    }

    public void printString() {
        logger.trace("printString() started.");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("printDateAsLong() started.");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("divide() with arguments " + number1 + ", " + number2 + " started.");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Solution#devide(): ", e);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("Solution#setValue1(): new value1 = " + this.value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("Solution#setValue2(): new value2 = " + this.value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("Solution#setValue3(): new value3 = " + this.value3);
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task34.task3412;

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
        logger.debug(this.value1 + "changed to ");
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace(this.getClass() + "called");
        logger.debug(value + "changed to value - 1");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            logger.debug(this.value1 + "changed to ");
            value1 = (int) (value / Integer.MAX_VALUE);
        } else {
            value1 = (int) value;
        }
    }

    public void printString() {
        if (value2 != null) {
            logger.trace(this.getClass() + "called");
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        if (value3 != null) {
            logger.trace(this.getClass() + "called");
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        try {
            logger.trace(this.getClass() + "called");
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error(e.getMessage());
        }
    }

    public void setValue1(int value1) {
        logger.debug(this.value1 + "changed to" + value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug(this.value2 + "changed to" + value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug(this.value3 + "changed to" + value3);
        this.value3 = value3;
    }
}

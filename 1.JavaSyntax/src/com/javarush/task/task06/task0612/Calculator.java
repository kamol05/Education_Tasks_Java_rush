package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return 0;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return 0;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return 0;
    }

    public static double percent(int a, int b) {
        double d = a;
        d /= 100;
        return b * d;
    }

    public static void main(String[] args) {
        System.out.println(percent(30,50));
    }
}
package com.javarush.task.task04.task0411;

/* 
Время года
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        if (month > 2 && month < 6)
            System.out.println("vesna");
        if (month > 6 && month < 9)
            System.out.println("leto");
        if (month > 8 && month < 11)
            System.out.println("osen");
        if (month >= 10 && month <= 13)
            System.out.println("zima");

    }
}
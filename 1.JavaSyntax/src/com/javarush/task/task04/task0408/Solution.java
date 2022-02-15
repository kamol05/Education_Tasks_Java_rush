package com.javarush.task.task04.task0408;

/* 
Хорошо или плохо?
*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int number) {
        //напишите тут ваш код
        if (number < 5)
            System.out.println("menshe");
        if (number == 5 )
            System.out.println("ravno");
        if (number > 5)
            System.out.println("bolshe");

    }
}
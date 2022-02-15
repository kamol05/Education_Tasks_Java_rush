package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String s = String.valueOf(number);
        int i = Integer.parseInt(s.substring(0,1));
        int i1 = Integer.parseInt(s.substring(1,2));
        int i2 = Integer.parseInt(s.substring(2));

        System.out.println(i + " " + i1 + " " + i2 );

        return i + i1 + i2 ;
    }
}
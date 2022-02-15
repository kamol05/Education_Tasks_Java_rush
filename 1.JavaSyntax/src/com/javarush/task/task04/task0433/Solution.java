package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 10,a = 10;
        while (i > 0){
            while (a > 0){
                System.out.print("S");
                a--;
            }
            System.out.println();
            a = 10;
            i--;
        }

    }
}

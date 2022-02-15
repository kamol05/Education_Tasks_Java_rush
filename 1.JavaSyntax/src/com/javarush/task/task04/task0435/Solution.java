package com.javarush.task.task04.task0435;

/* 
Четные числа
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++){
            int j = i % 2;
            if (j == 0){
                System.out.println(i);
            }
        }

    }
}

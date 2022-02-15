package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());

        if (i > 0 && i%2 == 0){
            System.out.println("polojitelnoe chetnoe");
        }else if (i > 0 && i%2 > 0){
            System.out.println(" pol ne chet");
        }else if (i == 0){
            System.out.println("nol");
        }


    }
}

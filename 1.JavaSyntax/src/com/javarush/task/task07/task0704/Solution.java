package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++)
        {
            String s = reader.readLine();
            num[i] = Integer.parseInt(s);
        }
        for (int i = 9; i > -1 ; i--)
        {
            System.out.println(num[i]);
        }
    }
}


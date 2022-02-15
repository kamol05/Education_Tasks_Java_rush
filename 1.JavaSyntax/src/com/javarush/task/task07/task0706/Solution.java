package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[15];
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < num.length; i++)
        {
            String s = reader.readLine();
            num[i] = Integer.parseInt(s);
            if (0 == i % 2)
            {
                num1 += num[i];
            }
            else {
                num2 += num[i];
            }
        }
        if (num1 > num2)
            System.out.println("В домах с четными номерами проживает больше жителей.");
            else
                System.out.println("В домах с нечетными номерами проживает больше жителей.");


    }
}

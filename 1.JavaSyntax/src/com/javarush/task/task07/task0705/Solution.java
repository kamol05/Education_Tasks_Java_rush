package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbig = new int[20];
        for (int i = 0; i < numbig.length; i++)
        {
            String s = reader.readLine();
            numbig[i] = Integer.parseInt(s);
        }
        int[] num1 = new int[10];
        num1 = Arrays.copyOfRange(numbig,0,10);
        int[] num2 = new int[10];
        num2 = Arrays.copyOfRange(numbig,10,20);

        for (int i = 0; i < num2.length; i++)
        {
            System.out.println(num2[i]);
        }
    }
}

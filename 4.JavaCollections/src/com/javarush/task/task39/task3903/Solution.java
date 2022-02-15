package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        String s = String.format("%64s", Long.toBinaryString(number)).replace(' ', '0');
        char[] chars = s.toCharArray();
        for(int t = 0; t < chars.length / 2; t++)
        {
            char temp = chars[t];
            chars[t] = chars[chars.length - t - 1];
            chars[chars.length - t - 1] = temp;
        }
        char temp1 =  chars[i];
        chars[i] = chars[j];
        chars[j] = temp1;
        for(int t = 0; t < chars.length / 2; t++)
        {
            char temp = chars[t];
            chars[t] = chars[chars.length - t - 1];
            chars[chars.length - t - 1] = temp;
        }
        Long l = Long.parseLong(new String(chars),2);
        return l;
    }
}

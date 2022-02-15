package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];

        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                if (a[i] < a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;

                }
            }
        }

        System.out.println(a[0]);
    }
}

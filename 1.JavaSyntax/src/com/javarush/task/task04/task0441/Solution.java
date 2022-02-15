package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Scanner;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] ar = new int[3];
        Scanner s = new Scanner(System.in);
        ar[0] = s.nextInt();
        ar[1] = s.nextInt();
        ar[2] = s.nextInt();
        for (int i = 0; i < ar.length ; i++){
            for (int j = 0; j < ar.length ; j++){
                if (ar[i] < ar[j]){
                    int temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
            }
        }
        System.out.println(ar[1]);

    }
}

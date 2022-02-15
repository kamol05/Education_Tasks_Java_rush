package com.javarush.task.task04.task0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] ar = new int[3];
        ar[0] = sc.nextInt();
        ar[1] = sc.nextInt();
        ar[2] = sc.nextInt();

        for (int i = 0; i < ar.length -1; i++){
            for (int j = 0; j < ar.length -1; j++){
                if (ar[j] < ar[j +1]){
                    System.out.println(j);
                    int temp = ar[j];
                    ar[j] = ar[j +1];
                    ar[j +1] = temp;
                }
            }
        }

        for (Integer i : ar){
            System.out.println(i);
        }
    }
}

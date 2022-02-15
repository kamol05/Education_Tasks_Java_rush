package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    static int pcount = 0;
    static int ocount = 0;
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int i1 = s.nextInt();
        int i2 = s.nextInt();
        for (int j = 0; j < 3; j++){
        if (i > 0){
            pcount++;
        }else if (i < 0){
            ocount++;
        }else if (i1 > 0){
            pcount++;
        }else if (i1 < 0){
            ocount++;
        }else if (i2 > 0){
            pcount++;
        }else if (i2 < 0){
            ocount++;
        }}
        System.out.println(ocount);
        System.out.println(pcount);

    }
}

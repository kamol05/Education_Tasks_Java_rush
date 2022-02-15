package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        double k = 0;
        int count = 0;
        while (true){
            double i = s.nextInt();
            if (i == -1){
                break;
            }
            k += i;
            count++;
        }
        System.out.println(k / count);
    }
}


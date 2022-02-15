package com.javarush.task.task04.task0436;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Рисуем прямоугольник
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();

        for (int i = m; i > 0; i--){
            for (int j = n; j > 0; j--){
            System.out.print("8");}
            System.out.println();
        }
    }
}

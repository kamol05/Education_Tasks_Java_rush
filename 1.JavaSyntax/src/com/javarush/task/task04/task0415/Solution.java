package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        String result = "";

        if (a < b+c) result = "y";
        if (b < a+c) result = "y";
        if (c < a+b) result = "y";
        else result = "no";

        System.out.println(result);

    }
}
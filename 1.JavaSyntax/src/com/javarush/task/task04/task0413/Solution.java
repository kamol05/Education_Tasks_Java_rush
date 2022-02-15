package com.javarush.task.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = "";
        if (i > 0 && 8 > i){
            if (i == 1) s = "1";
            if (i == 2) s = "2";
            if (i == 3) s = "3";
            if (i == 4) s = "4";
            if (i == 5) s = "5";
            if (i == 6) s = "6";
            if (i == 7) s = "7";

        }
        else s = "no number";

        System.out.println(s);

    }
}
package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String s[] = new String[10];
        int i[] = new int[10];
        Scanner c = new Scanner(System.in);
        for (int j = 0; j <s.length ; j++) {
            s[j] = c.nextLine();
        }
        for (int j = 0; j < i.length; j++) {
            i[j] = s[j].length();
        }

        for (int j = 0; j < i.length ; j++) {
            System.out.println(i[j]);

        }

    }
}

package com.javarush.task.task04.task0424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int[] a = new int[3];
        a[0] = s.nextInt();
        a[1] = s.nextInt();
        a[2] = s.nextInt();

        if (a[0] == a[1] && a[1] != a[2]){
            System.out.println(a[2]);
        }else if (a[0] == a[2] && a[2] != a[1]){
            System.out.println(a[1]);
        }else if (a[1] == a[2] && a[2] != a[0]){
            System.out.println(a[0]);
        }


    }
}

package com.javarush.task.task04.task0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимум четырех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int i3 = sc.nextInt();
        int i4 = sc.nextInt();
        int i5 = i1 > i2 ? i1 : i2;
        int i6 = i3 > i4 ? i3 : i4;

        System.out.println(i5 > i6 ? i5 :i6);

    }
}

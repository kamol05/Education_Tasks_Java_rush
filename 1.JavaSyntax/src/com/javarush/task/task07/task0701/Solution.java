package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int arr[] = new int[20];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static int max(int[] array) {

        return Arrays.stream(array).max().getAsInt();
    }
}

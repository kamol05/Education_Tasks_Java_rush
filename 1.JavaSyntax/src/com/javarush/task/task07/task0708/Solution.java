package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; strings.size() < 5 ; i++) {
            strings.add(sc.nextLine());
        }
        String max = strings.get(0);
        for (int i = 0; i < strings.size() -1 ; i++) {
            if (strings.get(i).length() < strings.get(i+1).length())
            {
                max = strings.get(i + 1);
            }
        }
        System.out.println(max);
    }
}

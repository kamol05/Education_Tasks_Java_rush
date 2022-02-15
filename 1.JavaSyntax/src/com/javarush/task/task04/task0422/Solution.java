package com.javarush.task.task04.task0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String name  = reader.next();
        int age = reader.nextInt();

        if (age < 18)
            System.out.println("Подрасти еще");
    }
}

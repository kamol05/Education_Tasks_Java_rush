package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        if (i > 0)
        { i *= 2; }
        else if (i < 0 ){
            i += 1;}

        System.out.println(i);

    }

}
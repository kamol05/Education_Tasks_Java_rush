package com.javarush.task.task04.task0421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Настя или Настя?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner c = new Scanner(System.in);
        String s = c.nextLine();
        String s1 = c.nextLine();

        if (s.equals(s1)){
            System.out.println("imena odinakovi");
        }else if (s.length() == s1.length()){
            System.out.println("dlina imen odinakovi");
        }

    }
}

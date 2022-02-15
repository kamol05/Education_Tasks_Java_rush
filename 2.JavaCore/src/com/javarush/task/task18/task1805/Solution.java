package com.javarush.task.task18.task1805;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static byte buffer[] = new byte[0];
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new Scanner(System.in).nextLine());

        int[] dlecount = new int[250];
        while (inputStream.available() > 0){
            dlecount[inputStream.read()] +=1;
        }

        for (int i = 0; i < dlecount.length ; i++) {
            if (dlecount[i] > 0 && dlecount[i] != 0){
                System.out.print(i + " ");
            }
        }
        inputStream.close();

    }
}

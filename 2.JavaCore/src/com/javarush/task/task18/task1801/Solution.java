package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream f = new FileInputStream(new Scanner(System.in).nextLine());
        int result = 0;
        while (f.available() > 0){
            int temp = f.read();
            if (result < temp){
                result = temp;
            }
        }
        f.close();
        System.out.println(result);
    }
}

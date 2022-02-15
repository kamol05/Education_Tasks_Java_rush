package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int maxByte = 0;
        do {
            maxByte = fileInputStream.available() > 0 ? fileInputStream.read() : 0;
            int currentByte = fileInputStream.read();
            if (currentByte < maxByte){
                maxByte = currentByte;
            }
        }
        while (fileInputStream.available() > 0);

        fileInputStream.close();
        System.out.println(maxByte);
    }
}

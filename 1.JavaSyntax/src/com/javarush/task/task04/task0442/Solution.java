package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;

/*
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int b = 0;
        for (int i = 0; i != -1; b += i)
            i = Integer.parseInt(reader.readLine());
            System.out.println(b);




        /*int b = 0;
        while (true) {
            int a = Integer.parseInt(reader.readLine());
            if (a == -1){
                b--;
                System.out.println(b);
                break;
            }
            else b += a;
        }*/

    }
}

package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());

        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;

        while (fileInputStream.available() > 0){
            if (fileInputStream.read() == 44){
                counter++;
            }
        }
        fileInputStream.close();
        System.out.println(counter);
    }
}

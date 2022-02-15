package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (
//            FileOutputStream fo = new FileOutputStream("d:/1.txt");
//            FileInputStream fs1 = new FileInputStream("d:/2.txt");
//            FileInputStream fs2 = new FileInputStream("d:/3.txt");


                FileOutputStream fo = new FileOutputStream(String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine()));
                FileInputStream fs1 = new FileInputStream(String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine()));
                FileInputStream fs2 = new FileInputStream(String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        ){
            ArrayList<Integer> bytes = new ArrayList<>();
            while (fs1.available() > 0){
                bytes.add(fs1.read());
            }
            while (fs2.available() > 0){
                bytes.add(fs2.read());
            }
            for (int i = 0; i <bytes.size() ; i++) {
                fo.write(bytes.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

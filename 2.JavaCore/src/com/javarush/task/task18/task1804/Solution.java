package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int [] array = new int[256];
        while (stream.available() > 0){
            array[stream.read()] +=1;
        }
        int mincount = 256;
        for (int i : array){
            if (i > 0 && i < mincount) mincount = i;
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i <array.length ; i++) {
            if (array[i] == mincount){ list.add(i);}
        }

        for (int i : list){
            System.out.print(i + " ");
        }
        stream.close();
    }
}

package com.javarush.task.task19.task1906;

import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr = new FileReader(reader.readLine());
            FileWriter fw = new FileWriter(reader.readLine());
            int it = 0;
            while (fr.ready()) {
                int i = fr.read();
                if (it % 2 != 0) {
//                    System.out.println((char) i);
                    fw.write((char)i);
                }
                it++;
            }
            reader.close();
            fr.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

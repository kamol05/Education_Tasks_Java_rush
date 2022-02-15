package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = "d:/1.txt";
//        String file2 = "d:/2.txt";
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        try(
                FileInputStream fi = new FileInputStream(file1);
                FileOutputStream fo = new FileOutputStream(file2);
                Scanner sc = new Scanner(fi);
                FileWriter fw = new FileWriter(file2)
                )
        {
            ArrayList<Double> doubles = new ArrayList<>();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String [] splittedLine = line.split(" ");
                for (String each : splittedLine){
                    if (!each.isEmpty()){
                    doubles.add(Double.parseDouble(each));}
                }
            }

            for (Double d : doubles){
                int r = (int) Math.round(d);
                fw.write(r + " ");
            }
        }

    }
}

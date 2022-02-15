package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double read = Double.parseDouble(reader.readLine());
        double rec = read % 5;
        if (rec < 3.0)
            System.out.println("зелёный");
        else if(rec < 4.0){
             System.out.println("жёлтый"); }
        else System.out.println("красный");
    }
}

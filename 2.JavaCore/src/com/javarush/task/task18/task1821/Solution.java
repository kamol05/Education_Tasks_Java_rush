package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] aSCII = new int[128];

        try (FileReader reader = new FileReader("d:/1.txt")) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        int max = 0;
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
            if (max < aSCII[i]){
                max = i;
            }
        }
        System.out.println((char) max);
    }
}

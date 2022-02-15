package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    /*    args[0] = "-e"; //or -d
        args[1] = "d:/1.txt";
        args[2] = "d:/2.txt";*/

        FileInputStream f = new FileInputStream(args[1]);
        FileOutputStream fo = new FileOutputStream(args[2]);

        while (f.available() > 0){
            int bit = f.read();

            if (args[0].equals("-e")){
                fo.write(bit +1);
            }
            if (args[0].equals("-d")){
                fo.write(bit -1);
            }

        }
        f.close();
        fo.close();


    }

}

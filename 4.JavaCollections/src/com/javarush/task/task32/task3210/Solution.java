package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length == 0){
            args = new String[3];
            args[0] = "C:\\design\\allFilesContent.txt";
            args[1] = "0";
            args[2] = "farruh";
        }
        String result = null;
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        raf.seek(Long.parseLong(args[1]));

        byte[] b = new byte[args[2].length()];
        raf.read(b,0,args[2].length());

        String word = new String(b);

        if (word.equals(args[2])){
            result = "true";
        } else result = "false";

        raf.seek(raf.length());
        raf.write(result.getBytes());
    }
}

package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length == 0){
            args = new String[3];
            args[0] = "C:\\design\\allFilesContent.txt";
            args[1] = "70";
            args[2] = "shuni qoy";
        }

        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");

        if (raf.length() > Integer.parseInt(args[1])){
            raf.seek(Long.parseLong(args[1])); }
        else {
            raf.seek(raf.length()); }

        raf.write(args[2].getBytes());

    }
}

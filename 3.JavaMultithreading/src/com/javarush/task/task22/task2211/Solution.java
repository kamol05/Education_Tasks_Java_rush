package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = "1.txt";
        String fileName2 = "2.txt";
        if (args.length != 0)
        {
            fileName1 = args[0];
            fileName2 = args[1];
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileInputStream fi = new FileInputStream(fileName1);
        while (fi.available() > 0)
        {
            bos.write(fi.read());
        }
        byte[] buffer = bos.toByteArray();
        String s = new String(buffer, "Windows-1251");
//        System.out.println(s);
        buffer = s.getBytes(StandardCharsets.UTF_8);
        bos.close();
        fi.close();
        try(FileOutputStream fos = new FileOutputStream(fileName2))
        {
            fos.write(buffer);
        }
        catch (Exception e){}

    }
}

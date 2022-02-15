package com.javarush.task.task31.task3106;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        if (args.length == 0) {
            args = new String[5];
            args[0] = "C:\\Intel\\result.mp3";
            args[1] = "C:\\Intel\\abc.zip.003";
            args[2] = "C:\\Intel\\abc.zip.001";
            args[3] = "C:\\Intel\\abc.zip.004";
            args[4] = "C:\\Intel\\abc.zip.002";
        }

        for (int i = 1; i < args.length; i++) {
            set.add(args[i]);
        }

        try{
//            File dir = new File("D:/arc");
            FileOutputStream fos = new FileOutputStream(new File(args[0]));
            FileInputStream fis = null;


            for (String fname : set) {
                try {
                    fis = new FileInputStream(fname);
                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    fos.write(b);
                } finally {
                    if (fis != null) {
                        fis.close();
                    }
                    fos.flush();
                }
            }
            fos.close();
            ZipFile zipFile = new ZipFile(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

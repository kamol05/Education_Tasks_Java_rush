package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> filenames = new ArrayList<>();

        File files = new File(root);
        for (File file : files.listFiles())
        {
            if (file.isDirectory()){
                filenames.addAll(findFiles(file));
            }
            if (file.isFile()){
                filenames.add(file.getAbsolutePath());
            }
        }
        return filenames;

    }

    private static Collection<? extends String> findFiles(File root) throws IOException {
        List<String> filenames = new ArrayList<>();

        for (File file : root.listFiles())
        {
            if (file.isDirectory()){
                filenames.addAll(findFiles(file));
            }
            if (file.isFile()){
                filenames.add(file.getAbsolutePath());
            }
        }
        return filenames;
    }


    public static void main(String[] args) throws IOException {

        for (String s : getFileTree("D:\\DATA")){
            System.out.println(s);
        }
    }
}

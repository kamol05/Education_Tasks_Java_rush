package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        try(
                FileInputStream fs2 = new FileInputStream(file2);
                FileInputStream fs = new FileInputStream(file1);
                )
        {
            ArrayList<Integer> list = new ArrayList<>();
            while (fs2.available() > 0){
                list.add(fs2.read());
            }
            while (fs.available() > 0){
                list.add(fs.read());
            }
            FileOutputStream fo = new FileOutputStream(file1);
            for (Integer integer : list) {
                fo.write(integer);
            }
            fs2.close();
            fs.close();
            fo.close();
        }


    }
}

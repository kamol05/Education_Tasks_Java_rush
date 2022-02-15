package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
//        String filename = "c:/1.txt";
        FileReader fw = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fw);
        TreeMap<String,Double> treeMap = new TreeMap<>();

        while (reader.ready())
        {
            String [] s = reader.readLine().split(" ");
            if (treeMap.containsKey(s[0]))
            {
                double d = treeMap.get(s[0]);
                treeMap.put(s[0],d + Double.parseDouble(s[1]));
            }
            else
            treeMap.put(s[0],Double.parseDouble(s[1]));

        }

        for (Map.Entry<String,Double> m : treeMap.entrySet())
        {

            System.out.println(m.getKey() +" "+ m.getValue());
        }
        fw.close();
        reader.close();



    }
}

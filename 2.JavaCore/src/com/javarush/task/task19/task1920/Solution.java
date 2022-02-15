package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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
        TreeSet<String> treeSet = new TreeSet<>();

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
        double max = Collections.max(treeMap.values());

        for (Map.Entry<String,Double> m : treeMap.entrySet())
        {
            if (m.getValue() == max)
            {
                treeSet.add(m.getKey());
            }
        }
        for (String s : treeSet)
        {
            System.out.println(s);
        }
        fw.close();
        reader.close();



    }
}

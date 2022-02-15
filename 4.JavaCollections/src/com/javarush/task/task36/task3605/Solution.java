package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0 ){
            args = new String[1];
            args[0] = "1.txt";
        }
        TreeSet<String> set = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>();
        try( BufferedReader reader = new BufferedReader(new FileReader(args[0])) )
        {
            String line = null;
            while ( ( line = reader.readLine()) != null){
                char[] kars = line.toCharArray();
                for (char each : kars){
                    list.add(String.valueOf(each).toLowerCase());
                }
            }
            for (String s : list){
                if (!s.matches("[^a-z]")){
                    set.add(s);
                }
            }
        }
        int i = 0;
        for (String ss : set){
            System.out.print(ss);
            i++;
            if (i == 5) break;
        }

    }
}

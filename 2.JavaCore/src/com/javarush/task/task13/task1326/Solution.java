package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filepath = reader.readLine();
        FileInputStream str = new FileInputStream(filepath);
        
        Scanner sc = new Scanner(str);
        ArrayList<Integer> list = new ArrayList<>();

        while ( sc.hasNext())
        {
            int u = Integer.parseInt(sc.next());

            if ( (u % 2) == 0 )
            {
                list.add(u);
            }
        }

        Collections.sort(list);

        for(Integer i : list)
        {
            System.out.println(i);
        }

        str.close();
    }
}

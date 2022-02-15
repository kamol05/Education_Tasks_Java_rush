package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream1 = new FileInputStream(reader.readLine());
        FileOutputStream stream2 = new FileOutputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (stream1.available() > 0){
            list.add(stream1.read());
        }
        for (int i = list.size() -1; i > -1; i-- ) {
            stream2.write(list.get(i));
        }
        reader.close();
        stream1.close();
        stream2.close();


    }
}

package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String inFile = null;
        String outFile = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        ) 
        {
            inFile = reader.readLine();
            outFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader readerin = new BufferedReader(new FileReader(inFile));
             BufferedWriter writerout = new BufferedWriter(new FileWriter(outFile));
//                FileWriter fw = new FileWriter(outFile);
                )
        {
            StringBuilder sb= new StringBuilder();
            while (readerin.ready())
            {
                sb.append((char)readerin.read());
            }
            String[] array = sb.toString().split(" ");

            for (int i = 0; i <array.length ; i++) {
                String s = array[i];
                if (s.matches("\\d+")){
                    writerout.write(s + " ");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

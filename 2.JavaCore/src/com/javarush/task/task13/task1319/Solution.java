package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader filepath = new BufferedReader(new InputStreamReader(System.in));
        String outputFileName = filepath.readLine();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
            BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName));
                String line;
                while (!(line = reader.readLine()).equals("exit"))
                {
                    writter.write(line);
                    writter.newLine();
                }
                writter.write(line);

                reader.close();
                writter.close();
            }
        }

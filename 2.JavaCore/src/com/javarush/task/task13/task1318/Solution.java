package com.javarush.task.task13.task1318;
import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        InputStream input = null;
        int i;
        String ws = "";
        
        try {
            s = reader.readLine();
            input = new FileInputStream(s);

            while (input.available() > 0)
            {

                i = input.read();
                ws += ((char)i);
            }
            System.out.println(ws);

            reader.close();
            input.close();

        } catch (IOException e){
            System.out.println("try again");

        }finally {
            input.close();
        }

    }
}
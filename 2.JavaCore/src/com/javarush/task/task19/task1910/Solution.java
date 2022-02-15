package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        String inputFile = null;
        String outptFile = null;
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        )
        {
            inputFile = reader.readLine();
            outptFile = reader.readLine();
        }
        catch (Exception ignored){ignored.printStackTrace();}

        ArrayList<String> list = new ArrayList<>();

        try (
                BufferedReader fReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter fWrtier = new BufferedWriter(new FileWriter(outptFile));
        )
        {

            while (fReader.ready())
            {
                list.add(fReader.readLine());
            }
            for (String s : list) {
                String p = s.replaceAll("\\p{P}", "");
//                System.out.println(p);
                fWrtier.write(p);
            }
        }catch (Exception ignored){ ignored.printStackTrace();}
    }
}


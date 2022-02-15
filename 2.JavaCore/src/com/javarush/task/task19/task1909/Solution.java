package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
                char[] hh = s.toCharArray();
                for (int i = 0; i <hh.length ; i++) {
                    if (hh[i] == '.')
                    {
                        hh[i] = '!';
                    }
                }
//                System.out.println(hh);
                fWrtier.write(hh);
            }
        }catch (Exception ignored){ ignored.printStackTrace();}
    }
}

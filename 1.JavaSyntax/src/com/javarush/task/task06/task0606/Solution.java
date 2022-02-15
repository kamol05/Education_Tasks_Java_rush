package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        String c = String.valueOf(num);
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < c.length() ; i++){
            array.add(Integer.parseInt(String.valueOf(c.charAt(i))));
        }
        for (Integer i : array){
            if (0 == i % 2){
                even++;
            }else odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);

    }
}

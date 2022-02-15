package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(result.toString());

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("helicopter")){
            result = new Helicopter();
        }else if (s.equals("plane")){
            Scanner scanner1 = new Scanner(System.in);
            int getCountOfPassengers = scanner1.nextInt();
            result = new Plane(getCountOfPassengers);
            scanner1.close();
        }
        scanner.close();
        //add your code here - добавьте код тут
    }


}

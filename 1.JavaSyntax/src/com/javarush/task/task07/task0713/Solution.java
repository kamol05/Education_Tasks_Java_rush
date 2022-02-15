package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> array3 = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add(sc.nextInt());
        }
        for (int ae : array) {
            if ( ae % 3 == 0){
                array1.add(ae);
                if ( ae % 2 == 0){
                    array2.add(ae);
                }
            }else if (ae % 2 == 0){
                array2.add(ae);
            }else array3.add(ae);
        }
        printList(array1);
        printList(array2);
        printList(array3);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i : list
             ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

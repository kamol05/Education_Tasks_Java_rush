package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

//    public static String getAllNumbersBetween1(int a, int b) {
//        if (a > b) {
//            return a + recursion1(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + recursion1(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
//        System.out.println(a);
//        System.out.println(b);
        if (a == b){sb.append(a);}
        if (a < b){
            for (int i = a; i <= b; i++) {
                sb.append(i).append(" ");
            }
            return sb.toString().trim();
        }else if (b < a){
            for (int i = a; i >= b; i--) {
                sb.append(i).append(" ");
            }
            return sb.toString().trim();
        } return sb.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}
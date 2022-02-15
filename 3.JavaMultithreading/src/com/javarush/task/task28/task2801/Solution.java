package com.javarush.task.task28.task2801;

/* 
Осваиваем switch
*/

public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        switch ( obj.getClass().getSimpleName() ){
            case "E1": String Eclass = obj.getClass().getSimpleName();
                System.out.println("it's " + Eclass + "." + obj.toString());
                break;
            case "E2" : String Eclass1 = obj.getClass().getSimpleName();
                System.out.println("it's " + Eclass1 + "." + obj.toString());
                break;
            default:
                System.out.println("undefined");

        }
        //add your code here
    }
}

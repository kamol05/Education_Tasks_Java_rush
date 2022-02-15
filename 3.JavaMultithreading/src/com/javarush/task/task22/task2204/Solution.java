package com.javarush.task.task22.task2204;

/* 
Форматирование строки
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), 20.0 / 7.0, 10.0 / 3.0));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = %.2f%nExp = %.2e";
//                " %Exp = %s";
//  "%1$09.2f"
//   3.1415926535897
//   03,14159
//        %[аргумент_индекс][флаги][ширина][.точность]спецификатор типа

    }
}

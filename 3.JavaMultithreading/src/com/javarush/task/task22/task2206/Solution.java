package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/

public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tH:%tM:%tS";
//        05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)
//                               %td:%tm:%ty
//        "%td %tB %tY года %tH:%tM:%tS"
//        11 октября 2020 года
//         13:43:22
    }
}

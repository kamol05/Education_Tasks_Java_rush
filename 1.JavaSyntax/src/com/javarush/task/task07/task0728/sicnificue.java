package com.javarush.task.task07.task0728;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sicnificue {
    public static void main(String[] args) {
        int [] array = {6,5,4,3,2,1,};
        for (int barrier = 0; barrier < array.length; barrier++){
            for (int index = array.length -1; index > barrier; index--){
                if (array[index -1] > array[index]){
                    int tmp = array[index];
                    array[index] = array[index -1];
                    array[index -1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

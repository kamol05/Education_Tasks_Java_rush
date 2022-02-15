package com.javarush.task.task30.task3013;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] data = {1,2,3};
        Permutator.permute(data,data.length);
    }

    private static class Permutator {
        
        public static void permute(int[] arr, int size) {
            if (size < 2){
                System.out.println(Arrays.toString(arr));
            }else {
                for (int k = 0; k < size; k++) {
                    permute(arr,size -1);
                    swap(arr,k,size -1);
                }
            }
        }
        private static void swap(int[] arr, int index0, int index1) {
            int tmp = arr[index0];
            arr[index0] = arr[index1];
            arr[index1] = tmp;
        }
    }
}

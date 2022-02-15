package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int[] maths = new int[3];
        for (int i = 0; i < 8; i++){
            maths[0] = (int) (Math.random() * (122 - 97)) + 97;
            maths[1] = (int) (Math.random() * (90 - 65)) + 65;
            maths[2] = (int) (Math.random() * (8)) + 1;
            int chooseBetween = (int) (Math.random() * (3 - 0)) + 0;
            if (chooseBetween == 2){
                String s = String.valueOf(maths[2]);
                try {
                    bos.write(s.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
            bos.write(maths[chooseBetween]);
        }
        if (bos.toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")) {
            return bos;
        } else bos = getPassword();
        return bos;
    }
}
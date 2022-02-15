package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {

    public static Class getFactoryClass() {
        return fabric.class;
    }

    public static void main(String[] args) {
        System.out.println(fabric.getEnum(ApplicationExceptionMessage.SOCKET_IS_CLOSED));
        System.out.println(fabric.getEnum(UserExceptionMessage.USER_DOES_NOT_EXIST));
    }
}
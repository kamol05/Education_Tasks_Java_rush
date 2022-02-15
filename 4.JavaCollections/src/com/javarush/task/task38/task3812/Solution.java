package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/
import java.lang.reflect.Field;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest p = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String s : p.fullyQualifiedNames()){
                System.out.println(s);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest p = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class s : p.value()){
                System.out.println(s);
            }
            return true;
        }
        return false;
    }
}

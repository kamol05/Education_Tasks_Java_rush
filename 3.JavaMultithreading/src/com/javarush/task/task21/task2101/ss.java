package com.javarush.task.task21.task2101;

public class ss {
    public static void main(String[] args) {

        try(
                AA a = new AA();
                )
        {
        }

    }


public static class AA implements AutoCloseable{

    @Override
    public void close() {

    }
}
}

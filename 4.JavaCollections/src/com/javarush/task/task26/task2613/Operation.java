package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static com.javarush.task.task26.task2613.Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == LOGIN.ordinal()) {
            throw new IllegalArgumentException();
        }
        for (com.javarush.task.task26.task2613.Operation o : values()) {
            if (o.ordinal() == i) {
                return o;
            }
        }
        throw new IllegalArgumentException();
    }
}

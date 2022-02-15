package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> t;

    public Generator(Class<T> eventClass) {
        t = eventClass;
    }

    T newInstance() {
        T j = null;
        try {
           j = t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } return j;
    }
}

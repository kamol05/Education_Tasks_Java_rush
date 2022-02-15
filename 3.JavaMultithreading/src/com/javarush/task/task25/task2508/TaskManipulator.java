package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        while (true){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            break;
        }}
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(new TaskManipulator(),threadName);
        thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();

    }
}

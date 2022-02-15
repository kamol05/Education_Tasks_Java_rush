package com.javarush.task.task28.task2805;

public class MyThread extends Thread{
    private static int priority;

    private void po(){
        if  (getThreadGroup() != null ) {
            int gg = getThreadGroup().getMaxPriority();
            if ( priority == 10  ) { priority = 1; }
            else if ( priority >= gg ) { setPriority(gg); priority++; }
            else { priority++; }
        }
        setPriority(priority);
    }

    public MyThread() {
        po();
    }

    public MyThread(Runnable target) {
        super(target);
        po();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        po();
    }

    public MyThread(String name) {
        super(name);
        po();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        po();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        po();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        po();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        po();
    }



}

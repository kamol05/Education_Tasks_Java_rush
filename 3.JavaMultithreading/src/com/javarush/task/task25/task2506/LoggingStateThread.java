package com.javarush.task.task25.task2506;
public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread target) {
        thread = target;
        thread.setDaemon(true);
//        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);
        while (true) {

            if (thread.getState() != currentState) {
                currentState = thread.getState();
                System.out.println(currentState);
            }
            if (currentState == State.TERMINATED) {
                break;
            }
        }
        interrupt();
    }

}

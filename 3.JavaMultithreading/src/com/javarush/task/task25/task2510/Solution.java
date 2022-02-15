package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Vb());
    }

    class Vb implements UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            if (e instanceof Error){System.out.println("Нельзя дальше работать"); return;}
            if (e instanceof Exception){System.out.println("Надо обработать"); return;}
            if (e instanceof Throwable){System.out.println("Поживем - увидим"); return;}

//            try {
//                e.initCause(e)
//            }catch (Error er){
//                System.out.println("Нельзя дальше работать");
//            }catch (Exception ex){
//                System.out.println("Надо обработать");
//            } catch (Throwable th){
//                System.out.println("Поживем - увидим");
//            }
        }
    }

    @Override
    public void run() {
//        throw new Error("ku");
        throw new RuntimeException("hh");
    }

    public static void main(String[] args) {
        Thread t = new Solution();
        t.start();
    }
}

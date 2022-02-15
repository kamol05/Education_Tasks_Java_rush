package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            ShareItem item  = null;
            try {
                item = queue.take();
            } catch (InterruptedException e) {

            }
            if (item == null){
            break; }
            System.out.format("Processing ShareItem{description='"+ item.getDescription() + "', itemId=" +item.getItemId()+"}\n");
        }

    }
}

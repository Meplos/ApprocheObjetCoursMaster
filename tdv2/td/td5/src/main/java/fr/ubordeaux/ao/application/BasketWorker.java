package fr.ubordeaux.ao.application;

import java.util.concurrent.Semaphore;

public class BasketWorker extends Thread {

    BasketCommandQueue queue = BasketCommandQueue.getInstance();
    
    public BasketWorker(){
        super();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                queue.available.acquire();
                if (queue.getSize() <= 0) {
                    queue.available.release();
                    continue;
                }
                queue.getLast().exec();
                queue.available.release();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
            

        }
    }

}
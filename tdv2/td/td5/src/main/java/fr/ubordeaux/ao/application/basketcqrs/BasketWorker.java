package fr.ubordeaux.ao.application.basketcqrs;

public class BasketWorker implements Runnable {

    private BasketCommandQueue queue = BasketCommandQueue.getInstance();
    private int id;
    public BasketWorker(int num){
        super();
        id = num;

    }

    
    @Override
    public void run() {
        while (true) {
            System.out.println("["+id+"]");
            try {
                queue.available.acquire();
                if (queue.getSize() <= 0) {
                    queue.available.release();
                    return;
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
package fr.ubordeaux.ao.application.cqrs;

public class Worker implements Runnable {

    private CommandQueue queue = CommandQueue.getInstance();
    private int id;
    public Worker(int num){
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
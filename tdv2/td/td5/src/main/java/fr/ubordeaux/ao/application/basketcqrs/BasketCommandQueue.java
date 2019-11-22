package fr.ubordeaux.ao.application.basketcqrs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BasketCommandQueue {
    private List<BasketCommand> basketQueue = new ArrayList<>();
    public Semaphore available = new Semaphore(1);

    private static BasketCommandQueue INSTANCE = null;

    public static BasketCommandQueue getInstance(){
        if(INSTANCE == null)
            INSTANCE = new BasketCommandQueue();
        return INSTANCE;
    }

    public void add(BasketCommand cmd){
        basketQueue.add(cmd);
    }

    public BasketCommand getLast(){
        BasketCommand last = basketQueue.get(0);
        basketQueue.remove(0);
        return last;
    }

    public int getSize(){
        return basketQueue.size();
    }
}
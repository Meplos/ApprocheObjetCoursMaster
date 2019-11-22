package fr.ubordeaux.ao.application.cqrs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool{
    
    public final int NWORKER = 2;
    
    private static ThreadPool INSTANCE = null;
    private ExecutorService executor;


    public ThreadPool(){
        executor = Executors.newFixedThreadPool(NWORKER);
        for (int i = 0; i < 2; i++) {
            Runnable worker = new Worker(i);
            executor.execute(worker);

        }
    }

    public void stop(){
        System.out.println("All thread shutdown.."); // Wait executor finnished
        executor.shutdown();
        while (!executor.isTerminated());
    }

    public static ThreadPool getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ThreadPool();
        return INSTANCE; 
    }

}
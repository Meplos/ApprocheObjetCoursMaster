package fr.ubordeaux.ao.application.cqrs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class CommandQueue {
    private List<Command> queue = new ArrayList<>();
    public Semaphore available = new Semaphore(1);

    private static CommandQueue INSTANCE = null;

    public static CommandQueue getInstance(){
        if(INSTANCE == null)
            INSTANCE = new CommandQueue();
        return INSTANCE;
    }

    public void add(Command cmd){
        queue.add(cmd);
    }

    public Command getLast(){
        Command last = queue.get(0);
        queue.remove(0);
        return last;
    }

    public int getSize(){
        return queue.size();
    }
}
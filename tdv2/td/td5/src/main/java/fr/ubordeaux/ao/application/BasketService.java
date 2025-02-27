package fr.ubordeaux.ao.application;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.ubordeaux.ao.application.cqrs.BasketCommand;
import fr.ubordeaux.ao.application.cqrs.CommandQueue;
import fr.ubordeaux.ao.application.cqrs.Worker;
import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.Basket;
import fr.ubordeaux.ao.domain.model.CommandLine;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.repository.BasketRepository;
import fr.ubordeaux.ao.domain.type.PosInt;
import fr.ubordeaux.ao.infra.inmemory.JsonBasketRepository;

public class BasketService {
    
    private Basket basket;
    private BasketRepository repo;

    private CommandQueue queue;

    public final int NWORKER = 2;

    private ExecutorService executor;

    public BasketService(){
        repo = new JsonBasketRepository();
        queue = CommandQueue.getInstance();
        load();
        
        executor = Executors.newFixedThreadPool(NWORKER);
        for (int i = 0; i < 2; i++) {
            Runnable worker = new Worker(i);
            executor.execute(worker);
        
        }

    }

    public Set<CommandLine> getCommandFromBasket(){
        return  basket.getAll();
    }

    public void order(Reference r, int quantity){
        basket.addOrder(r, new PosInt(quantity));
        BasketCommand cmd = new BasketCommand(new BasketDTO(basket), repo);
        queue.add(cmd);
        repo.save(new BasketDTO(basket));
    }

    public void load(){
        if(basket == null)
            basket = repo.load();
    }

    public void stop(){
        System.out.println("All thread shutdown.."); // Wait executor finnished
        executor.shutdown();
        while(!executor.isTerminated());
    }

}
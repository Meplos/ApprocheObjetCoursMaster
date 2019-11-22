package fr.ubordeaux.ao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.*;
import fr.ubordeaux.ao.domain.repository.BasketRepository;
import fr.ubordeaux.ao.domain.type.*;
import fr.ubordeaux.ao.infra.inmemory.JsonBasketRepository;

public class BasketService {
    
    private Basket basket;
    private BasketRepository repo;

    BasketCommandQueue queue;

    private List<Thread> pool;

    public BasketService(){
        repo = new JsonBasketRepository();
        queue = BasketCommandQueue.getInstance();
        load();
        
        pool = new ArrayList<>();
        pool.add(new BasketWorker());
        pool.add(new BasketWorker());

        pool.forEach(c -> c.start());


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


}
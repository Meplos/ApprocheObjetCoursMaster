package fr.ubordeaux.ao.application;

import java.util.Set;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.*;
import fr.ubordeaux.ao.domain.repository.BasketRepository;
import fr.ubordeaux.ao.domain.type.*;
import fr.ubordeaux.ao.infra.inmemory.JsonBasketRepository;

public class BasketService {
    
    private Basket basket;
    private BasketRepository repo;
    public BasketService(){
        basket = new Basket();
        repo = new JsonBasketRepository();
    }

    public Set<CommandLine> getCommandFromBasket(){
        return  basket.getAll();
    }

    public void order(Reference r, int quantity){
        basket.addOrder(r, new PosInt(quantity));
    }

    public void save(){
        repo.save(new BasketDTO(basket));
    }


}
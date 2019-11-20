package fr.ubordeaux.ao.application;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.repository.BasketRepository;

public class BasketCommand{
    private BasketDTO basket;
    private BasketRepository repo;

    BasketCommand(BasketDTO basket, BasketRepository repo){
        this.basket = basket;
        this.repo = repo;
    }

    public void exec(){
        repo.save(basket);
    }
}
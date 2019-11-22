package fr.ubordeaux.ao.application.cqrs;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.repository.BasketRepository;

public class BasketCommand implements Command{
    private BasketDTO basket;
    private BasketRepository repo;

    public BasketCommand(BasketDTO basket, BasketRepository repo){
        this.basket = basket;
        this.repo = repo;
    }

    @Override
    public void exec(){
        repo.save(basket);
    }
}
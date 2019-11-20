package fr.ubordeaux.ao.application;

import java.util.Set;

import fr.ubordeaux.ao.domain.model.*;
import fr.ubordeaux.ao.domain.type.*;

public class BasketService {
    
    private Basket basket;

    public BasketService(){
        basket = new Basket();
    }

    public Set<CommandLine> getCommandFromBasket(){
        return  basket.getAll();
    }

    public void order(Reference r, int quantity){
        basket.addOrder(r, new PosInt(quantity));
    }


}
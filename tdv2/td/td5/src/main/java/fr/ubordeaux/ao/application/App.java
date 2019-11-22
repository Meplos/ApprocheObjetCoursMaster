package fr.ubordeaux.ao.application;

import java.util.ArrayList;
import java.util.List;

import fr.ubordeaux.ao.domain.model.Basket;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.CommandLine;

public class App {

    public static void main(String[] args) {
        BasketService bService = new BasketService();
        Catalog catalog = new Catalog();

        for (CommandLine curr : bService.getCommandFromBasket()) {
           System.out.println(curr.toString());
       };
        
    }

}

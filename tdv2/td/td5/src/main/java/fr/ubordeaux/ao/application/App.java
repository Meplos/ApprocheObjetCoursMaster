package fr.ubordeaux.ao.application;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.CommandLine;
import fr.ubordeaux.ao.domain.type.Identifier;
import fr.ubordeaux.ao.domain.type.PosInt;

public class App {

    public static void main(String[] args) {
        BasketService bService = new BasketService();
        Catalog catalog = new Catalog();

        for (CommandLine curr : bService.getCommandFromBasket()) {
           System.out.println(curr.toString());
        };
        

        bService.order(catalog.findBy(new Identifier("BRLDS3")), 1);
        System.out.println("App will terminated");
        bService.stop();
        
    }

}

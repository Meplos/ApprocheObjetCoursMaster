package fr.ubordeaux.ao.ui;

import java.util.Scanner;
import java.util.Set;

import fr.ubordeaux.ao.application.BasketService;
import fr.ubordeaux.ao.domain.model.*;
import fr.ubordeaux.ao.domain.type.*;


public class ConsoleMain {

   
    public static void main(String[] args) {
        BasketService basketService = new BasketService();
        Catalog ctl = new Catalog();
        basketService.order(ctl.get(1),1);
        for( CommandLine c : basketService.getCommandFromBasket()){
            System.out.println(c);
        }
    }

    static void printCatalog(Catalog ctl) {
       for (int i = 0; i < ctl.size(); i++) {
           System.out.println(i+") "+ctl.get(i).toString());
       }
    }

}
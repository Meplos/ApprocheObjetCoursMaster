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

        for( CommandLine c : basketService.getCommandFromBasket()){
            System.out.println(c);
        }

    }



}
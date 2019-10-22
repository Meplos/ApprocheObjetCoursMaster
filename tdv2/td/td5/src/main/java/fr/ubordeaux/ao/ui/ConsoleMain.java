package fr.ubordeaux.ao.ui;

import java.util.Set;

import fr.ubordeaux.ao.domain.model.Basket;
import fr.ubordeaux.ao.domain.model.CommandLine;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.Description;
import fr.ubordeaux.ao.domain.type.Identifier;
import fr.ubordeaux.ao.domain.type.Name;
import fr.ubordeaux.ao.domain.type.PosInt;

public class ConsoleMain {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Reference ref1 = new Reference(new Identifier("872504qiouzhjfjijomM"),
         new Name("Balaie"), 
         new Description("Outils qui sert a faire le menage"),
         new PosInt(5));


        Reference ref2 = new Reference(new Identifier("872504qi486hjfjijomM"),
         new Name("Chocolat"), 
         new Description("Nourriture"),
         new PosInt(2));

        Reference ref3 = new Reference(new Identifier("872AZDqiouzhjfjijomM"),
         new Name("Aspirateur"), 
         new Description("Outils qui sert a faire le menage"),
         new PosInt(150));
         
        basket.addOrder(ref1, new PosInt(1));
        basket.addOrder(ref2, new PosInt(50));
        basket.addOrder(ref3, new PosInt(1));
        basket.removeOrder(ref1);

        basket.validate();

        Set<CommandLine> list = basket.getAll();

        for (CommandLine commandLine : list) {
            System.out.println(commandLine+"\n");
        }
    }


}
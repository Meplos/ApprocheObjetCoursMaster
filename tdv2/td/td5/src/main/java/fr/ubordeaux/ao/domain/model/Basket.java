package  fr.ubordeaux.ao.domain.model;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.domain.type.PosInt;

public class Basket {

    private Set<CommandLine> order;
    private PosInt total;
    private Boolean isValidate;

    public Set<CommandLine> getAll(){
        Set<CommandLine> cpy = new HashSet<>();
        for (CommandLine commandLine : this.order) {
            cpy.add(commandLine);
        }
        return cpy;
    }
    public void addOrder(Reference ref, PosInt quantity) { 
        //Can't contain two same ref
        if(isValidate) {
            System.out.println("basket is validate");
            return;
        }
        for (CommandLine commandLine : order) {
            if(commandLine.getReference().equals(ref)){
                throw new RuntimeException("Ref already exist");
            }
        }
        PosInt price = new PosInt(quantity.value * ref.getPrice().value);
        CommandLine command = new CommandLine(ref, quantity, new PosInt(quantity.value * price.value));
        order.add(command);
        total = new PosInt(total.value + price.value);
    }  

    public void removeOrder( Reference ref ) { 
        if(isValidate) {
            System.out.println("basket is validate");
            return;
        }
        CommandLine c = null;
        for (CommandLine commandLine : order) {
            if(commandLine.getReference().equals(ref)){
                c = commandLine;
                break;
            }
        }
        if(c == null ) {
            return;
        }
        total = new PosInt(total.value - c.getPrice().value);
        order.remove(c);
    }

    public void validate(){
        this.isValidate = true;
    }

    public Basket() {
        order = new HashSet<>();
        total = new PosInt(0);
        this.isValidate = false;
    }

    @Override
    public String toString() {
        return "Basket [isValidate=" + isValidate + ", order=" + order + ", total=" + total + "]";
    }


    
}

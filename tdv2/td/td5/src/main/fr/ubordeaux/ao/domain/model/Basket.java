package fr.ubordeaux.ao.model;

import java.util.*;
import fr.ubordeaux.ao.type;

public class Basket {

    private Set<CommandLine> order;
    private PosInt total;
    private Boolean isValidate;

    public void addOrder(Reference ref, PosInt number) { 
        //Can't contain two same ref
    }  

    public void removeOrder( Reference ref ) { 

    }

    public void validate(){
        this.isValidate = true;
    }

    private void refreshTotal(PosInt price) {
        this.total = new PosInt(this.total.value + price.validate);
    }

    public Basket() {
        command = new HashSet();
        total = new PosInt(0);
        this.isValidate = false;
    }
}
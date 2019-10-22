package fr.ubordeaux.ao.domain.model;

public class CommandLine {
    private Reference reference;
    private PosInt quantity;
    private PosInt price;

    public CommandLine(Reference ref, PosInt quantity, PosInt price) {
        this.reference = ref;
        this.quantity = quantity;
        this.price = price;
    }

    

    
}
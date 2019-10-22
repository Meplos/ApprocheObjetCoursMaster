package fr.ubordeaux.ao.domain.model;

public class CommanLine {
    private Reference reference;
    private PosInt quantity;
    private PosInt price;

    public CommanLine(Reference ref, PosInt quantity, PosInt price) {
        this.reference = ref;
        this.quantity = quantity;
        this.price = price;
    }

    
}
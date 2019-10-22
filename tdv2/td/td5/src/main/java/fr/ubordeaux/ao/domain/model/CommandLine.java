package fr.ubordeaux.ao.domain.model;

import fr.ubordeaux.ao.domain.type.PosInt;
public class CommandLine {
    private Reference reference;
    private PosInt quantity;
    private PosInt price;

    public CommandLine(Reference ref, PosInt quantity, PosInt price) {
        this.reference = ref;
        this.quantity = quantity;
        this.price = price;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public PosInt getQuantity() {
        return quantity;
    }

    public void setQuantity(PosInt quantity) {
        this.quantity = quantity;
    }

    public PosInt getPrice() {
        return price;
    }

    public void setPrice(PosInt price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommandLine other = (CommandLine) obj;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommandLine [price=" + price + ", quantity=" + quantity + ", reference=" + reference + "]";
    }

    
    
    
}

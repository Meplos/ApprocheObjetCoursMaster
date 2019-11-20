package fr.ubordeaux.ao.domain.model;

import fr.ubordeaux.ao.domain.type.*;

public class Reference {

    private Identifier ref;
    private Name name;
    private Description description;
    private PosInt price;

    public Reference(Identifier ref, Name name, Description description, PosInt price) {
        this.ref = ref;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Identifier getRef() {
        return ref;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public PosInt getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((ref == null) ? 0 : ref.hashCode());
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
        Reference other = (Reference) obj;
        if (!ref.equals(other.ref))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name.toString();
    }

 
        
}
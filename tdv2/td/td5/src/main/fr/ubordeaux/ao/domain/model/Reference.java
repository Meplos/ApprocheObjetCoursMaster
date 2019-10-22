package fr.ubordeaux.ao.domain.model;

import fr.ubordeaux.ao.domain.type;

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

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reference ref = (Reference) obj;
        return this.ref.equals(obj.ref); 
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    
}

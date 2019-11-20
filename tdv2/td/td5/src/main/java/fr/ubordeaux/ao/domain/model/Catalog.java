package fr.ubordeaux.ao.domain.model;

import fr.ubordeaux.ao.domain.type.*;

import java.util.*;

public class Catalog {
    private List<Reference> refs;
    
    public Catalog() {
        refs = new ArrayList();
        Reference r1 = new Reference(
            new Identifier("cy2077"), 
            new Name("Cyberpunk 2077"), 
            new Description("Best Game ever"), 
            new PosInt(60));
        Reference r2 = new Reference(
            new Identifier("AOE2"), 
            new Name("Age Of Empire II"),
            new Description("Best RTS ever"),
            new PosInt(20));
            
        Reference r3 = new Reference(
            new Identifier("BRLDS3"),
            new Name("Borderlands"),
            new Description("Best Hype ever"), 
            new PosInt(60));
        Reference r4 = new Reference(
            new Identifier("lnlymtn"),
            new Name("Lonely Moutain"),
            new Description("Best downhill game ever"),
            new PosInt(60));            

            refs.add(r1);
            refs.add(r2);
            refs.add(r3);
            refs.add(r4);

    }

    public int size(){
        return refs.size();
    }

    public Reference findBy(Identifier Id) {
        for (Reference reference : refs) {
            if(reference.getRef().equals(Id)){
                return reference;
            }
        }
        throw new RuntimeException("Reference Not Found");
    }

    public Set<Reference> getAll(){
        Set<Reference> references = new HashSet<>();
        for (Reference current : refs) {
            references.add(current);
        }
        return references;
    }
}
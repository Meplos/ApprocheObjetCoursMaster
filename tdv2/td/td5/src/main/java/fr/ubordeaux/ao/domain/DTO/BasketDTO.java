package fr.ubordeaux.ao.domain.DTO;

import java.util.HashMap;

import fr.ubordeaux.ao.domain.model.Basket;
import fr.ubordeaux.ao.domain.model.CommandLine;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.PosInt;

public class BasketDTO {
    public final HashMap<Reference,PosInt> q = new HashMap<>();

    public BasketDTO(Basket b){
        for (CommandLine current : b.getAll()) {
            q.put(current.getReference(), current.getQuantity());
        }
    }

    public void append(Reference ref,PosInt quantity){
        q.put(ref, quantity);
    }


}
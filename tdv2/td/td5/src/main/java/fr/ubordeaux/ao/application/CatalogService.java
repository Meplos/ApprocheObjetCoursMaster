package fr.ubordeaux.ao.application;

import fr.ubordeaux.ao.domain.model.*;
import fr.ubordeaux.ao.domain.type.Identifier;

import java.util.Set;


public class CatalogService{
    private Catalog catalog;

    public CatalogService(){
        catalog = new Catalog();
    }

    public Set<Reference> getAllRefFromCatalog(){
        return catalog.getAll();
    }

    public Reference findReferenceById(Identifier refId) {
        return catalog.findBy(refId);
    }


}
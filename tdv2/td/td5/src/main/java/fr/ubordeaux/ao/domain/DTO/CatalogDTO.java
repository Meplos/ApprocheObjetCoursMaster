package fr.ubordeaux.ao.domain.DTO;

import java.util.Set;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public class CatalogDTO {

    public final Set<Reference> list;
	public CatalogDTO(Catalog catalog) {
        list = catalog.getAll();
    }

    
}
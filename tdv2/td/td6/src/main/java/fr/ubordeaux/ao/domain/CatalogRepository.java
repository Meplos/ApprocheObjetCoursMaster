package fr.ubordeaux.ao.domain;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public interface CatalogRepository {

    public void save(Reference r);

    public Catalog load(); // On verra ça plus tard.
}
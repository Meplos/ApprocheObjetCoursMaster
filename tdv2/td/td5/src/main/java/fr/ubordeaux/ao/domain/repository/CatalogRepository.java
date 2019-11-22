package fr.ubordeaux.ao.domain.repository;

import fr.ubordeaux.ao.domain.DTO.CatalogDTO;
import fr.ubordeaux.ao.domain.model.Catalog;;

public interface CatalogRepository {

    public void save(CatalogDTO catalog);
    public Catalog load();
    

}
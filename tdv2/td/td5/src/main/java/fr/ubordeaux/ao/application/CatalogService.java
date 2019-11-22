package fr.ubordeaux.ao.application;

import java.util.Set;

import fr.ubordeaux.ao.application.cqrs.CatalogCommand;
import fr.ubordeaux.ao.application.cqrs.CommandQueue;
import fr.ubordeaux.ao.domain.DTO.CatalogDTO;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.repository.CatalogRepository;
import fr.ubordeaux.ao.infra.inmemory.JsonCatalogRepository;

public class CatalogService {

    private Catalog catalog;
    private CatalogRepository repo;

    private CommandQueue queue;


    public CatalogService() {
        repo = new JsonCatalogRepository();
        queue = CommandQueue.getInstance();
        load();

       

    }

    public Set<Reference> getCommandFromCatalog() {
        return catalog.getAll();
    }


    public void load() {
        if (catalog == null)
            catalog = repo.load();
    }

    public void save(){
        queue.add(
            new CatalogCommand(new CatalogDTO(catalog),repo));
    }


}
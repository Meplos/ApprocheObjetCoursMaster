package fr.ubordeaux.ao.application.cqrs;

import fr.ubordeaux.ao.domain.DTO.CatalogDTO;
import fr.ubordeaux.ao.domain.repository.CatalogRepository;

public class CatalogCommand implements Command {
    private CatalogDTO catalog;
    private CatalogRepository repo;

    public CatalogCommand(CatalogDTO catalog, CatalogRepository repo){
        this.catalog = catalog;
        this.repo = repo;
    }

    @Override
    public void exec() {
        repo.save(catalog);
    }
}
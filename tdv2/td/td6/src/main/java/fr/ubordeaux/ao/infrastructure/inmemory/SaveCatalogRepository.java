package fr.ubordeaux.ao.infrastructure.inmemory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import fr.ubordeaux.ao.domain.CatalogRepository;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

import org.json.*;
public class SaveCatalogRepository implements CatalogRepository {

    public SaveCatalogRepository(){
        super();
    }
    
    @Override
    public void save(Reference r) {
        try {
            File file = new File("./tmp/save.json");
             parser = new JSONParser() 
        } catch (IOException e) {
            System.out.println("We cannot save catalog in file");
            e.printStackTrace();
        }
          

    }

    @Override
    public Catalog load() {
        // TODO Auto-generated method stub
        return null;
    }

 }
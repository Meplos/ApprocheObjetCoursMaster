package fr.ubordeaux.ao.infra.inmemory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.*;

import fr.ubordeaux.ao.domain.DTO.CatalogDTO;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.repository.CatalogRepository;
import fr.ubordeaux.ao.domain.type.Description;
import fr.ubordeaux.ao.domain.type.Identifier;
import fr.ubordeaux.ao.domain.type.Name;
import fr.ubordeaux.ao.domain.type.PosInt;
public class JsonCatalogRepository implements CatalogRepository {

    private final String  CATALOG_SAVE_FILE = "Catalog.json";

    @Override
    public void save(CatalogDTO catalog) {
        JSONArray references = new JSONArray();
        for(Reference ref : catalog.list) {
            JSONObject curr = new JSONObject();
            curr.put("ref", ref.getRef());
            curr.put("name", ref.getName());
            curr.put("description", ref.getDescription());
            curr.put("price",ref.getPrice().value);
            
            references.put(curr);
        }
        JSONObject json = new JSONObject();
        json.put("catalog",references);

        try{
            FileWriter file = new FileWriter(CATALOG_SAVE_FILE);
            file.write(json.toString());
            file.flush();
        } catch (IOException e) {
            System.out.println("File can't be open");
            e.printStackTrace();
        }

    }

    @Override
    public Catalog load() {
        try {
            JSONTokener tokener = new JSONTokener(new FileInputStream(CATALOG_SAVE_FILE));
            JSONObject json = new JSONObject(tokener);
            JSONArray array = json.getJSONArray("catalog");
            Iterator<Object> it = array.iterator();
            Catalog catalog = new Catalog();
            while (it.hasNext()) {
                JSONObject curr = (JSONObject) it.next();
                System.out.println(curr.toString());
                Identifier id = new Identifier(curr.getString("ref"));
                Name name = new Name(curr.getString("name"));
                Description description = new Description("Description");
                PosInt price = new PosInt(curr.getInt("price"));
                catalog.add(new Reference(id, name, description, price));
            }
            return catalog;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Catalog();
    }
    
}
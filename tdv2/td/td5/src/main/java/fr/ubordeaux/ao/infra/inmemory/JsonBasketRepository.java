package fr.ubordeaux.ao.infra.inmemory;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.Basket;
import fr.ubordeaux.ao.domain.model.CommandLine;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.repository.BasketRepository;
import fr.ubordeaux.ao.domain.type.Description;
import fr.ubordeaux.ao.domain.type.Identifier;
import fr.ubordeaux.ao.domain.type.Name;
import fr.ubordeaux.ao.domain.type.PosInt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.*;

public class JsonBasketRepository implements BasketRepository {

    private String BASKET_SAVE_FILE = "basket.json";

    public JsonBasketRepository() {
    }

    @Override
    public void save(BasketDTO basket) {
        JSONArray commandLine = new JSONArray();
        for (Map.Entry<Reference, PosInt> e : basket.q.entrySet()) {
            JSONObject reference = new JSONObject();
            reference.put("ref", e.getKey().getRef());
            reference.put("name", e.getKey().getName());
            reference.put("description", e.getKey().getDescription());
            reference.put("price", e.getKey().getPrice().value);
            reference.put("quantity", e.getValue().value);
            commandLine.put(reference);
        }
        JSONObject json = new JSONObject();
        json.put("basket", commandLine);

        try {
            FileWriter file = new FileWriter(BASKET_SAVE_FILE);
            file.write(json.toString());
            file.flush();
        } catch (IOException e1) {
            System.out.println("File can't be open");
            e1.printStackTrace();
        }
    }

    @Override
    public Basket load() {
        try {
            JSONTokener tokener = new JSONTokener(new FileInputStream(BASKET_SAVE_FILE));
            JSONObject json = new JSONObject(tokener);
            JSONArray array = json.getJSONArray("basket");
            Iterator<Object> it = array.iterator();
            Basket basket = new Basket();
            while(it.hasNext()) {
                JSONObject curr = (JSONObject) it.next();
                System.out.println(curr.toString());
                Identifier id = new Identifier(curr.getString("ref"));
                Name name = new Name(curr.getString("name"));
                Description description = new Description("Description");
                PosInt price = new PosInt(curr.getInt("price"));
                PosInt quantity = new PosInt(curr.getInt("quantity"));
                basket.addOrder(new Reference(id, name, description, price), quantity);            
            }
            return basket;
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new Basket();
    }

}
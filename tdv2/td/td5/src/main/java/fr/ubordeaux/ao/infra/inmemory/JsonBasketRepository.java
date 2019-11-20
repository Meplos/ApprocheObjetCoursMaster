package fr.ubordeaux.ao.infra.inmemory;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.repository.BasketRepository;
import fr.ubordeaux.ao.domain.type.PosInt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
    public void load() {
        // TODO Auto-generated method stub

    }

}
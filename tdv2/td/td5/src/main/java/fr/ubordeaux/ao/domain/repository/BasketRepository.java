package fr.ubordeaux.ao.domain.repository;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;
import fr.ubordeaux.ao.domain.model.Basket;
public interface BasketRepository {

    public void save(BasketDTO basket);

    public Basket load();

}
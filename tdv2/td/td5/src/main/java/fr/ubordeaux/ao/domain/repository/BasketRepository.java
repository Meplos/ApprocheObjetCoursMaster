package fr.ubordeaux.ao.domain.repository;

import fr.ubordeaux.ao.domain.DTO.BasketDTO;

public interface BasketRepository {

    public void save(BasketDTO basket);

    public void load();

}
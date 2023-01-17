package com.platzi.market.persistance.crud;

import com.platzi.market.persistance.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase,Integer> {

    public Optional<List<Purchase>> findByClientId(String clientId);
}

package com.platzi.market.persistance.crud;

import com.platzi.market.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {

    public List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

}

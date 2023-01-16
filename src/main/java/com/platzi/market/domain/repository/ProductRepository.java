package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);

    Optional<List<ProductDTO>> getScarseProducts(int quantity);

    Optional<ProductDTO> getProduct(int productId);

    ProductDTO save(ProductDTO product);

    void delete(int productId);
}

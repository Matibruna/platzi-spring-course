package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll(){
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO productDTO){
        return productRepository.save(productDTO);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(productDTO -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }


}

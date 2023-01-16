package com.platzi.market.persistance;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistance.crud.ProductCrudRepository;
import com.platzi.market.persistance.entity.Product;
import com.platzi.market.persistance.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.platzi.market.domain.repository.ProductRepository {

    private final ProductCrudRepository productCrudRepository;

    private final ProductMapper mapper;


    public ProductRepository(ProductCrudRepository productCrudRepository, ProductMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    public List<ProductDTO> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDTO(products);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDTO(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    public Optional<ProductDTO> getProduct(int productId){
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDTO(product));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return mapper.toProductDTO(productCrudRepository.save(mapper.toProduct(productDTO)));
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }

}

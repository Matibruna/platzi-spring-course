package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDTO> getAll(){
        return productService.getAll();
    }

    @GetMapping("/get/{productId}")
    public Optional<ProductDTO> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/get/category/{categoryId}")
    public Optional<List<ProductDTO>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/")
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable("productId") int productId){
        return productService.delete(productId);
    }


}

package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("productId") int productId){
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @GetMapping("/get/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(productDTOS -> new ResponseEntity<>(productDTOS, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}

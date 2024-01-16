package com.productservice.product.controllers;

import com.productservice.product.dtos.GenericProductDto;
import com.productservice.product.exceptions.NotFoundException;
import com.productservice.product.services.FakeStoreProductService;
import com.productservice.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private FakeStoreProductService fakeStoreProductService;

    @Autowired
    public ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService=fakeStoreProductService;
    }


    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return fakeStoreProductService.getProductById(id);
    }
    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id) throws NotFoundException{
       return  fakeStoreProductService.updateProduct(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return fakeStoreProductService.createProduct(genericProductDto);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return fakeStoreProductService.getAllProducts();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(fakeStoreProductService.deleteProduct(id), HttpStatus.OK);
    }
}

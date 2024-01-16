package com.productservice.product.services;

import com.productservice.product.dtos.GenericProductDto;
import com.productservice.product.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProduct(Long id);

    public GenericProductDto updateProduct(Long id) throws NotFoundException;
}

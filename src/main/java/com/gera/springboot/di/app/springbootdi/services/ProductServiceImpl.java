package com.gera.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.gera.springboot.di.app.springbootdi.models.Product;
import com.gera.springboot.di.app.springbootdi.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll () {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct = p.clone(); 
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}

package com.gera.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gera.springboot.di.app.springbootdi.models.Product;
import com.gera.springboot.di.app.springbootdi.repositories.ProductRepositoryImpl;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryImpl repository;

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
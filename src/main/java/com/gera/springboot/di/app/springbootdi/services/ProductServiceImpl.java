package com.gera.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gera.springboot.di.app.springbootdi.models.Product;
import com.gera.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    // @Autowired
    // @Qualifier("productFoo")
    private ProductRepository repository;

    public ProductServiceImpl( @Qualifier("productFoo") ProductRepository repository) {
        this.repository = repository;
    }

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

package com.gera.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gera.springboot.di.app.springbootdi.models.Product;
import com.gera.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    // @Autowired
    private Environment environment;

    // @Autowired
    // @Qualifier("productFoo")
    private ProductRepository repository;

    public ProductServiceImpl( @Qualifier("productJson") ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll () {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            System.out.println(environment.getProperty("config.price.tax", Double.class));
            // Product newProduct = new Product(p.getId(), p.getName(), p.getPrice());

            Product newProduct = p.clone(); 
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}

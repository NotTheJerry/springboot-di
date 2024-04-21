package com.gera.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gera.springboot.di.app.springbootdi.models.Product;
import com.gera.springboot.di.app.springbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService();

    @GetMapping("/")
    public List<Product> list() {
        ProductService service = new ProductService();
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show( @PathVariable Long id ) {
        ProductService service = new ProductService();
        return service.findById(id);
    }
}
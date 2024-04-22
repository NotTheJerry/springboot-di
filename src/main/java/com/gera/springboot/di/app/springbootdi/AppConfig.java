package com.gera.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.gera.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.gera.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:/config.properties")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJSON () {
        return new ProductRepositoryJson();
    }

}

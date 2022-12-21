package com.zara.interview.application.infraestructure.output.persistence.csv.config;

import com.zara.interview.application.domain.repository.ProductRepository;
import com.zara.interview.application.infraestructure.output.persistence.csv.ProductCsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCsvRepositoryConfig {

    private final String productDataResourcePath;

    @Autowired
    public ProductCsvRepositoryConfig(@Value("${csv.data.products.path}") String resourcePath) {
        this.productDataResourcePath = resourcePath;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductCsvRepository(productDataResourcePath);
    }

}

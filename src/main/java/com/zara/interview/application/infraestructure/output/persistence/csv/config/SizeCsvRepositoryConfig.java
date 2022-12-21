package com.zara.interview.application.infraestructure.output.persistence.csv.config;

import com.zara.interview.application.domain.repository.SizeRepository;
import com.zara.interview.application.infraestructure.output.persistence.csv.SizeCsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SizeCsvRepositoryConfig {

    private final String sizeDataResourcePath;
    private final String stockDataResourcePath;

    @Autowired
    public SizeCsvRepositoryConfig(
            @Value("${csv.data.size.path}") String sizeDataResourcePath,
            @Value("${csv.data.stock.path}") String stockDataResourcePath) {
        this.sizeDataResourcePath = sizeDataResourcePath;
        this.stockDataResourcePath = stockDataResourcePath;
    }

    @Bean
    public SizeRepository sizeRepository() {
        return new SizeCsvRepository(sizeDataResourcePath, stockDataResourcePath);
    }

}

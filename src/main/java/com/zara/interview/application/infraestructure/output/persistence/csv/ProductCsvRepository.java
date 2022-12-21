package com.zara.interview.application.infraestructure.output.persistence.csv;

import com.zara.interview.application.domain.aggregate.Product;
import com.zara.interview.application.domain.repository.ProductRepository;
import com.zara.interview.application.infraestructure.output.persistence.csv.exception.CsvLoadException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ProductCsvRepository implements ProductRepository {

    private static final int PRODUCT_ID_POSITION = 0;
    private static final int SEQUENCE_POSITION = 1;
    private static final String SEPARATOR = ",";

    private final String csvResourcePath;
    private Map<Integer, Product> products;

    @Autowired
    public ProductCsvRepository(String csvResourcePath) {
        this.csvResourcePath = csvResourcePath;
    }

    @PostConstruct
    public void setUp() {
        try {
            this.products = Files.lines(Path.of(ClassLoader.getSystemResource(csvResourcePath).toURI()))
                    .map(line -> line.split(SEPARATOR))
                    .map(csv -> new Product(
                            Integer.parseInt(csv[PRODUCT_ID_POSITION].trim()),
                            Integer.parseInt(csv[SEQUENCE_POSITION].trim())))
                    .collect(Collectors.toMap(Product::id, product -> product));
        } catch (URISyntaxException | IOException exc) {
            throw new CsvLoadException();
        }
    }

    @Override
    public Set<Product> getAll() {
        return new HashSet<>(products.values());
    }
}

package com.zara.interview.application.infraestructure.output.persistence.csv;

import com.zara.interview.application.domain.aggregate.Size;
import com.zara.interview.application.domain.repository.SizeRepository;
import com.zara.interview.application.infraestructure.output.persistence.csv.exception.CsvLoadException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SizeCsvRepository implements SizeRepository {

    private static final int STOCK_ID_POSITION = 0;
    private static final int STOCK_QUANTITY_POSITION = 1;
    private static final int SIZE_ID_POSITION = 0;
    private static final int PRODUCT_ID_POSITION = 1;
    private static final int BACK_SOON_POSITION = 2;
    private static final int SPECIAL_POSITION = 3;
    private static final String SEPARATOR = ",";

    private final String csvSizeResourcePath;
    private final String csvStockResourcePath;
    private Map<Integer, List<Size>> size;
    private Map<Integer, Integer> stock;

    @Autowired
    public SizeCsvRepository(String csvSizeResourcePath, String csvStockResourcePath) {
        this.csvSizeResourcePath = csvSizeResourcePath;
        this.csvStockResourcePath = csvStockResourcePath;
    }

    @PostConstruct
    public void setUp() {
        try {
            this.stock = loadStock();
            this.size = loadSize();
        } catch (URISyntaxException | IOException exc) {
            throw new CsvLoadException();
        }
    }

    private Map<Integer, List<Size>> loadSize() throws URISyntaxException, IOException {
        return Files.lines(Path.of(ClassLoader.getSystemResource(csvSizeResourcePath).toURI()))
                .map(line -> line.split(SEPARATOR))
                .map(csv -> new Size(
                        Integer.parseInt(csv[SIZE_ID_POSITION].trim()),
                        Integer.parseInt(csv[PRODUCT_ID_POSITION].trim()),
                        getStock(csv[SIZE_ID_POSITION].trim()),
                        Boolean.parseBoolean(csv[BACK_SOON_POSITION].trim()),
                        Boolean.parseBoolean(csv[SPECIAL_POSITION].trim())))
                .collect(Collectors.groupingBy(Size::productId, Collectors.toList()));
    }

    private  Map<Integer, Integer> loadStock() throws URISyntaxException, IOException {
        return Files.lines(Path.of(ClassLoader.getSystemResource(csvStockResourcePath).toURI()))
                .map(line -> line.split(SEPARATOR))
                .collect(Collectors.toMap(
                        csv -> Integer.parseInt(csv[STOCK_ID_POSITION].trim()),
                        csv -> Integer.parseInt(csv[STOCK_QUANTITY_POSITION].trim())));
    }

    private  Integer getStock(String sizeId) {
        return stock.getOrDefault(Integer.parseInt(sizeId), 0);
    }

    @Override
    public List<Size> getAll(int productId) {
        return size.getOrDefault(productId, Collections.emptyList());
    }
}

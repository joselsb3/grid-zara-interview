package com.zara.interview.application.application.usecase;

import com.zara.interview.application.application.dto.GridProductStockResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GridUseCase {

    public GridProductStockResponse getProductGrid() {
        List<Integer> products = new ArrayList<>();

        products.add(5);
        products.add(1);
        products.add(3);

        return new GridProductStockResponse(products);

    }
}

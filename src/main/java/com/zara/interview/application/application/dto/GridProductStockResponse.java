package com.zara.interview.application.application.dto;

import java.util.ArrayList;
import java.util.List;

public class GridProductStockResponse {

    private final List<Integer> productIds;

    public GridProductStockResponse(List<Integer> productIds) {
        this.productIds = new ArrayList<>(productIds);
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}

package com.zara.interview.application.domain.aggregate;

import java.util.Objects;

public class Product {

    private int productId;
    private int sequence;

    public Product(int productId, int sequence) {
        this.productId = productId;
        this.sequence = sequence;
    }

    public int id() {
        return this.productId;
    }

    public int sequence() {
        return this.sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}

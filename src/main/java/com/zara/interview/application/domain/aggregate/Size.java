package com.zara.interview.application.domain.aggregate;

public class Size {

    private int sizeId;
    private int productId;
    private int stock;
    private boolean backSoon;
    private boolean special;

    public Size(int sizeId, int productId, int stock, boolean backSoon, boolean special) {
        this.sizeId = sizeId;
        this.productId = productId;
        this.stock = stock;
        this.backSoon = backSoon;
        this.special = special;
    }

    public int productId() {
        return productId;
    }

    public boolean isSpecial() {
        return this.special;
    }

    public boolean hasStock() {
        return this.stock > 0;
    }

    public boolean isBackSoon() {
        return this.backSoon;
    }

    public int sizeId() {
        return this.sizeId;
    }
}

package com.zara.interview.application.domain.aggregate;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ProductMother {

    public static Product random() {
        return new Product(
                Faker.instance().number().randomDigitNotZero(),
                Faker.instance().number().randomDigitNotZero());
    }

    public static List<Product> randomProducts() {
        final List<Product> products = new ArrayList<>();
        for (int i = 0; i < Faker.instance().number().numberBetween(1, 10); i++) {
            products.add(random());
        }
        return products;
    }

}
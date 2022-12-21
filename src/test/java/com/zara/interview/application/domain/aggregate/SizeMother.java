package com.zara.interview.application.domain.aggregate;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SizeMother {

    public static Size random() {
        return new Size(
                Faker.instance().number().randomDigitNotZero(),
                Faker.instance().number().randomDigitNotZero(),
                Faker.instance().number().randomDigitNotZero(),
                Faker.instance().bool().bool(),
                Faker.instance().bool().bool());
    }

    public static Size with(int productId) {
        return new Size(
                Faker.instance().number().randomDigitNotZero(),
                productId,
                Faker.instance().number().randomDigitNotZero(),
                Faker.instance().bool().bool(),
                Faker.instance().bool().bool()
        );
    }

    public static List<Size> sizesWith(int productIds) {
        final List<Size> sizes = new ArrayList<>();
        for (int i = 0; i < Faker.instance().number().numberBetween(1, 10); i++) {
            sizes.add(with(productIds));
        }
        return sizes;
    }

    public static Map<Integer, List<Size>> sizesWithProducts(List<Product> products) {

        for (Product product : products) {
            sizesWith(product.id());
        }

        return null;
    }


}

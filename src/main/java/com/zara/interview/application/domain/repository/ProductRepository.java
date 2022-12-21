package com.zara.interview.application.domain.repository;

import com.zara.interview.application.domain.aggregate.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository {
    Set<Product> getAll();
}

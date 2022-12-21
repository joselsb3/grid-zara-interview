package com.zara.interview.application.application.usecase;

import com.zara.interview.application.application.dto.GridProductStockResponse;
import com.zara.interview.application.domain.aggregate.Product;
import com.zara.interview.application.domain.aggregate.Size;
import com.zara.interview.application.domain.repository.ProductRepository;
import com.zara.interview.application.domain.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GridUseCase {

    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;

    @Autowired
    public GridUseCase(ProductRepository productRepository,
                       SizeRepository sizeRepository) {
        this.productRepository = productRepository;
        this.sizeRepository = sizeRepository;
    }

    public GridProductStockResponse getProductGrid() {
        final Set<Product> allProducts = productRepository.getAll();
        return new GridProductStockResponse(
                allProducts.stream()
                        .filter(this::showAlgorithm)
                        .sorted(Comparator.comparing(Product::sequence))
                        .map(Product::id)
                        .collect(Collectors.toList()));
    }

    private boolean showAlgorithm(Product product) {
        List<Size> allSizes = sizeRepository.getAll(product.id());

        if (allSizes.isEmpty()) {
            return false;
        }

        Optional<Size> firstSpecial = allSizes.stream().filter(Size::isSpecial).findFirst();
        firstSpecial.ifPresent(allSizes::remove);

        Optional<Size> backSoon = allSizes.stream().filter(Size::isBackSoon).findFirst();

        if (backSoon.isPresent()) {
            return true;
        }

        Optional<Size> hasStock = allSizes.stream()
                .filter(Size::hasStock)
                .findFirst();

        return hasStock.isPresent();

    }
}

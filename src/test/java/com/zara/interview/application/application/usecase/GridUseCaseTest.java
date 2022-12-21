package com.zara.interview.application.application.usecase;

import com.zara.interview.application.application.dto.GridProductStockResponse;
import com.zara.interview.application.domain.aggregate.Product;
import com.zara.interview.application.domain.aggregate.ProductMother;
import com.zara.interview.application.domain.aggregate.Size;
import com.zara.interview.application.domain.aggregate.SizeMother;
import com.zara.interview.application.domain.repository.ProductRepository;
import com.zara.interview.application.domain.repository.SizeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GridUseCaseTest {

    @Autowired
    private GridUseCase gridUseCase;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private SizeRepository sizeRepository;

    @Test
    public void when_getProductsGrid_productMustExist() {
        //given
        final Product product = ProductMother.random();
        final List<Size> sizes = SizeMother.sizesWith(product.id());
        final Set<Product> products = Set.of(product);
        when(productRepository.getAll()).thenReturn(products);
        when(sizeRepository.getAll(product.id())).thenReturn(sizes);

        //when
        GridProductStockResponse productGrid = gridUseCase.getProductGrid();

        //then
        assertTrue(productGrid.getProductIds().contains(product.id()));
    }

    @Test
    public void when_getProductsGrid_productMustBeEmpty() {
        //given
        when(productRepository.getAll()).thenReturn(Collections.emptySet());

        //when
        GridProductStockResponse productGrid = gridUseCase.getProductGrid();

        //then
        assertTrue(productGrid.getProductIds().isEmpty());
    }

}
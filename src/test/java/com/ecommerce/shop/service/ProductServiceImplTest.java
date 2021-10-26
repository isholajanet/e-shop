package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.model.ProductDto;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProductMockTest(){
        Product product = new Product();
        product.setId(1L);
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);

        System.out.println(product.getId());


        ProductDto productDto = new ProductDto();

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productServiceImpl.update(1L, productDto)).thenReturn(product);
        productServiceImpl.update(1L, productDto);

        verify(productRepository, times(2)).save(product);

    }
}
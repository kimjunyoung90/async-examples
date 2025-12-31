package org.example.common.service;

import org.example.common.entity.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {
    public Product getProductInfo(Long productId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Product product = Product.builder()
                .id(productId)
                .name("Product " + productId)
                .price(10000)
                .description("상품 설명")
                .build();

        return product;
    }

    @Async
    public CompletableFuture<Product> getProductInfoAsync(Long productId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Product product = Product.builder()
                .id(productId)
                .name("Product " + productId)
                .price(10000)
                .description("상품 설명")
                .build();

        return CompletableFuture.completedFuture(product);
    }
}

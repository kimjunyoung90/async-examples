package org.example.mvcasync;

import lombok.RequiredArgsConstructor;
import org.example.common.dto.ProductDetail;
import org.example.common.entity.Product;
import org.example.common.entity.Review;
import org.example.common.entity.Stock;
import org.example.common.service.ProductService;
import org.example.common.service.ReviewService;
import org.example.common.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/async/products")
public class AsyncProductsController {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final StockService stockService;

    @GetMapping("/{productId}")
    public ProductDetail getProductDetail(@PathVariable Long productId) {
        CompletableFuture<Product> productFuture = productService.getProductInfoAsync(productId);
        CompletableFuture<List<Review>> reviewFuture = reviewService.getReviewsAsync(productId);
        CompletableFuture<Stock> stockFuture = stockService.getStockAsync(productId);

        CompletableFuture.allOf(productFuture, reviewFuture, stockFuture).join();

        Product product = productFuture.join();
        List<Review> reviews = reviewFuture.join();
        Stock stock = stockFuture.join();

        return new ProductDetail(product, reviews, stock);
    }
}

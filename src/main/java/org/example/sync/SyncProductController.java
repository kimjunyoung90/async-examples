package org.example.sync;

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

@RestController
@RequestMapping("/sync/products")
@RequiredArgsConstructor
public class SyncProductController {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final StockService stockService;

    @GetMapping("/{productId}")
    public ProductDetail getProductDetail(@PathVariable Long productId) {

        Product product = productService.getProductInfo(productId); // 1초
        List<Review> reviews = reviewService.getReviews(productId); // 1초
        Stock stock = stockService.getStock(productId); // 1초

        return new ProductDetail(product, reviews, stock);
    }
}

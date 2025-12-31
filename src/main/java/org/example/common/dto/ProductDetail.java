package org.example.common.dto;

import org.example.common.entity.Product;
import org.example.common.entity.Review;
import org.example.common.entity.Stock;

import java.util.List;

public record ProductDetail(
        Product product,
        List<Review> reviews,
        Stock stock
) {
}

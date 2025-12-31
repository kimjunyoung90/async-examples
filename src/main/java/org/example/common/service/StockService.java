package org.example.common.service;

import org.example.common.entity.Stock;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    public Stock getStock(Long productId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Stock stock = Stock.builder()
                .productId(productId)
                .quantity(100)
                .available(true)
                .warehouse("서울 물류 센터")
                .build();

        return stock;
    }
}

package org.example.common.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock {
    private Long productId;
    private Integer quantity;
    private Boolean available;
    private String warehouse;
}

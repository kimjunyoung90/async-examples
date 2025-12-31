package org.example.common.service;

import org.example.common.entity.Review;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ReviewService {
    public List<Review> getReviews(Long productId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Review> reviews = Arrays.asList(
                Review.builder()
                        .id(1L)
                        .productId(productId)
                        .userId("user1")
                        .rating(5)
                        .comment("좋아요.")
                        .build(),
                Review.builder()
                        .id(2L)
                        .productId(productId)
                        .userId("user2")
                        .rating(4)
                        .comment("괜찮습니다.")
                        .build()
        );

        return reviews;
    }
}

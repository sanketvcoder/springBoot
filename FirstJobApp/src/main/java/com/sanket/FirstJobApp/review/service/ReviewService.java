package com.sanket.FirstJobApp.review.service;

import java.util.List;

import com.sanket.FirstJobApp.review.entity.Review;

public interface ReviewService {

    List<Review> getReviewsByCompanyId(Long companyId);

    Review addReview(Long companyId, Review review);

    void deleteReview(Long reviewId);

    Review updateReview(Long reviewId, Review review);

    Review getReviewById(Long reviewId);

    List<Review> getAllReviews();
}

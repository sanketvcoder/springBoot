package com.sanket.FirstJobApp.review.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sanket.FirstJobApp.review.entity.Review;

public interface reviewController {

    ResponseEntity<List<Review>> getReviewsByCompanyId(Long companyId);

    ResponseEntity<Review> addReview(Long companyId, Review review);

    ResponseEntity<Void> deleteReview(Long reviewId);

    ResponseEntity<Review> updateReview(Long reviewId, Review review);

    ResponseEntity<Review> getReviewById(Long reviewId);

    ResponseEntity<List<Review>> getAllReviews();
}

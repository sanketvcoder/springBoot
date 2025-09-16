package com.sanket.FirstJobApp.review.controller.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.FirstJobApp.review.controller.reviewController;
import com.sanket.FirstJobApp.review.entity.Review;
import com.sanket.FirstJobApp.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1/companies/{companyId}")
public class ReviewControllerImpl implements reviewController {

    private final ReviewService reviewService;

    public ReviewControllerImpl(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviews);
    }

    @Override
    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        Review createdReview = reviewService.addReview(companyId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        return ResponseEntity.ok(updatedReview);
    }

    @Override
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(review);
    }

    @Override
    @GetMapping("/reviews/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}

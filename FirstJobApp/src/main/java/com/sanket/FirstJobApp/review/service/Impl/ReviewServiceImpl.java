package com.sanket.FirstJobApp.review.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.FirstJobApp.Company.entity.Company;
import com.sanket.FirstJobApp.Company.repository.CompanyRepository;
import com.sanket.FirstJobApp.review.entity.Review;
import com.sanket.FirstJobApp.review.repository.ReviewRepository;
import com.sanket.FirstJobApp.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getReviewsByCompanyId(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
        return company.getReviews();
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
        review.setCompany(company);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Review updateReview(Long reviewId, Review review) {
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + reviewId));
        existingReview.setRating(review.getRating());
        existingReview.setTitle(review.getTitle());
        existingReview.setDescription(review.getDescription());
        return reviewRepository.save(existingReview);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + reviewId));
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}

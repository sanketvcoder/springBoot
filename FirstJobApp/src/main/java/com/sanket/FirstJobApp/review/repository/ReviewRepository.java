package com.sanket.FirstJobApp.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.FirstJobApp.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

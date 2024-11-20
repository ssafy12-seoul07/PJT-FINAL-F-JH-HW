package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Review;

public interface ReviewService {
	
	boolean addReview(Review review);
	
	List<Review> getAllReviews(String userId);
	
	Review getReviewById(int reviewId);
	
	boolean deleteReview(int reviewId);

}

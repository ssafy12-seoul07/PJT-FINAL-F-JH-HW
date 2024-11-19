package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dao.ReviewDao;
import com.ssafy.urs.model.dto.Review;

public class ReviewServiceImpl implements ReviewService{
	private final ReviewDao vd;
	
	public ReviewServiceImpl(ReviewDao vd) {
		this.vd=vd;
	}

	@Override
	public boolean addReview(Review review) {
		int result = vd.insertReview(review);
		return result>0;
	}

	@Override
	public List<Review> getAllReviews(int userId) {
	return vd.selectAllReviews(userId);
	}

	@Override
	public Review getReviewById(int reviewId) {
		return vd.selectReviewById(reviewId);
	}

	@Override
	public boolean deleteReview(int reviewId) {
		int result = vd.deleteReview(reviewId);
		return result>0;
	}
	
	

}

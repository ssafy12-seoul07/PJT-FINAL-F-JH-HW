package com.ssafy.urs.model.dao;

import java.util.List;

import com.ssafy.urs.model.dto.Review;


public interface ReviewDao {
	//리뷰 추가
	int insertReview(Review review);
	// 리뷰 전체보기
	List<Review> selectAllReviews(int userId);
	//리뷰 낱개보기
	Review selectReviewById(int reviewId);
	//리뷰 삭제
	int deleteReview(int reviewId);


}

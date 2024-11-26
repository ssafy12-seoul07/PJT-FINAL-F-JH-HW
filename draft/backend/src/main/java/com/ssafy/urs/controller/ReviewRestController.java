package com.ssafy.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.urs.model.dto.Review;
import com.ssafy.urs.model.dto.Route;
import com.ssafy.urs.model.service.ReviewService;

@RestController
@RequestMapping("/urs/review")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // 프론트엔드 도메인

public class ReviewRestController {

	@Autowired
	ReviewService vs;
	
	//리뷰추가
	@PostMapping("/add")
	public ResponseEntity<String> addReview(@RequestBody Review review){
		boolean result = vs.addReview(review);
		if(result) {
			return new ResponseEntity<String>("review successfully added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("review not added", HttpStatus.NOT_IMPLEMENTED);			
		}
	}
	//리뷰보기(완주한경로보기)
	@GetMapping("/all/{userId}")
	public ResponseEntity<?> showAll(@PathVariable("userId") String userId){
		List<Review> list = vs.getAllReviews(userId);
		if(list != null) {
				return  new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no completed walk yet", HttpStatus.NOT_FOUND);
		}
		}
	//리뷰보기(specific리뷰보기)
	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getRouteById(@PathVariable("reviewId") int reviewId){
		Review review = vs.getReviewById(reviewId);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
}

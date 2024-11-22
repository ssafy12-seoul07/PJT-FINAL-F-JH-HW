package com.ssafy.urs.model.dto;

import java.util.Date;

public class Review {
	private int reviewId;
	private String userId;
	private int routeId;
	private Date regDate;
	private int rating;
	
	public Review() {}

	public Review(int reviewId, String userId, int routeId, Date regDate, int rate) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.routeId = routeId;
		this.regDate = regDate;
		this.rating = rate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRate() {
		return rating;
	}

	public void setRate(int rate) {
		this.rating = rate;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", userId=" + userId + ", routeId=" + routeId + ", regDate=" + regDate
				+ ", rate=" + rating + "]";
	};
	
	
}

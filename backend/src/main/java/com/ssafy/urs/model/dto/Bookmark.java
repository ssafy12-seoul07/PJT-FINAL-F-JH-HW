package com.ssafy.urs.model.dto;

public class Bookmark {
	private int bookmarkId;
	private String userId;
	private int routeId;

	
	public Bookmark() {};

	public Bookmark(int bookmarkId,String userId, int routeId) {
		super();
		this.bookmarkId=bookmarkId;
		this.userId = userId;
		this.routeId = routeId;
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

	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	@Override
	public String toString() {
		return "Bookmark [bookmarkId=" + bookmarkId + ", userId=" + userId + ", routeId=" + routeId + "]";
	}

	
	

	
	
		
}

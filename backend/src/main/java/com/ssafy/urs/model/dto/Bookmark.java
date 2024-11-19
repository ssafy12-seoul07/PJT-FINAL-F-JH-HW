package com.ssafy.urs.model.dto;

public class Bookmark {
	private String userId;
	private int routeId;
	private boolean isSPointVerified;
	private boolean isMPointVerified;
	private boolean isEPointVerified;
	private boolean isBookmarked;
	
	public Bookmark() {}

	public Bookmark(String userId, int routeId, boolean isSPointVerified, boolean isMPointVerified,
			boolean isEPointVerified, boolean isBookmarked) {
		super();
		this.userId = userId;
		this.routeId = routeId;
		this.isSPointVerified = isSPointVerified;
		this.isMPointVerified = isMPointVerified;
		this.isEPointVerified = isEPointVerified;
		this.isBookmarked = isBookmarked;
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

	public boolean isSPointVerified() {
		return isSPointVerified;
	}

	public void setSPointVerified(boolean isSPointVerified) {
		this.isSPointVerified = isSPointVerified;
	}

	public boolean isMPointVerified() {
		return isMPointVerified;
	}

	public void setMPointVerified(boolean isMPointVerified) {
		this.isMPointVerified = isMPointVerified;
	}

	public boolean isEPointVerified() {
		return isEPointVerified;
	}

	public void setEPointVerified(boolean isEPointVerified) {
		this.isEPointVerified = isEPointVerified;
	}

	public boolean isBookmarked() {
		return isBookmarked;
	}

	public void setBookmarked(boolean isBookmarked) {
		this.isBookmarked = isBookmarked;
	}

	@Override
	public String toString() {
		return "BookmarkCompletedRoute [userId=" + userId + ", routeId=" + routeId + ", isSPointVerified="
				+ isSPointVerified + ", isMPointVerified=" + isMPointVerified + ", isEPointVerified=" + isEPointVerified
				+ ", isBookmarked=" + isBookmarked + "]";
	};
	
	
	
	
		
}

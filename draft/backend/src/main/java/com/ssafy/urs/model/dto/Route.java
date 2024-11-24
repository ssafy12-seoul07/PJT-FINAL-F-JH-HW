package com.ssafy.urs.model.dto;

public class Route {
	private int routeId;
	private String district;
	private String theme;
	private int duration;
	private int calorie;
	private boolean isBookmarked;
	
	public Route() {};

	public Route(int routeId, String district, String theme, int duration, int calorie,
			boolean isBookmarked) {
		super();
		this.routeId = routeId;
		this.district = district;
		this.theme = theme;
		this.duration = duration;
		this.calorie=calorie;
		this.isBookmarked=isBookmarked;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public boolean isBookmarked() {
		return isBookmarked;
	}

	public void setBookmarked(boolean isBookmarked) {
		this.isBookmarked = isBookmarked;
	}

	
	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", district=" + district + ", theme=" + theme + ", duration=" + duration
				+ ", calorie=" + calorie + ", isBookmarked=" + isBookmarked + "]";
	}



	
}

	
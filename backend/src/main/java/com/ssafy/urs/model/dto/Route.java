package com.ssafy.urs.model.dto;

public class Route {
	private int routeId;
	private String district;
	private String theme;
	private int duration;
	private String routeAURL;
	private String routeBURL;
	
	public Route() {}

	public Route(int routeId, String district, String theme, int duration, String routeAURL,
			String routeBURL) {
		super();
		this.routeId = routeId;
		this.district = district;
		this.theme = theme;
		this.duration = duration;
		this.routeAURL = routeAURL;
		this.routeBURL = routeBURL;
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

	public void setThemeName(String theme) {
		this.theme = theme;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getRouteAURL() {
		return routeAURL;
	}

	public void setRouteAURL(String routeAURL) {
		this.routeAURL = routeAURL;
	}

	public String getRouteBURL() {
		return routeBURL;
	}

	public void setRouteBURL(String routeBURL) {
		this.routeBURL = routeBURL;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", district=" + district + ", theme=" + theme
				+ ", duration=" + duration + ", routeAURL=" + routeAURL + ", routeBURL=" + routeBURL + "]";
	}

	
}

	
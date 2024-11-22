package com.ssafy.urs.model.dto;

public class Location {
	private int routeId;
	private int locationId;
	private String locationName;
	private int ALatitude;
	private int ALongitude;
	private int centerLatitude;
	private int centerLongitude;
	private int BLatitude;
	private int BLongitude;
	private String imgURL;
	
	public Location() {}

	public Location(int routeId, int locationId, String locationName, int aLatitude, int aLongitude, int centerLatitude,
			int centerLongitude, int bLatitude, int bLongitude, String imgURL) {
		super();
		this.routeId = routeId;
		this.locationId = locationId;
		this.locationName = locationName;
		ALatitude = aLatitude;
		ALongitude = aLongitude;
		this.centerLatitude = centerLatitude;
		this.centerLongitude = centerLongitude;
		BLatitude = bLatitude;
		BLongitude = bLongitude;
		this.imgURL = imgURL;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getALatitude() {
		return ALatitude;
	}

	public void setALatitude(int aLatitude) {
		ALatitude = aLatitude;
	}

	public int getALongitude() {
		return ALongitude;
	}

	public void setALongitude(int aLongitude) {
		ALongitude = aLongitude;
	}

	public int getCenterLatitude() {
		return centerLatitude;
	}

	public void setCenterLatitude(int centerLatitude) {
		this.centerLatitude = centerLatitude;
	}

	public int getCenterLongitude() {
		return centerLongitude;
	}

	public void setCenterLongitude(int centerLongitude) {
		this.centerLongitude = centerLongitude;
	}

	public int getBLatitude() {
		return BLatitude;
	}

	public void setBLatitude(int bLatitude) {
		BLatitude = bLatitude;
	}

	public int getBLongitude() {
		return BLongitude;
	}

	public void setBLongitude(int bLongitude) {
		BLongitude = bLongitude;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	@Override
	public String toString() {
		return "Location [routeId=" + routeId + ", locationId=" + locationId + ", locationName=" + locationName
				+ ", ALatitude=" + ALatitude + ", ALongitude=" + ALongitude + ", centerLatitude=" + centerLatitude
				+ ", centerLongitude=" + centerLongitude + ", BLatitude=" + BLatitude + ", BLongitude=" + BLongitude
				+ ", imgURL=" + imgURL + "]";
	};
	
	
}

package com.ssafy.urs.model.dto;

public class Location {
	private int routeId;
	private int locationId;
	private String AName;
	private double ALatitude;
	private double ALongitude;
	private String CName;
	private double centerLatitude;
	private double centerLongitude;
	private String BName;
	private double BLatitude;
	private double BLongitude;
	private String imgURL;
	
	public Location() {}

	public Location(int routeId, int locationId, String aName, double aLatitude, double aLongitude, String cName,
			double centerLatitude, double centerLongitude, String bName, double bLatitude, double bLongitude,
			String imgURL) {
		super();
		this.routeId = routeId;
		this.locationId = locationId;
		this.AName = aName;
		this.ALatitude = aLatitude;
		this.ALongitude = aLongitude;
		this.CName = cName;
		this.centerLatitude = centerLatitude;
		this.centerLongitude = centerLongitude;
		this.BName = bName;
		this.BLatitude = bLatitude;
		this.BLongitude = bLongitude;
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

	public String getAName() {
		return AName;
	}

	public void setAName(String aName) {
		AName = aName;
	}

	public double getALatitude() {
		return ALatitude;
	}

	public void setALatitude(double aLatitude) {
		ALatitude = aLatitude;
	}

	public double getALongitude() {
		return ALongitude;
	}

	public void setALongitude(double aLongitude) {
		ALongitude = aLongitude;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public double getCenterLatitude() {
		return centerLatitude;
	}

	public void setCenterLatitude(double centerLatitude) {
		this.centerLatitude = centerLatitude;
	}

	public double getCenterLongitude() {
		return centerLongitude;
	}

	public void setCenterLongitude(double centerLongitude) {
		this.centerLongitude = centerLongitude;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public double getBLatitude() {
		return BLatitude;
	}

	public void setBLatitude(double bLatitude) {
		BLatitude = bLatitude;
	}

	public double getBLongitude() {
		return BLongitude;
	}

	public void setBLongitude(double bLongitude) {
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
		return "Location [routeId=" + routeId + ", locationId=" + locationId + ", AName=" + AName + ", ALatitude="
				+ ALatitude + ", ALongitude=" + ALongitude + ", CName=" + CName + ", centerLatitude=" + centerLatitude
				+ ", centerLongitude=" + centerLongitude + ", BName=" + BName + ", BLatitude=" + BLatitude
				+ ", BLongitude=" + BLongitude + ", imgURL=" + imgURL + "]";
	}
	
	
	
	

}

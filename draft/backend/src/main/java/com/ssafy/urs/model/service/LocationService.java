package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Location;

public interface LocationService {
	Location getLocationByRouteId(int routeId);
	List<Location> getAllLocation();
}

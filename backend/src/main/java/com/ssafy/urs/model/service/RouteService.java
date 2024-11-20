package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Route;

public interface RouteService {
	
	List<Route> getAllRoutes();
	
	List<Route> getExampleRoutes();

	Route getRouteById(int routeId);

	Route getRouteByParam(String theme, String district, int duration);
	
	

}

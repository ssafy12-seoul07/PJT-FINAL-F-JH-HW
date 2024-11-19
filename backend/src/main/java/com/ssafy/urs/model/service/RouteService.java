package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Route;

public interface RouteService {
	
	Route getRouteByParam(String theme, String district, int duration);
	
	List<Route> getAllRoutes();
	
	Route getRouteById(int routeId);
	
	List<Route> getExampleRoutes();

}

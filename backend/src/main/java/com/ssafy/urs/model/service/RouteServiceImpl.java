package com.ssafy.urs.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.urs.model.dao.RouteDao;
import com.ssafy.urs.model.dto.Route;

@Service
public class RouteServiceImpl implements RouteService{
	private final RouteDao rd;
	
	public RouteServiceImpl(RouteDao rd) {
		this.rd=rd;
	}

	@Override
	public Route getRouteByParam(String theme, String district, int duration) {
		return rd.selectRouteByAttributes(theme, district, duration);
	}
	
	@Override
	public List<Route> getAllRoutes() {
		return rd.selectAllRoutes();
	}

	@Override
	public Route getRouteById(int routeId) {
		 return rd.selectRouteById(routeId);
	}

	@Override
	public List<Route> getExampleRoutes() {
		return rd.selectExampleRoutes();
	};
	
	
	
}

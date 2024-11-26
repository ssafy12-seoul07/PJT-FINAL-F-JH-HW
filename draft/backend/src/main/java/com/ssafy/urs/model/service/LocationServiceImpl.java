package com.ssafy.urs.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.urs.model.dao.LocationDao;
import com.ssafy.urs.model.dto.Location;

@Service
public class LocationServiceImpl implements LocationService {
	private final LocationDao ld;
	
	public LocationServiceImpl(LocationDao ld) {
		this.ld=ld;
	}

	@Override
	public Location getLocationByRouteId(int routeId) {
		return ld.selectByRouteId(routeId);
	}

	@Override
	public List<Location> getAllLocation() {
		return ld.selectAllLocation();
	}

	
	
}

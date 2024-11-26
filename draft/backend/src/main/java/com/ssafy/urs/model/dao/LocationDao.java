package com.ssafy.urs.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.urs.model.dto.Location;

@Mapper
public interface LocationDao {
	Location selectByRouteId(int routeId);
	
	List<Location> selectAllLocation();
}

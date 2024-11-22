package com.ssafy.urs.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.urs.model.dto.Route;

@Mapper
public interface RouteDao {
	
	// 사용자 선택 값을 기준으로 경로찾기
	Route selectRouteByAttributes(String district,String theme, int duration);

	//예시 루트 3개
	List<Route> selectExampleRoutes();
		
	// if.. 경로 전체보기를 추가할거란 가정하에... 일단..
	List<Route> selectAllRoutes();
	
	// 경로 ID로 특정 경로 조회(이것도 사용자가 전체 경로해서 바로 시작한다는 가정하에)
    Route selectRouteById(int routeId);
	
    
	

}

package com.ssafy.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.urs.model.dto.Route;
import com.ssafy.urs.model.service.RouteService;

@RestController
@RequestMapping("/urs/route")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // 프론트엔드 도메인

public class RouteRestController {
	
	@Autowired
	RouteService rs;
	
	// 모든 경로 가져오기
	@GetMapping("/all")
	public ResponseEntity<List<Route>> showAll(){
		List<Route> list = rs.getAllRoutes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/best")
	public ResponseEntity<List<Route>> showBest(){
		List<Route> list = rs.getExampleRoutes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{routeId}")
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId") int routeId){
		Route route = rs.getRouteById(routeId);
		return new ResponseEntity<>(route, HttpStatus.OK);
	}

	@GetMapping("/{district}/{theme}/{duration}")
	public ResponseEntity<Integer> getRoutebyUser(
			@PathVariable String district,
			@PathVariable(value= "theme") String theme,
			@PathVariable(value = "duration") Integer duration){
		Route route = rs.getRouteByParam(district, theme, duration);
		return new ResponseEntity<Integer>(route.getRouteId(), HttpStatus.OK);
	}
	
	
}

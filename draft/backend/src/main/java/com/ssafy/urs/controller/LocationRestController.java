package com.ssafy.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.urs.model.dto.Location;
import com.ssafy.urs.model.service.LocationService;

@CrossOrigin(origins="http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/urs/location")
public class LocationRestController {

	@Autowired
	LocationService ls;
	
	@GetMapping("/{routeId}")
	public ResponseEntity<Location> getLocationById(@PathVariable("routeId") int routeId){
		Location location = ls.getLocationByRouteId(routeId);
		System.out.println(location.toString());
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Location>> showAll(){
		List<Location> list = ls.getAllLocation();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
}

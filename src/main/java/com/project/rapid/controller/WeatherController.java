package com.project.rapid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.project.rapid.Service.WeatherService;


@RestController
public class WeatherController {
@Autowired
WeatherService weatherService;

@GetMapping(value="/hourly/{country}")
public ResponseEntity<String> getHourlyData(@RequestHeader(name = "client-id") String clientId,
        @RequestHeader(name = "client-secret") String clientSecret,@PathVariable("country") String country) {

	if(null == clientId || clientId.isEmpty() || null == clientSecret || clientSecret.isEmpty()) {
		return new ResponseEntity<>("No proper headers provided",HttpStatus.BAD_REQUEST);
	}
	
	return weatherService.gethourlyData(country);
}

@GetMapping(value="/summary/{country}")
public ResponseEntity<String> getSummaryData(@RequestHeader(name = "client-id") String clientId,
        @RequestHeader(name = "client-secret") String clientSecret,@PathVariable("country") String country) {

	if(null == clientId || clientId.isEmpty() || null == clientSecret || clientSecret.isEmpty()) {
		return new ResponseEntity<>("No proper headers provided",HttpStatus.BAD_REQUEST);
	}
	
	return weatherService.getSummaryData(country);
}
}

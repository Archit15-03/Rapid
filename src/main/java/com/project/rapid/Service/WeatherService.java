package com.project.rapid.Service;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
	
	public ResponseEntity<String> gethourlyData(String country);

	public ResponseEntity<String> getSummaryData(String country);
}

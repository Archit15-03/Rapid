package com.project.rapid.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.rapid.Service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	RestTemplate restTemplate;
	
	public static Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	public static final String baseUrl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/";
	public static final String hourlyEndUrl = "/hourly/";
	public static final String summaryEndUrl = "/summary/";
	
	@Override
	public ResponseEntity<String> gethourlyData(String country) {
		
		if(null == country || country.isEmpty()) {
			return new ResponseEntity<>("Empty value received in country", HttpStatus.BAD_REQUEST);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", "e5e04c24c5mshe2eae5ed4561843p1a5b1ajsn37c919eeb1d9");
		headers.add("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		HttpEntity<String> htpEntity =  new HttpEntity<String>(headers);
		
		String url = baseUrl+country+hourlyEndUrl;
		log.info(url);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,htpEntity, String.class);
		
		log.info("response received",response.getBody());
		return response;
	}

	@Override
	public ResponseEntity<String> getSummaryData(String country) {
		
		if(null == country || country.isEmpty()) {
			return new ResponseEntity<>("Empty value received in country", HttpStatus.BAD_REQUEST);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", "e5e04c24c5mshe2eae5ed4561843p1a5b1ajsn37c919eeb1d9");
		headers.add("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		HttpEntity<String> htpEntity =  new HttpEntity<String>(headers);
		
		String url = baseUrl+country+summaryEndUrl;
		log.info(url);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,htpEntity, String.class);
		
		log.info("response received",response.getBody());
		return response;
	}

}

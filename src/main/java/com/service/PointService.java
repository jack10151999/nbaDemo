package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.util.RESTUtil;

import org.springframework.stereotype.Service;

@Service
public class PointService {
	
	@Autowired
	RESTUtil restUtil;
	
	private final String apiUrl = "https://stats.nba.com/stats/leagueLeaders";
	
    public Map<String, String> getAllData(Map<String,String> requestBody) {
    	// Map<String, String> requestBody = new HashMap<>();
        //requestBody.put("LeagueID", "00");
        //requestBody.put("PerMode", "PerGame");
        //requestBody.put("Scope", "S");
        //requestBody.put("Season", "2023-24");
        //requestBody.put("SeasonType", "Regular Season");
        //requestBody.put("StatCategory", "PTS");
        return restUtil.send(requestBody);
        
   }

}

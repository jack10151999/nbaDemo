package com.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RESTUtil {
	
	/*
	 *	LeagueID：联盟 ID，00 代表 NBA。
		PerMode：统计方式，PerGame 或 Totals。
		Scope：统计范围，S 为全部球员，R 为本赛季新秀，RS 为季后赛，A 为全明星。
		Season：赛季，例如 2020-21。
		SeasonType：赛季类型，例 Regular+Season。
		StatCategory：统计项目，PTS 代表得分。
	 */
	
	private final String apiUrl = "https://stats.nba.com/stats/leagueLeaders";
	
	public Map<String,String> send(Map<String, String> requestBody ){
		
		HttpHeaders headers = setHeader();
		
        Map<String, String> result = new HashMap<String,String>();
        // 定義請求參數
    
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        log.trace("url>>>{}",apiUrl);
        // 發送 POST 請求
        ResponseEntity<HashMap> response = restTemplate.postForEntity(apiUrl, requestEntity, HashMap.class);
        result = response.getBody();
        return result;
	}
	
	public HttpHeaders setHeader() {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.set("User-Agent", "Mozilla/5.0");
        return headers;
	}
	
}
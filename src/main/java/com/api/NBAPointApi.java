package com.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.component.MessageProducer;
import com.model.request.GetAllDataIn;
import com.pojo.CommentMsg;
import com.service.PointService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import com.util.CodeUtil;

@Api(tags = "NBA分數")
@RequestMapping("/api")
@RestController
@Slf4j
public class NBAPointApi {
	
	@Autowired
	PointService pointService;
	
    @Autowired
    private MessageProducer producer;
	
    @ApiOperation("取所有分數")
    @PostMapping("/GetPointALL")
    public String GetPointALL(@RequestBody GetAllDataIn in) {
		//Map<String,String> pointMap = pointService.getNbaStats();
        return "";
    }
    
    @ApiOperation("取所有資料")
    @PostMapping("/GetDataALL")
    public String GetDataALL(@RequestBody GetAllDataIn in) {
    	log.trace("GetDataALLIN");
    	Map<String,String> allData = new HashMap<String,String>();
    	try{
    		Map<String,String> params = new HashMap<String,String>();
    		params = CodeUtil.objectCovert(Map.class, in);
    		log.trace("GetDataALL>>{}",CodeUtil.toJson(params));
    		allData = pointService.getAllData(params);
    	}
    	catch(Exception e) {
    		log.error("GetDataALL>>>{}",e);
    	}
		return CodeUtil.toJson(allData);
        
    }
    
    


    @PostMapping("/comment")
    public void notifyNewComment(@RequestBody CommentMsg comment) {
    	log.info("notifyNewComment>>>{}",CodeUtil.toJson(comment));
        producer.sendNewCommentNotification(comment);
    }
    

}

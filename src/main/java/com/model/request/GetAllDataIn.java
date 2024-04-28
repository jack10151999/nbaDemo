package com.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("取得所有資料")
public class GetAllDataIn {
	
	private String LeagueID; //联盟 ID，00 代表 NBA。
	
	private String PerMode; //统计方式，PerGame 或 Totals
	
	private String Scope; //统计范围，S 为全部球员，R 为本赛季新秀，RS 为季后赛，A 为全明星。
	
	private String Season; //赛季，例如 2020-21。
	
	private String SeasonType; //赛季类型，例 Regular+Season。
	
	private String StatCategory; //统计项目，PTS 代表得分。
}

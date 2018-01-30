package com.jing.avril.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StatisticsService {
	
	/** 
	* @Title: queryElementGoods 
	* @Description: 获取号码及分级信息  
	* @return  List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryElementGoods();
	 
	/** 
	* @Title: queryGoodsKeyHelp 
	* @Description: 查询分级关系
	* @return  List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryGoodsKeyHelp();
	
	/** 
	* @Title: queryTradeDetailStatistics 
	* @Description: 根据属性统计交易元素信息
	* @param map
	* @return  List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryTradeDetailStatistics(Map<String, Object> map);
	
	
}

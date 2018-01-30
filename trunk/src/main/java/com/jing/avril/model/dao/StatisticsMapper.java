package com.jing.avril.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StatisticsMapper {

	/**
	 * @Title: queryElementOnColorAnima 
	 * @Description: 获取号码波色与生肖信息 
	 * @return List<Map<String,Object>> 返回类型 
	 * @throws
	 */
	List<Map<String, Object>> queryElementOnColorAnima();
	
	/** 
	* @Title: queryTradeDetailStatistics 
	* @Description: 根据属性统计交易元素信息
	* @param map
	* @return  List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryTradeDetailStatistics(@Param("tradeDetail") Map<String, Object> map);
}

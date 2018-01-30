package com.jing.avril.controller;

import java.util.HashMap;
import java.util.Map;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jing.avril.service.StatisticsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: DictionaryController
 * @Description: 公共统计查询HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="公共统计查询")
@RequestMapping(value="/statistics")
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	
	
	@ApiOperation(value = "查询号码分组详情", notes = "查询号码分组详情")
	@RequestMapping(value = "/goods/help", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryGoodsKeyHelp(HttpServletResponse response) throws Exception{	
		return statisticsService.queryGoodsKeyHelp();
	}
	
	@ApiOperation(value = "查询号码与波色、生肖对应详情", notes = "查询号码与波色、生肖对应详情")
	@RequestMapping(value = "/goods/elements", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryElementGoods(HttpServletResponse response) throws Exception{	
		return statisticsService.queryElementGoods();
	}
	
	@ApiOperation(value = "根据属性统计交易元素信息", notes = "根据属性统计交易元素信息")
	@RequestMapping(value = "/tradeDetail", method = RequestMethod.GET)
	public Object queryTradeDetailStatistics(HttpServletResponse response, String stageId, String persionId) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {				
		Map<String, Object> tradeDetail = new HashMap<String, Object>();
		if(stageId!=null && stageId.length()>0)tradeDetail.put("stageId", stageId);
		if(persionId!=null && persionId.length()>0)tradeDetail.put("persionId", persionId);
		return statisticsService.queryTradeDetailStatistics(tradeDetail );
	}
}

package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.TradeDetail;

/**
 * @ClassName: TradeDetail
 * @Description: 交易详细码号情况服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface TradeDetailService {

    /**
	 * @Title: addTradeDetail
	 * @Description:添加交易详细码号情况
	 * @param tradeDetail 实体
	 * @return Integer
	 */
	TradeDetail addTradeDetail(TradeDetail tradeDetail);
	
	/**
	 * @Title modifyTradeDetail
	 * @Description:修改交易详细码号情况
	 * @param tradeDetail 实体
	 * @return Integer
	 */
	Integer modifyTradeDetail(TradeDetail tradeDetail);
	
	/**
	 * @Title: dropTradeDetailByDetailId
	 * @Description:删除交易详细码号情况
	 * @param detailId 实体标识
	 * @return Integer
	 */
	Integer dropTradeDetailByDetailId(String detailId);
	
	/**
	 * @Title: queryTradeDetailByDetailId
	 * @Description:根据实体标识查询交易详细码号情况
	 * @param detailId 实体标识
	 * @return TradeDetail
	 */
	TradeDetail queryTradeDetailByDetailId(String detailId);
	 
	/**
	 * @Title: queryTradeDetailForPage
	 * @Description: 根据交易详细码号情况属性与分页信息分页查询交易详细码号情况信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param tradeDetail 实体
	 * @return List<TradeDetail>
	 */
	Map<String, Object> queryTradeDetailForPage(Integer pagenum, Integer pagesize, String sort, TradeDetail tradeDetail);
	 
	 /**
	 * @Title: queryTradeDetailByProperty
	 * @Description:根据属性查询交易详细码号情况
	 * @return List<TradeDetail>
	 */
	 List<TradeDetail> queryTradeDetailByProperty(Map<String, Object> map);	 
	 
}

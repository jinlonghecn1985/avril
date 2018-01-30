package com.jing.avril.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jing.avril.model.entity.Trade;

/**
 * @ClassName: Trade
 * @Description: 交易总情况服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface TradeService {

    /**
	 * @Title: addTrade
	 * @Description:添加交易总情况
	 * @param trade 实体
	 * @return Integer
	 */
	Trade addTrade(Trade trade);
	
	/**
	 * @Title modifyTrade
	 * @Description:修改交易总情况
	 * @param trade 实体
	 * @return Integer
	 */
	Integer modifyTrade(Trade trade);
	
	/**
	 * @Title: dropTradeByTradeId
	 * @Description:删除交易总情况
	 * @param tradeId 实体标识
	 * @return Integer
	 */
	Integer dropTradeByTradeId(String tradeId);
	
	/**
	 * @Title: queryTradeByTradeId
	 * @Description:根据实体标识查询交易总情况
	 * @param tradeId 实体标识
	 * @return Trade
	 */
	Trade queryTradeByTradeId(String tradeId);
	 
	/**
	 * @Title: queryTradeForPage
	 * @Description: 根据交易总情况属性与分页信息分页查询交易总情况信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param trade 实体
	 * @return List<Trade>
	 */
	Map<String, Object> queryTradeForPage(Integer pagenum, Integer pagesize, String sort, Trade trade);
	 
	 /**
	 * @Title: queryTradeByProperty
	 * @Description:根据属性查询交易总情况
	 * @return List<Trade>
	 */
	 List<Trade> queryTradeByProperty(Map<String, Object> map);	 
	 
	 
	/** 
	* @Title: queryPersionTotalFeeBackOnStageID 
	* @Description: 查询下家期别消费与返水数据 
	* @param tradeId
	* @param persionID
	* @return  Map<String,Object>    返回类型 
	* @throws 
	*/
	Map<String, Object> queryPersionTotalFeeBackOnStageID(String tradeId, String persionID);
	

	 /** 
	* @Title: queryBonusTradeByElement 
	* @Description: 获取中奖交易信息
	* @param element
	* @param stageId
	* @param persionId
	* @return  List<Trade>    返回类型 
	* @throws 
	*/
	List<Trade> queryBonusTradeByElement(Integer element, String stageId,  String persionId);
	 
}

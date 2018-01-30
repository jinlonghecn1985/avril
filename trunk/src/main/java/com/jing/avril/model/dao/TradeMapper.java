package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.Trade;

/**
 * @ClassName: TradeMapper
 * @Description: 交易总情况映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface TradeMapper {

	/**
	 * @Title: addTrade
	 * @Description:添加交易总情况
	 * @param trade 实体
	 * @return Integer
	 */
	Integer addTrade(Trade trade);
	
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
	 * @param pageBounds 分页信息
	 * @param trade 实体
	 * @return List<Trade>
	 */
	List<Trade> queryTradeForPage(PageBounds pageBounds, @Param("trade") Trade trade);
	 
	 /**
	  * @Title: queryTradeByProperty
	  * @Description:根据属性查询交易总情况
	  * @return List<Trade>
	  */
	 List<Trade> queryTradeByProperty(@Param("trade") Map<String, Object> map);
	 
	 /** 
	* @Title: queryBonusTradeByElement 
	* @Description: 获取中奖交易信息
	* @param element
	* @param stageId
	* @param persionId
	* @return  List<Trade>    返回类型 
	* @throws 
	*/
	List<Trade> queryBonusTradeByElement(
			@Param("element") Integer element, 
			@Param("stageId") String stageId, 
			@Param("persionId") String persionId);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 /**
	 * @Title: clearDataOnStageId
	 * @Description: 清空某期全部信息
	 * @param stageId 分页信息
	 * @return 
	 */
	 Integer clearDataOnStageId(String stageId);
	 
	 /** 
	* @Title: queryPersionTotalFeeBackOnStageID 
	* @Description: 查询下家期别消费与返水数据 
	* @param tradeId
	* @param persionID
	* @return  Map<String,Object>    返回类型 
	* @throws 
	*/
	Map<String, Object> queryPersionTotalFeeBackOnStageID(@Param("stageId") String stageId, @Param("persionId") String persionID);

	/** 
	* @Title: resetBonusZore 
	* @Description: 奖金重置为0
	* @param stageId
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer resetBonusZore(String stageId);
	 
}

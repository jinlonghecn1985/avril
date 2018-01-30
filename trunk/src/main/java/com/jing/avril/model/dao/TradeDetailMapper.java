package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.TradeDetail;

/**
 * @ClassName: TradeDetailMapper
 * @Description: 交易详细码号情况映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface TradeDetailMapper {

	/**
	 * @Title: addTradeDetail
	 * @Description:添加交易详细码号情况
	 * @param tradeDetail 实体
	 * @return Integer
	 */
	Integer addTradeDetail(TradeDetail tradeDetail);
	
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
	 * @param pageBounds 分页信息
	 * @param tradeDetail 实体
	 * @return List<TradeDetail>
	 */
	List<TradeDetail> queryTradeDetailForPage(PageBounds pageBounds, @Param("tradeDetail") TradeDetail tradeDetail);
	 
	 /**
	  * @Title: queryTradeDetailByProperty
	  * @Description:根据属性查询交易详细码号情况
	  * @return List<TradeDetail>
	  */
	 List<TradeDetail> queryTradeDetailByProperty(@Param("tradeDetail") Map<String, Object> map);
	 
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
	 
	 
	 
}

package com.jing.avril.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.avril.model.dao.GoodsMapper;
import com.jing.avril.model.dao.TradeMapper;
import com.jing.avril.model.entity.Trade;
import com.jing.avril.service.OperationService;
import com.jing.avril.service.PersionDetailService;
import com.jing.avril.service.TradeService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Trade
 * @Description: 交易总情况服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("tradeService")
@Transactional(readOnly=true)
public class  TradeServiceImpl implements TradeService {

	@Autowired
    private TradeMapper tradeMapper;   
	
	@Autowired 
	private GoodsMapper goodsMapper;
	
	@Autowired
	private PersionDetailService persionDetailService;
	
	@Autowired 
	private OperationService operationService;
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTrade
	 * @Description:添加交易总情况
	 * @param trade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Trade addTrade(Trade trade){
		if(null == trade.getTradeId()){			
         	trade.setTradeId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = tradeMapper.addTrade(trade);		
		if(ret>0){
			persionDetailService.bindPersionDetailOnStagePersion(trade.getStageId(), trade.getPersionId()); //更新数据
			return trade;
		}
		return null;
	}
	
	/**
	 * @Title modifyTrade
	 * @Description:修改交易总情况
	 * @param trade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTrade(Trade trade){
		Integer ret = tradeMapper.modifyTrade(trade);
		Trade trade2 = this.queryTradeByTradeId(trade.getTradeId());
		persionDetailService.bindPersionDetailOnStagePersion(trade2.getStageId(), trade2.getPersionId()); //更新数据
		if(trade.getStatus()!=null){
			operationService.calculationStage(trade.getStageId()); //计算
		}
		return ret;
	}
	
	/**
	 * @Title: dropTradeByTradeId
	 * @Description:删除交易总情况
	 * @param tradeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTradeByTradeId(String tradeId){
		Trade trade2 = this.queryTradeByTradeId(tradeId);
		Integer ret = tradeMapper.dropTradeByTradeId(tradeId);
		persionDetailService.bindPersionDetailOnStagePersion(trade2.getStageId(), trade2.getPersionId()); //更新数据
		return ret;
	}
	
	/**
	 * @Title: queryTradeByTradeId
	 * @Description:根据实体标识查询交易总情况
	 * @param tradeId 实体标识
	 * @return Trade
	 */
	@Override
	public Trade queryTradeByTradeId(String tradeId){
		return tradeMapper.queryTradeByTradeId(tradeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTradeForPage
	 * @Description: 根据交易总情况属性与分页信息分页查询交易总情况信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param trade 实体
	 * @return List<Trade>
	 */
	@Override
	public Map<String, Object> queryTradeForPage(Integer pagenum, Integer pagesize, String sort, Trade trade){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Trade.class);
		List<Trade> entityList = tradeMapper.queryTradeForPage(pageBounds, trade);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Trade.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Trade> pagelist = (PageList<Trade>) entityList;
			for(Trade tr : entityList){
				tr.setGoodsName(goodsMapper.queryGoodsByGoodsId(tr.getGoodsId()).getGoodsName());
			}
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTradeByProperty
	 * @Description:根据属性查询交易总情况
	 * @return List<Trade>
	 */
	@Override
	public List<Trade> queryTradeByProperty(Map<String, Object> map){
		return tradeMapper.queryTradeByProperty(map);
	}

	@Override
	public Map<String, Object> queryPersionTotalFeeBackOnStageID(String tradeId, String persionID) {
		return tradeMapper.queryPersionTotalFeeBackOnStageID(tradeId, persionID);
	}

	@Override
	public List<Trade> queryBonusTradeByElement(Integer element, String stageId, String persionId) {
		return tradeMapper.queryBonusTradeByElement(element, stageId, persionId);
	}


}

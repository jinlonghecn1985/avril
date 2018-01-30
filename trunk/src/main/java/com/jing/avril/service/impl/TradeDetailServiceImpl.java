package com.jing.avril.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;
import java.util.UUID;

import com.jing.avril.model.entity.TradeDetail;
import com.jing.avril.model.dao.TradeDetailMapper;
import com.jing.avril.service.TradeDetailService;

/**
 * @ClassName: TradeDetail
 * @Description: 交易详细码号情况服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("tradeDetailService")
@Transactional(readOnly=true)
public class  TradeDetailServiceImpl implements TradeDetailService {

	@Autowired
    private TradeDetailMapper tradeDetailMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTradeDetail
	 * @Description:添加交易详细码号情况
	 * @param tradeDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TradeDetail addTradeDetail(TradeDetail tradeDetail){
		if(null == tradeDetail.getDetailId()){			
         	tradeDetail.setDetailId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = tradeDetailMapper.addTradeDetail(tradeDetail);
		if(ret>0){
			return tradeDetail;
		}
		return null;
	}
	
	/**
	 * @Title modifyTradeDetail
	 * @Description:修改交易详细码号情况
	 * @param tradeDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTradeDetail(TradeDetail tradeDetail){
		return tradeDetailMapper.modifyTradeDetail(tradeDetail);
	}
	
	/**
	 * @Title: dropTradeDetailByDetailId
	 * @Description:删除交易详细码号情况
	 * @param detailId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTradeDetailByDetailId(String detailId){
		return tradeDetailMapper.dropTradeDetailByDetailId(detailId);
	}
	
	/**
	 * @Title: queryTradeDetailByDetailId
	 * @Description:根据实体标识查询交易详细码号情况
	 * @param detailId 实体标识
	 * @return TradeDetail
	 */
	@Override
	public TradeDetail queryTradeDetailByDetailId(String detailId){
		return tradeDetailMapper.queryTradeDetailByDetailId(detailId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTradeDetailForPage
	 * @Description: 根据交易详细码号情况属性与分页信息分页查询交易详细码号情况信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param tradeDetail 实体
	 * @return List<TradeDetail>
	 */
	@Override
	public Map<String, Object> queryTradeDetailForPage(Integer pagenum, Integer pagesize, String sort, TradeDetail tradeDetail){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TradeDetail.class);
		List<TradeDetail> entityList = tradeDetailMapper.queryTradeDetailForPage(pageBounds, tradeDetail);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TradeDetail.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TradeDetail> pagelist = (PageList<TradeDetail>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTradeDetailByProperty
	 * @Description:根据属性查询交易详细码号情况
	 * @return List<TradeDetail>
	 */
	@Override
	public List<TradeDetail> queryTradeDetailByProperty(Map<String, Object> map){
		return tradeDetailMapper.queryTradeDetailByProperty(map);
	}


}

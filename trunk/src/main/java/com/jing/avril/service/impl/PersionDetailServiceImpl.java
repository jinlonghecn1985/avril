package com.jing.avril.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.avril.model.dao.PersionDetailMapper;
import com.jing.avril.model.dao.PersionMapper;
import com.jing.avril.model.dao.TradeMapper;
import com.jing.avril.model.entity.Persion;
import com.jing.avril.model.entity.PersionDetail;
import com.jing.avril.service.PersionDetailService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: PersionDetail
 * @Description: 期别下家交易数据服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("persionDetailService")
@Transactional(readOnly=true)
public class  PersionDetailServiceImpl implements PersionDetailService {

	@Autowired
    private PersionDetailMapper persionDetailMapper;
	
	@Autowired
    private PersionMapper persionMapper;
	
	@Autowired
    private TradeMapper tradeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addPersionDetail
	 * @Description:添加期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public PersionDetail addPersionDetail(PersionDetail persionDetail){
		if(null == persionDetail.getSpId()){			
         	persionDetail.setSpId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = persionDetailMapper.addPersionDetail(persionDetail);
		if(ret>0){
			return persionDetail;
		}
		return null;
	}
	
	/**
	 * @Title modifyPersionDetail
	 * @Description:修改期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyPersionDetail(PersionDetail persionDetail){
		return persionDetailMapper.modifyPersionDetail(persionDetail);
	}
	
	/**
	 * @Title: dropPersionDetailBySpId
	 * @Description:删除期别下家交易数据
	 * @param spId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropPersionDetailBySpId(String spId){
		return persionDetailMapper.dropPersionDetailBySpId(spId);
	}
	
	/**
	 * @Title: queryPersionDetailBySpId
	 * @Description:根据实体标识查询期别下家交易数据
	 * @param spId 实体标识
	 * @return PersionDetail
	 */
	@Override
	public PersionDetail queryPersionDetailBySpId(String spId){
		return persionDetailMapper.queryPersionDetailBySpId(spId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryPersionDetailForPage
	 * @Description: 根据期别下家交易数据属性与分页信息分页查询期别下家交易数据信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param persionDetail 实体
	 * @return List<PersionDetail>
	 */
	@Override
	public Map<String, Object> queryPersionDetailForPage(Integer pagenum, Integer pagesize, String sort, PersionDetail persionDetail){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, PersionDetail.class);
		List<PersionDetail> entityList = persionDetailMapper.queryPersionDetailForPage(pageBounds, persionDetail);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, PersionDetail.class);
		}
		if (!entityList.isEmpty()) {
			for(PersionDetail pd : entityList){
				Persion p = persionMapper.queryPersionByPersionId(pd.getPersionId());
				pd.setPersionName(p.getPersionName());
				pd.setPersionKey(p.getPersionKey());
			}
			PageList<PersionDetail> pagelist = (PageList<PersionDetail>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryPersionDetailByProperty
	 * @Description:根据属性查询期别下家交易数据
	 * @return List<PersionDetail>
	 */
	@Override
	public List<PersionDetail> queryPersionDetailByProperty(Map<String, Object> map){
		return persionDetailMapper.queryPersionDetailByProperty(map);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer bindPersionDetailOnStagePersion(String stageId, String persionId) {
		Map<String, Object> map = tradeMapper.queryPersionTotalFeeBackOnStageID(stageId, persionId);
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("stageId", stageId);
		query.put("persionId", persionId);
		List<PersionDetail> plist = queryPersionDetailByProperty(query);
		if(plist==null || plist.size()==0){
			PersionDetail pd = new PersionDetail();			
			pd.setPersionId(persionId);
			pd.setStageId(stageId);
			pd.setBackMoney(((BigDecimal)map.get("back")).longValue());
			pd.setTotalMoney(((BigDecimal)map.get("fee")).longValue());
			addPersionDetail(pd);			
		}else{
			PersionDetail pd = plist.get(0);
			pd.setBackMoney(((BigDecimal)map.get("back")).longValue());
			pd.setTotalMoney(((BigDecimal)map.get("fee")).longValue());
			pd.setGmtModify(null);
			pd.setGmtCreated(null);
			modifyPersionDetail(pd);
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public Integer modifyPersionDetailByStagePerion(PersionDetail persionDetail) {
		if(persionDetail.getStageId()==null || persionDetail.getPersionId()==null){
			if(persionDetail.getSpId()!=null){
				return modifyPersionDetail(persionDetail);
			}
			return 0;
		}
		return persionDetailMapper.modifyPersionDetailByStagePerion(persionDetail);
	}


}

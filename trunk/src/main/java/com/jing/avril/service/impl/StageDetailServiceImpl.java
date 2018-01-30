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

import com.jing.avril.model.entity.StageDetail;
import com.jing.avril.model.dao.StageDetailMapper;
import com.jing.avril.service.OperationService;
import com.jing.avril.service.StageDetailService;

/**
 * @ClassName: StageDetail
 * @Description: 期号交易数据服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("stageDetailService")
@Transactional(readOnly=true)
public class  StageDetailServiceImpl implements StageDetailService {

	@Autowired
    private StageDetailMapper stageDetailMapper;   
	
	@Autowired 
	private OperationService operationService;
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addStageDetail
	 * @Description:添加期号交易数据
	 * @param stageDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public StageDetail addStageDetail(StageDetail stageDetail){
		if(null == stageDetail.getBillId()){			
         	stageDetail.setBillId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = stageDetailMapper.addStageDetail(stageDetail);
		if(ret>0){
			return stageDetail;
		}
		return null;
	}
	
	/**
	 * @Title modifyStageDetail
	 * @Description:修改期号交易数据
	 * @param stageDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyStageDetail(StageDetail stageDetail){		
		Integer ret = stageDetailMapper.modifyStageDetail(stageDetail);
		operationService.calculationStage(stageDetail.getStageId());
		return ret;
	}
	
	/**
	 * @Title: dropStageDetailByBillId
	 * @Description:删除期号交易数据
	 * @param billId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropStageDetailByBillId(String billId){
		return stageDetailMapper.dropStageDetailByBillId(billId);
	}
	
	/**
	 * @Title: queryStageDetailByBillId
	 * @Description:根据实体标识查询期号交易数据
	 * @param billId 实体标识
	 * @return StageDetail
	 */
	@Override
	public StageDetail queryStageDetailByBillId(String billId){
		return stageDetailMapper.queryStageDetailByBillId(billId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryStageDetailForPage
	 * @Description: 根据期号交易数据属性与分页信息分页查询期号交易数据信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param stageDetail 实体
	 * @return List<StageDetail>
	 */
	@Override
	public Map<String, Object> queryStageDetailForPage(Integer pagenum, Integer pagesize, String sort, StageDetail stageDetail){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, StageDetail.class);
		List<StageDetail> entityList = stageDetailMapper.queryStageDetailForPage(pageBounds, stageDetail);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, StageDetail.class);
		}
		if (!entityList.isEmpty()) {
			PageList<StageDetail> pagelist = (PageList<StageDetail>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryStageDetailByProperty
	 * @Description:根据属性查询期号交易数据
	 * @return List<StageDetail>
	 */
	@Override
	public List<StageDetail> queryStageDetailByProperty(Map<String, Object> map){
		return stageDetailMapper.queryStageDetailByProperty(map);
	}


}

package com.jing.avril.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.avril.model.dao.PersionDetailMapper;
import com.jing.avril.model.dao.StageDetailMapper;
import com.jing.avril.model.dao.StageMapper;
import com.jing.avril.model.dao.TradeDetailMapper;
import com.jing.avril.model.dao.TradeMapper;
import com.jing.avril.model.entity.Stage;
import com.jing.avril.model.entity.StageDetail;
import com.jing.avril.service.OperationService;
import com.jing.avril.service.StageDetailService;
import com.jing.avril.service.StageService;
import com.jing.avril.util.AvrilUtil;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Stage
 * @Description: 期号信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("stageService")
@Transactional(readOnly=true)
public class  StageServiceImpl implements StageService {

	@Autowired
    private StageMapper stageMapper;   
	
	@Autowired
	private AvrilUtil avrilUtil;
	
	@Autowired
	private StageDetailService stageDetailService;
	
	@Autowired
	private StageDetailMapper stageDetailMapper;
	
	@Autowired
	private TradeMapper tradeMapper;
	
	@Autowired
	private TradeDetailMapper tradeDetailMapper;
	
	@Autowired
	private PersionDetailMapper persionDetailMapper;
	
	@Autowired
	private OperationService operationService;
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addStage
	 * @Description:添加期号信息
	 * @param stage 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Stage addStage(Stage stage){
		if(null == stage.getStageId()){			
         	stage.setStageId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}		
		int ret = stageMapper.addStage(stage);
		if(ret>0){
			Integer maxNum = avrilUtil.maxNum;
			for(int i=0; i<maxNum; i++){
				StageDetail stageDetail = new StageDetail();
				stageDetail.setStageId(stage.getStageId());
				stageDetail.setElement(i+1);
				stageDetail.setUpbill(0l);
				stageDetailService.addStageDetail(stageDetail);
			}
			return stage;
		}
		
		return null;
	}
	
	/**
	 * @Title modifyStage
	 * @Description:修改期号信息
	 * @param stage 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyStage(Stage stage){
		Integer ret = stageMapper.modifyStage(stage);
		//TODO 修订风险金业务
		if(stage.getStageRisk()!=null){
			//重新计算
			operationService.calculationStage(stage.getStageId());
		}
		//TODO 修订特号业务
		if(stage.getElement()!=null){
			//makeStageData(stage.getStageId()); //计算
		}
		return ret;
	}
	
	/**
	 * @Title: dropStageByStageId
	 * @Description:删除期号信息
	 * @param stageId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropStageByStageId(String stageId){
		tradeDetailMapper.clearDataOnStageId(stageId);
		tradeMapper.clearDataOnStageId(stageId);
		persionDetailMapper.clearDataOnStageId(stageId);
		stageDetailMapper.clearDataOnStageId(stageId);
			
		return  stageMapper.dropStageByStageId(stageId);
	}
	
	/**
	 * @Title: queryStageByStageId
	 * @Description:根据实体标识查询期号信息
	 * @param stageId 实体标识
	 * @return Stage
	 */
	@Override
	public Stage queryStageByStageId(String stageId){
		return stageMapper.queryStageByStageId(stageId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryStageForPage
	 * @Description: 根据期号信息属性与分页信息分页查询期号信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param stage 实体
	 * @return List<Stage>
	 */
	@Override
	public Map<String, Object> queryStageForPage(Integer pagenum, Integer pagesize, String sort, Stage stage){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Stage.class);
		List<Stage> entityList = stageMapper.queryStageForPage(pageBounds, stage);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Stage.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Stage> pagelist = (PageList<Stage>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryStageByProperty
	 * @Description:根据属性查询期号信息
	 * @return List<Stage>
	 */
	@Override
	public List<Stage> queryStageByProperty(Map<String, Object> map){
		return stageMapper.queryStageByProperty(map);
	}
	
	


}

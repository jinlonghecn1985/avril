package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.StageDetail;

/**
 * @ClassName: StageDetail
 * @Description: 期号交易数据服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface StageDetailService {

    /**
	 * @Title: addStageDetail
	 * @Description:添加期号交易数据
	 * @param stageDetail 实体
	 * @return Integer
	 */
	StageDetail addStageDetail(StageDetail stageDetail);
	
	/**
	 * @Title modifyStageDetail
	 * @Description:修改期号交易数据
	 * @param stageDetail 实体
	 * @return Integer
	 */
	Integer modifyStageDetail(StageDetail stageDetail);
	
	/**
	 * @Title: dropStageDetailByBillId
	 * @Description:删除期号交易数据
	 * @param billId 实体标识
	 * @return Integer
	 */
	Integer dropStageDetailByBillId(String billId);
	
	/**
	 * @Title: queryStageDetailByBillId
	 * @Description:根据实体标识查询期号交易数据
	 * @param billId 实体标识
	 * @return StageDetail
	 */
	StageDetail queryStageDetailByBillId(String billId);
	 
	/**
	 * @Title: queryStageDetailForPage
	 * @Description: 根据期号交易数据属性与分页信息分页查询期号交易数据信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param stageDetail 实体
	 * @return List<StageDetail>
	 */
	Map<String, Object> queryStageDetailForPage(Integer pagenum, Integer pagesize, String sort, StageDetail stageDetail);
	 
	 /**
	 * @Title: queryStageDetailByProperty
	 * @Description:根据属性查询期号交易数据
	 * @return List<StageDetail>
	 */
	 List<StageDetail> queryStageDetailByProperty(Map<String, Object> map);	 
	 
}

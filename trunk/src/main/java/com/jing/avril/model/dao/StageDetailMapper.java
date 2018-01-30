package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.StageDetail;

/**
 * @ClassName: StageDetailMapper
 * @Description: 期号交易数据映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface StageDetailMapper {

	/**
	 * @Title: addStageDetail
	 * @Description:添加期号交易数据
	 * @param stageDetail 实体
	 * @return Integer
	 */
	Integer addStageDetail(StageDetail stageDetail);
	
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
	 * @param pageBounds 分页信息
	 * @param stageDetail 实体
	 * @return List<StageDetail>
	 */
	List<StageDetail> queryStageDetailForPage(PageBounds pageBounds, @Param("stageDetail") StageDetail stageDetail);
	 
	 /**
	  * @Title: queryStageDetailByProperty
	  * @Description:根据属性查询期号交易数据
	  * @return List<StageDetail>
	  */
	 List<StageDetail> queryStageDetailByProperty(@Param("stageDetail") Map<String, Object> map);
	 
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

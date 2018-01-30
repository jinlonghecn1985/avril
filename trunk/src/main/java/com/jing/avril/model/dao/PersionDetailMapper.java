package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.PersionDetail;

/**
 * @ClassName: PersionDetailMapper
 * @Description: 期别下家交易数据映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface PersionDetailMapper {

	/**
	 * @Title: addPersionDetail
	 * @Description:添加期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	Integer addPersionDetail(PersionDetail persionDetail);
	
	/**
	 * @Title modifyPersionDetail
	 * @Description:修改期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	Integer modifyPersionDetail(PersionDetail persionDetail);
	
	Integer modifyPersionDetailByStagePerion(PersionDetail persionDetail);
	
	/**
	 * @Title: dropPersionDetailBySpId
	 * @Description:删除期别下家交易数据
	 * @param spId 实体标识
	 * @return Integer
	 */
	Integer dropPersionDetailBySpId(String spId);
	
	/**
	 * @Title: queryPersionDetailBySpId
	 * @Description:根据实体标识查询期别下家交易数据
	 * @param spId 实体标识
	 * @return PersionDetail
	 */
	PersionDetail queryPersionDetailBySpId(String spId);
	 
	/**
	 * @Title: queryPersionDetailForPage
	 * @Description: 根据期别下家交易数据属性与分页信息分页查询期别下家交易数据信息
	 * @param pageBounds 分页信息
	 * @param persionDetail 实体
	 * @return List<PersionDetail>
	 */
	List<PersionDetail> queryPersionDetailForPage(PageBounds pageBounds, @Param("persionDetail") PersionDetail persionDetail);
	 
	 /**
	  * @Title: queryPersionDetailByProperty
	  * @Description:根据属性查询期别下家交易数据
	  * @return List<PersionDetail>
	  */
	 List<PersionDetail> queryPersionDetailByProperty(@Param("persionDetail") Map<String, Object> map);
	 
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

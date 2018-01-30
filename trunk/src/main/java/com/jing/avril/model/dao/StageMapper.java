package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.Stage;

/**
 * @ClassName: StageMapper
 * @Description: 期号信息映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface StageMapper {

	/**
	 * @Title: addStage
	 * @Description:添加期号信息
	 * @param stage 实体
	 * @return Integer
	 */
	Integer addStage(Stage stage);
	
	/**
	 * @Title modifyStage
	 * @Description:修改期号信息
	 * @param stage 实体
	 * @return Integer
	 */
	Integer modifyStage(Stage stage);
	
	/**
	 * @Title: dropStageByStageId
	 * @Description:删除期号信息
	 * @param stageId 实体标识
	 * @return Integer
	 */
	Integer dropStageByStageId(String stageId);
	
	/**
	 * @Title: queryStageByStageId
	 * @Description:根据实体标识查询期号信息
	 * @param stageId 实体标识
	 * @return Stage
	 */
	Stage queryStageByStageId(String stageId);
	 
	/**
	 * @Title: queryStageForPage
	 * @Description: 根据期号信息属性与分页信息分页查询期号信息信息
	 * @param pageBounds 分页信息
	 * @param stage 实体
	 * @return List<Stage>
	 */
	List<Stage> queryStageForPage(PageBounds pageBounds, @Param("stage") Stage stage);
	 
	 /**
	  * @Title: queryStageByProperty
	  * @Description:根据属性查询期号信息
	  * @return List<Stage>
	  */
	 List<Stage> queryStageByProperty(@Param("stage") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 	 
}

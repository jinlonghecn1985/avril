package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.Stage;

/**
 * @ClassName: Stage
 * @Description: 期号信息服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface StageService {

    /**
	 * @Title: addStage
	 * @Description:添加期号信息
	 * @param stage 实体
	 * @return Integer
	 */
	Stage addStage(Stage stage);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param stage 实体
	 * @return List<Stage>
	 */
	Map<String, Object> queryStageForPage(Integer pagenum, Integer pagesize, String sort, Stage stage);
	 
	 /**
	 * @Title: queryStageByProperty
	 * @Description:根据属性查询期号信息
	 * @return List<Stage>
	 */
	 List<Stage> queryStageByProperty(Map<String, Object> map);	 
	 
	
	 
}

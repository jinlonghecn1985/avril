package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.Persion;

/**
 * @ClassName: Persion
 * @Description: 下家信息服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface PersionService {

    /**
	 * @Title: addPersion
	 * @Description:添加下家信息
	 * @param persion 实体
	 * @return Integer
	 */
	Persion addPersion(Persion persion);
	
	/**
	 * @Title modifyPersion
	 * @Description:修改下家信息
	 * @param persion 实体
	 * @return Integer
	 */
	Integer modifyPersion(Persion persion);
	
	/**
	 * @Title: dropPersionByPersionId
	 * @Description:删除下家信息
	 * @param persionId 实体标识
	 * @return Integer
	 */
	Integer dropPersionByPersionId(String persionId);
	
	/**
	 * @Title: queryPersionByPersionId
	 * @Description:根据实体标识查询下家信息
	 * @param persionId 实体标识
	 * @return Persion
	 */
	Persion queryPersionByPersionId(String persionId);
	 
	/**
	 * @Title: queryPersionForPage
	 * @Description: 根据下家信息属性与分页信息分页查询下家信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param persion 实体
	 * @return List<Persion>
	 */
	Map<String, Object> queryPersionForPage(Integer pagenum, Integer pagesize, String sort, Persion persion);
	 
	 /**
	 * @Title: queryPersionByProperty
	 * @Description:根据属性查询下家信息
	 * @return List<Persion>
	 */
	 List<Persion> queryPersionByProperty(Map<String, Object> map);	 
	 
	 
}

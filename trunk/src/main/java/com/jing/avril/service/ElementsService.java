package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.Elements;

/**
 * @ClassName: Elements
 * @Description: 码号信息服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface ElementsService {

    /**
	 * @Title: addElements
	 * @Description:添加码号信息
	 * @param elements 实体
	 * @return Integer
	 */
	Elements addElements(Elements elements);
	
	/**
	 * @Title modifyElements
	 * @Description:修改码号信息
	 * @param elements 实体
	 * @return Integer
	 */
	Integer modifyElements(Elements elements);
	
	/**
	 * @Title: dropElementsByElement
	 * @Description:删除码号信息
	 * @param element 实体标识
	 * @return Integer
	 */
	Integer dropElementsByElement(Integer element);
	
	/**
	 * @Title: queryElementsByElement
	 * @Description:根据实体标识查询码号信息
	 * @param element 实体标识
	 * @return Elements
	 */
	Elements queryElementsByElement(Integer element);
	 
	/**
	 * @Title: queryElementsForPage
	 * @Description: 根据码号信息属性与分页信息分页查询码号信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param elements 实体
	 * @return List<Elements>
	 */
	Map<String, Object> queryElementsForPage(Integer pagenum, Integer pagesize, String sort, Elements elements);
	 
	 /**
	 * @Title: queryElementsByProperty
	 * @Description:根据属性查询码号信息
	 * @return List<Elements>
	 */
	 List<Elements> queryElementsByProperty(Map<String, Object> map);	 
	 
}

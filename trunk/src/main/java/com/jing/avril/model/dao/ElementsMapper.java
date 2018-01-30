package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.Elements;

/**
 * @ClassName: ElementsMapper
 * @Description: 码号信息映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface ElementsMapper {

	/**
	 * @Title: addElements
	 * @Description:添加码号信息
	 * @param elements 实体
	 * @return Integer
	 */
	Integer addElements(Elements elements);
	
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
	 * @param pageBounds 分页信息
	 * @param elements 实体
	 * @return List<Elements>
	 */
	List<Elements> queryElementsForPage(PageBounds pageBounds, @Param("elements") Elements elements);
	 
	 /**
	  * @Title: queryElementsByProperty
	  * @Description:根据属性查询码号信息
	  * @return List<Elements>
	  */
	 List<Elements> queryElementsByProperty(@Param("elements") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}

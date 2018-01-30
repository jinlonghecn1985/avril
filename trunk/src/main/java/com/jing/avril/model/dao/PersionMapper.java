package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.Persion;

/**
 * @ClassName: PersionMapper
 * @Description: 下家信息映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface PersionMapper {

	/**
	 * @Title: addPersion
	 * @Description:添加下家信息
	 * @param persion 实体
	 * @return Integer
	 */
	Integer addPersion(Persion persion);
	
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
	 * @param pageBounds 分页信息
	 * @param persion 实体
	 * @return List<Persion>
	 */
	List<Persion> queryPersionForPage(PageBounds pageBounds, @Param("persion") Persion persion);
	 
	 /**
	  * @Title: queryPersionByProperty
	  * @Description:根据属性查询下家信息
	  * @return List<Persion>
	  */
	 List<Persion> queryPersionByProperty(@Param("persion") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
}

package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.GoodsElement;

/**
 * @ClassName: GoodsElementMapper
 * @Description: 分组码号信息映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface GoodsElementMapper {

	/**
	 * @Title: addGoodsElement
	 * @Description:添加分组码号信息
	 * @param goodsElement 实体
	 * @return Integer
	 */
	Integer addGoodsElement(GoodsElement goodsElement);
	
	/**
	 * @Title modifyGoodsElement
	 * @Description:修改分组码号信息
	 * @param goodsElement 实体
	 * @return Integer
	 */
	Integer modifyGoodsElement(GoodsElement goodsElement);
	
	/**
	 * @Title: dropGoodsElementByGoodsId
	 * @Description:删除分组码号信息
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsElementByGoodsId(String goodsId);
	
	/**
	 * @Title: queryGoodsElementByGoodsId
	 * @Description:根据实体标识查询分组码号信息
	 * @param goodsId 实体标识
	 * @return List<GoodsElement>
	 */
	List<GoodsElement> queryGoodsElementByGoodsId(String goodsId);
	 
	/**
	 * @Title: queryGoodsElementForPage
	 * @Description: 根据分组码号信息属性与分页信息分页查询分组码号信息信息
	 * @param pageBounds 分页信息
	 * @param goodsElement 实体
	 * @return List<GoodsElement>
	 */
	List<GoodsElement> queryGoodsElementForPage(PageBounds pageBounds, @Param("goodsElement") GoodsElement goodsElement);
	 
	 /**
	  * @Title: queryGoodsElementByProperty
	  * @Description:根据属性查询分组码号信息
	  * @return List<GoodsElement>
	  */
	 List<GoodsElement> queryGoodsElementByProperty(@Param("goodsElement") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
   /** 
	* @Title: addGoodsElementsBatch 
	* @Description: 按组名，添加项
	* @param goodsId 新组标标
	* @param goodsNames 组名列表
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer addGoodsElementsBatch(@Param("goodsId")String goodsId, @Param("goodsNames")String goodsNames);
	 
}

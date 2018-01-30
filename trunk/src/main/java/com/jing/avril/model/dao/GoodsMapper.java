package com.jing.avril.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.avril.model.entity.Goods;

/**
 * @ClassName: GoodsMapper
 * @Description: 分组信息映射
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Mapper
public interface GoodsMapper {

	/**
	 * @Title: addGoods
	 * @Description:添加分组信息
	 * @param goods 实体
	 * @return Integer
	 */
	Integer addGoods(Goods goods);
	
	/**
	 * @Title modifyGoods
	 * @Description:修改分组信息
	 * @param goods 实体
	 * @return Integer
	 */
	Integer modifyGoods(Goods goods);
	
	/**
	 * @Title: dropGoodsByGoodsId
	 * @Description:删除分组信息
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsByGoodsId(String goodsId);
	
	/**
	 * @Title: queryGoodsByGoodsId
	 * @Description:根据实体标识查询分组信息
	 * @param goodsId 实体标识
	 * @return Goods
	 */
	Goods queryGoodsByGoodsId(String goodsId);
	 
	/**
	 * @Title: queryGoodsForPage
	 * @Description: 根据分组信息属性与分页信息分页查询分组信息信息
	 * @param pageBounds 分页信息
	 * @param goods 实体
	 * @return List<Goods>
	 */
	List<Goods> queryGoodsForPage(PageBounds pageBounds, @Param("goods") Goods goods);
	 
	 /**
	  * @Title: queryGoodsByProperty
	  * @Description:根据属性查询分组信息
	  * @return List<Goods>
	  */
	 List<Goods> queryGoodsByProperty(@Param("goods") Map<String, Object> map);
	 
	 /** 
	* @Title: queryGoodsByElementId 
	* @Description: 根据特号查询所有分组
	* @param elementId
	* @return  List<Goods>    返回类型 
	* @throws 
	*/
	List<Goods> queryGoodsByElementId(Integer elementId);
	
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}

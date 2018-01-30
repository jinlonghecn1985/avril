package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.GoodsElement;

/**
 * @ClassName: GoodsElement
 * @Description: 分组码号信息服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface GoodsElementService {

    /**
	 * @Title: addGoodsElement
	 * @Description:添加分组码号信息
	 * @param goodsElement 实体
	 * @return Integer
	 */
	GoodsElement addGoodsElement(GoodsElement goodsElement);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsElement 实体
	 * @return List<GoodsElement>
	 */
	Map<String, Object> queryGoodsElementForPage(Integer pagenum, Integer pagesize, String sort, GoodsElement goodsElement);
	 
	 /**
	 * @Title: queryGoodsElementByProperty
	 * @Description:根据属性查询分组码号信息
	 * @return List<GoodsElement>
	 */
	 List<GoodsElement> queryGoodsElementByProperty(Map<String, Object> map);	 
	 
}

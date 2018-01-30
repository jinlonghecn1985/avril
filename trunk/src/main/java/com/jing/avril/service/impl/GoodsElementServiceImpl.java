package com.jing.avril.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;
import java.util.UUID;

import com.jing.avril.model.entity.GoodsElement;
import com.jing.avril.model.dao.GoodsElementMapper;
import com.jing.avril.service.GoodsElementService;

/**
 * @ClassName: GoodsElement
 * @Description: 分组码号信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("goodsElementService")
@Transactional(readOnly=true)
public class  GoodsElementServiceImpl implements GoodsElementService {

	@Autowired
    private GoodsElementMapper goodsElementMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addGoodsElement
	 * @Description:添加分组码号信息
	 * @param goodsElement 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public GoodsElement addGoodsElement(GoodsElement goodsElement){
		if(null == goodsElement.getGoodsId()){			
         	goodsElement.setGoodsId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = goodsElementMapper.addGoodsElement(goodsElement);
		if(ret>0){
			return goodsElement;
		}
		return null;
	}
	
	/**
	 * @Title modifyGoodsElement
	 * @Description:修改分组码号信息
	 * @param goodsElement 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyGoodsElement(GoodsElement goodsElement){
		return goodsElementMapper.modifyGoodsElement(goodsElement);
	}
	
	/**
	 * @Title: dropGoodsElementByGoodsId
	 * @Description:删除分组码号信息
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropGoodsElementByGoodsId(String goodsId){
		return goodsElementMapper.dropGoodsElementByGoodsId(goodsId);
	}
	
	/**
	 * @Title: queryGoodsElementByGoodsId
	 * @Description:根据实体标识查询分组码号信息
	 * @param goodsId 实体标识
	 * @return List<GoodsElement>
	 */
	@Override
	public List<GoodsElement> queryGoodsElementByGoodsId(String goodsId){
		return goodsElementMapper.queryGoodsElementByGoodsId(goodsId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryGoodsElementForPage
	 * @Description: 根据分组码号信息属性与分页信息分页查询分组码号信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsElement 实体
	 * @return List<GoodsElement>
	 */
	@Override
	public Map<String, Object> queryGoodsElementForPage(Integer pagenum, Integer pagesize, String sort, GoodsElement goodsElement){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, GoodsElement.class);
		List<GoodsElement> entityList = goodsElementMapper.queryGoodsElementForPage(pageBounds, goodsElement);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, GoodsElement.class);
		}
		if (!entityList.isEmpty()) {
			PageList<GoodsElement> pagelist = (PageList<GoodsElement>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryGoodsElementByProperty
	 * @Description:根据属性查询分组码号信息
	 * @return List<GoodsElement>
	 */
	@Override
	public List<GoodsElement> queryGoodsElementByProperty(Map<String, Object> map){
		return goodsElementMapper.queryGoodsElementByProperty(map);
	}


}

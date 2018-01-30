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

import com.jing.avril.model.entity.Elements;
import com.jing.avril.model.dao.ElementsMapper;
import com.jing.avril.service.ElementsService;

/**
 * @ClassName: Elements
 * @Description: 码号信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("elementsService")
@Transactional(readOnly=true)
public class  ElementsServiceImpl implements ElementsService {

	@Autowired
    private ElementsMapper elementsMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addElements
	 * @Description:添加码号信息
	 * @param elements 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Elements addElements(Elements elements){		
		int ret = elementsMapper.addElements(elements);
		if(ret>0){
			return elements;
		}
		return null;
	}
	
	/**
	 * @Title modifyElements
	 * @Description:修改码号信息
	 * @param elements 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyElements(Elements elements){
		return elementsMapper.modifyElements(elements);
	}
	
	/**
	 * @Title: dropElementsByElement
	 * @Description:删除码号信息
	 * @param element 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropElementsByElement(Integer element){
		return elementsMapper.dropElementsByElement(element);
	}
	
	/**
	 * @Title: queryElementsByElement
	 * @Description:根据实体标识查询码号信息
	 * @param element 实体标识
	 * @return Elements
	 */
	@Override
	public Elements queryElementsByElement(Integer element){
		return elementsMapper.queryElementsByElement(element);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryElementsForPage
	 * @Description: 根据码号信息属性与分页信息分页查询码号信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param elements 实体
	 * @return List<Elements>
	 */
	@Override
	public Map<String, Object> queryElementsForPage(Integer pagenum, Integer pagesize, String sort, Elements elements){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Elements.class);
		List<Elements> entityList = elementsMapper.queryElementsForPage(pageBounds, elements);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Elements.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Elements> pagelist = (PageList<Elements>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryElementsByProperty
	 * @Description:根据属性查询码号信息
	 * @return List<Elements>
	 */
	@Override
	public List<Elements> queryElementsByProperty(Map<String, Object> map){
		return elementsMapper.queryElementsByProperty(map);
	}


}

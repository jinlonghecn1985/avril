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

import com.jing.avril.model.entity.Dictionary;
import com.jing.avril.model.dao.DictionaryMapper;
import com.jing.avril.service.DictionaryService;

/**
 * @ClassName: DictionaryServiceImpl
 * @Description: 字典信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("dictionaryService")
@Transactional(readOnly=true)
public class  DictionaryServiceImpl implements DictionaryService {

	@Autowired
    private DictionaryMapper dictionaryMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addDictionary
	 * @Description:添加字典信息
	 * @param dictionary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Dictionary addDictionary(Dictionary dictionary){
		if(null == dictionary.getDicId()){			
         	dictionary.setDicId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		int ret = dictionaryMapper.addDictionary(dictionary);
		if(ret>0){
			return dictionary;
		}
		return null;
	}
	
	/**
	 * @Title modifyDictionary
	 * @Description:修改字典信息
	 * @param dictionary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDictionary(Dictionary dictionary){
		return dictionaryMapper.modifyDictionary(dictionary);
	}
	
	/**
	 * @Title: dropDictionaryByDicId
	 * @Description:删除字典信息
	 * @param dicId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDictionaryByDicId(String dicId){
		return dictionaryMapper.dropDictionaryByDicId(dicId);
	}
	
	/**
	 * @Title: queryDictionaryByDicId
	 * @Description:根据实体标识查询字典信息
	 * @param dicId 实体标识
	 * @return Dictionary
	 */
	@Override
	public Dictionary queryDictionaryByDicId(String dicId){
		return dictionaryMapper.queryDictionaryByDicId(dicId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryDictionaryForPage
	 * @Description: 根据字典信息属性与分页信息分页查询字典信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param dictionary 实体
	 * @return List<Dictionary>
	 */
	@Override
	public Map<String, Object> queryDictionaryForPage(Integer pagenum, Integer pagesize, String sort, Dictionary dictionary){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Dictionary.class);
		List<Dictionary> entityList = dictionaryMapper.queryDictionaryForPage(pageBounds, dictionary);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Dictionary.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Dictionary> pagelist = (PageList<Dictionary>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryDictionaryByProperty
	 * @Description:根据属性查询字典信息
	 * @return List<Dictionary>
	 */
	@Override
	public List<Dictionary> queryDictionaryByProperty(Map<String, Object> map){
		return dictionaryMapper.queryDictionaryByProperty(map);
	}


}

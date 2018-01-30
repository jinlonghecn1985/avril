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

import com.jing.avril.model.entity.Persion;
import com.jing.avril.model.dao.PersionMapper;
import com.jing.avril.service.PersionService;
import com.jing.avril.util.AvrilUtil;

/**
 * @ClassName: Persion
 * @Description: 下家信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@Service("persionService")
@Transactional(readOnly=true)
public class  PersionServiceImpl implements PersionService {

	@Autowired
    private PersionMapper persionMapper;   
    
	@Autowired
	private AvrilUtil avrilUtil;
	
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addPersion
	 * @Description:添加下家信息
	 * @param persion 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Persion addPersion(Persion persion){
		if(null == persion.getPersionId()){			
         	persion.setPersionId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		}
		if(persion.getRatioBonus()==null){
			persion.setRatioBonus(avrilUtil.backBonus);
		}
		if(persion.getRatioRate()==null){
			persion.setRatioRate(avrilUtil.backRate);
		}
		if(persion.getPercentRate()==null){
			persion.setPercentRate(avrilUtil.backRate2);
		}
		if(persion.getPersionName()==null){
			persion.setPersionName(persion.getPersionKey());
		}
		
		int ret = persionMapper.addPersion(persion);
		if(ret>0){
			return persion;
		}
		return null;
	}
	
	/**
	 * @Title modifyPersion
	 * @Description:修改下家信息
	 * @param persion 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyPersion(Persion persion){
		return persionMapper.modifyPersion(persion);
	}
	
	/**
	 * @Title: dropPersionByPersionId
	 * @Description:删除下家信息
	 * @param persionId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropPersionByPersionId(String persionId){
		return persionMapper.dropPersionByPersionId(persionId);
	}
	
	/**
	 * @Title: queryPersionByPersionId
	 * @Description:根据实体标识查询下家信息
	 * @param persionId 实体标识
	 * @return Persion
	 */
	@Override
	public Persion queryPersionByPersionId(String persionId){
		return persionMapper.queryPersionByPersionId(persionId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryPersionForPage
	 * @Description: 根据下家信息属性与分页信息分页查询下家信息信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param persion 实体
	 * @return List<Persion>
	 */
	@Override
	public Map<String, Object> queryPersionForPage(Integer pagenum, Integer pagesize, String sort, Persion persion){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Persion.class);
		List<Persion> entityList = persionMapper.queryPersionForPage(pageBounds, persion);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Persion.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Persion> pagelist = (PageList<Persion>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryPersionByProperty
	 * @Description:根据属性查询下家信息
	 * @return List<Persion>
	 */
	@Override
	public List<Persion> queryPersionByProperty(Map<String, Object> map){
		return persionMapper.queryPersionByProperty(map);
	}

}

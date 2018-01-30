package com.jing.avril.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.avril.model.dao.DictionaryMapper;
import com.jing.avril.model.dao.GoodsElementMapper;
import com.jing.avril.model.dao.GoodsMapper;
import com.jing.avril.model.dao.StatisticsMapper;
import com.jing.avril.model.entity.Goods;
import com.jing.avril.model.entity.GoodsElement;
import com.jing.avril.service.StatisticsService;
import com.jing.avril.util.AvrilUtil;

/**
 * @ClassName: StatisticsServiceImpl
 * @Description: 统计查询类相关方法
 * @author: Jinlong He
 * @date: 2017年8月1日 上午8:28:05
 */
@Service("statisticsService")
@Transactional(readOnly=true)
public class StatisticsServiceImpl implements StatisticsService {
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Autowired
	private AvrilUtil avrilUtil;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private GoodsElementMapper goodsElementMapper;
	
	@Autowired
	private StatisticsMapper statisticsMapper;

	@Override
	public List<Map<String, Object>> queryGoodsKeyHelp(){
		Map<String, Object> query = new HashMap<String, Object>();
//		//基础配置
//		query.put("dicGroup", "config");
//		query.put("dicCode", "maxNum");
//		List<Dictionary> dicList = dictionaryMapper.queryDictionaryByProperty(query);
//		if(dicList==null || dicList.size()==0){
//			return null;
//		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsKeyMax", avrilUtil.maxNum);
		List<Goods> goods = goodsMapper.queryGoodsByProperty(map);
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		for(Goods gd : goods){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("goodsName", gd.getGoodsName());
			temp.put("goodsKey", gd.getGoodsKey());
			temp.put("goodsId", gd.getGoodsId());
			List<GoodsElement> gelist = goodsElementMapper.queryGoodsElementByGoodsId(gd.getGoodsId());
			if(gelist==null || gelist.size()==0){
				temp.put("goodsList", "");	
				temp.put("goodsCounts", 0);
			}else{
				StringBuffer sb = new StringBuffer();
				for(GoodsElement ge : gelist){
					sb.append(ge.getElementId()).append(",");
				}
				String sbs = sb.toString();
				if(sbs!=null && sb.length()>1){
					sbs = sbs.substring(0, sbs.length()-1);
				}
				temp.put("goodsList", sbs);	
				temp.put("goodsCounts", gelist.size());
			}
			ret.add(temp);
		}		
		return ret;
	}

	@Override
	public List<Map<String, Object>> queryElementGoods() {
		List<Map<String, Object>> ret = statisticsMapper.queryElementOnColorAnima();
		if(ret==null || ret.size()==0){
			return ret;
		}		
		for(int i=0; i<ret.size(); i++){
			ret.get(i).put("colorimg", AvrilUtil.colorMap.get(ret.get(i).get("color")));
			ret.get(i).put("animalimg", AvrilUtil.animalMap.get(ret.get(i).get("animal")));
		}
		return ret;
	}

	@Override
	public List<Map<String, Object>> queryTradeDetailStatistics(Map<String, Object> map) {
		return statisticsMapper.queryTradeDetailStatistics(map);
	}
	
}

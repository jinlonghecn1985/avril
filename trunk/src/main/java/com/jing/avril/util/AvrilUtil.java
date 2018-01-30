package com.jing.avril.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jing.avril.model.dao.DictionaryMapper;
import com.jing.avril.model.entity.Dictionary;
import com.jing.avril.model.entity.Goods;
import com.jing.avril.model.entity.GoodsElement;
import com.jing.avril.service.GoodsElementService;
import com.jing.avril.service.GoodsService;

@Component(value="avrilUtil")
public class AvrilUtil {
	
	@Autowired
	private GoodsElementService goodsElementService;	
	
	@Autowired
    private GoodsService goodsService;
	
	@Autowired
    private DictionaryMapper dictionaryMapper;   
	
	
	/**
	 * @fieldName: colorMap
	 * @fieldType: Map<String,Object>
	 * @Description: 色彩
	 */
	public static Map<String, Object> colorMap = new HashMap<String, Object>();
	/**
	 * @fieldName: animalMap
	 * @fieldType: Map<String,Object>
	 * @Description: 生肖
	 */
	public static Map<String, Object> animalMap = new HashMap<String, Object>();
	
	/**
	 * @fieldName: maxNum
	 * @fieldType: Integer
	 * @Description: 数据量
	 */
	public Integer maxNum = 49;
	
	/**
	 * @fieldName: upBackRate
	 * @fieldType: Integer
	 * @Description: 上家返利百分比
	 */
	public Integer upBackRate = 13;
	
	/**
	 * @fieldName: backBonus
	 * @fieldType: Integer
	 * @Description: 赔率
	 */
	public Integer backBonus = 41;
	
	/**
	 * @fieldName: backRate
	 * @fieldType: Integer
	 * @Description: 基本返水
	 */
	public Integer backRate = 10;
	
	/**
	 * @fieldName: backRate2
	 * @fieldType: Integer
	 * @Description: 二次返水
	 */
	public Integer backRate2 = 2;
	
	/**
	 * @fieldName: goodsMap
	 * @fieldType: Map<String,Goods>
	 * @Description: 分组信息  key为快捷键
	 */
	public static Map<String, Goods> goodsMap = new HashMap<String, Goods>();
	
	
	/**
	 * @fieldName: goodsElementMap
	 * @fieldType: Map<String,List<GoodsElement>>
	 * @Description: 分组项信息  key为快捷键
	 */
	public static Map<String, List<GoodsElement>> goodsElementMap = new HashMap<String, List<GoodsElement>>();
	
	//数据填充
	static{
		colorMap.put("红", "r");
		colorMap.put("蓝", "b");
		colorMap.put("绿", "g");
		
		animalMap.put("鼠", 1);
		animalMap.put("牛", 2);
		animalMap.put("虎", 3);
		animalMap.put("兔", 4);
		animalMap.put("龙", 5);
		animalMap.put("蛇", 6);
		
		animalMap.put("马", 7);
		animalMap.put("羊", 8);
		animalMap.put("猴", 9);
		animalMap.put("鸡", 10);
		animalMap.put("狗", 11);
		animalMap.put("猪", 12);
	}
	
	/** 
	* @Title: reloadData 
	* @Description: 重新加载数据
	* @return  boolean    返回类型 
	* @throws 
	*/
	public boolean reloadData(){
		goodsMap.clear();
		goodsElementMap.clear();
		init();
		return true;
	}
	
	@PostConstruct
	private void init(){
		Map<String, Object> query = new HashMap<String, Object>();
		//基础配置
		query.put("dicGroup", "config");
		//query.put("dicCode", "maxNum");
		List<Dictionary> dicList = dictionaryMapper.queryDictionaryByProperty(query);
		if(dicList!=null && dicList.size()>0){			
			for(Dictionary d : dicList){
				try{
					if("maxNum".equals(d.getDicCode())){
						maxNum = Integer.parseInt(d.getDicValue());
					}else if("back".equals(d.getDicCode())){
						upBackRate = Integer.parseInt(d.getDicValue());
					}else if("bonus".equals(d.getDicCode())){
						backBonus = Integer.parseInt(d.getDicValue());
					}else if("backrate".equals(d.getDicCode())){
						backRate = Integer.parseInt(d.getDicValue());
					}else if("backrate2".equals(d.getDicCode())){
						backRate2 = Integer.parseInt(d.getDicValue());
					}
				}catch(NumberFormatException e){
					
				}
			}
		}
		
		List<Goods> goods = goodsService.queryGoodsByProperty(new HashMap<String, Object>());
		for(Goods g : goods){
			goodsMap.put(g.getGoodsKey(), g);
			goodsElementMap.put(g.getGoodsKey(), goodsElementService.queryGoodsElementByGoodsId(g.getGoodsId()));
		}
	}

}

package com.jing.avril.service;

import com.jing.avril.controller.bo.TradeBo;

public interface OperationService {

	/** 
	* @Title: dropStage 
	* @Description: 清空期别数据
	* @param stageId
	* @return  int    返回类型 
	* @throws 
	*/
	int dropStage(String stageId);
	
	/** 
	* @Title: clearAllConfig
	* @Description: 清理配置文件--删除所有数据
	* @return  int    返回类型 
	* @throws 
	*/
	int clearAllConfig();
	
	/** 
	* @Title: loadOtherConfig 
	* @Description: 加载配置文件 --不清空主要数据
	* @return  int    返回类型 
	* @throws 
	*/
	int loadOtherConfig();
	
	/**
	 * @throws Exception  
	* @Title: initSystem 
	* @Description: 初始系统
	* @return  Object    返回类型 
	* @throws 
	*/
	Object initSystem() throws Exception;


	/** 
	* @Title: justDestructSystem 
	* @Description: SOS-破坏系统
	* @return  int    返回类型 
	* @throws 
	*/
	int justDestructSystem();

	/** 
	* @Title: addTradeBo 
	* @Description: 处理快捷录入数据
	* @param tradeBo
	* @return  TradeBo    返回类型 
	* @throws 
	*/
	TradeBo addTradeBo(TradeBo tradeBo);
	
	/** 
	* @Title: calculationStage 
	* @Description: 计算数据 
	* @param stageId
	* @return  Object    返回类型 
	* @throws 
	*/
	Object calculationStage(String stageId);
	
	/** 
	* @Title: terminatorStage 
	* @Description: 结算
	* @param stageId
	* @return  Object    返回类型 
	* @throws 
	*/
	Object terminatorStage(String stageId);
	
}

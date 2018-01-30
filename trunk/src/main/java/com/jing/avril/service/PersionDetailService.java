package com.jing.avril.service;

import java.util.List;
import java.util.Map;


import com.jing.avril.model.entity.PersionDetail;

/**
 * @ClassName: PersionDetail
 * @Description: 期别下家交易数据服务接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public interface PersionDetailService {

    /**
	 * @Title: addPersionDetail
	 * @Description:添加期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	PersionDetail addPersionDetail(PersionDetail persionDetail);
	
	/**
	 * @Title modifyPersionDetail
	 * @Description:修改期别下家交易数据
	 * @param persionDetail 实体
	 * @return Integer
	 */
	Integer modifyPersionDetail(PersionDetail persionDetail);
	
	Integer modifyPersionDetailByStagePerion(PersionDetail persionDetail);
	
	/**
	 * @Title: dropPersionDetailBySpId
	 * @Description:删除期别下家交易数据
	 * @param spId 实体标识
	 * @return Integer
	 */
	Integer dropPersionDetailBySpId(String spId);
	
	/**
	 * @Title: queryPersionDetailBySpId
	 * @Description:根据实体标识查询期别下家交易数据
	 * @param spId 实体标识
	 * @return PersionDetail
	 */
	PersionDetail queryPersionDetailBySpId(String spId);
	 
	/**
	 * @Title: queryPersionDetailForPage
	 * @Description: 根据期别下家交易数据属性与分页信息分页查询期别下家交易数据信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param persionDetail 实体
	 * @return List<PersionDetail>
	 */
	Map<String, Object> queryPersionDetailForPage(Integer pagenum, Integer pagesize, String sort, PersionDetail persionDetail);
	 
	 /**
	 * @Title: queryPersionDetailByProperty
	 * @Description:根据属性查询期别下家交易数据
	 * @return List<PersionDetail>
	 */
	 List<PersionDetail> queryPersionDetailByProperty(Map<String, Object> map);	 
	 
	 /** 
	* @Title: bindPersionDetailOnStagePersion 
	* @Description: 按期号和人员统计 
	* @param stageId
	* @param persionId
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer bindPersionDetailOnStagePersion(String stageId, String persionId);
	 
}

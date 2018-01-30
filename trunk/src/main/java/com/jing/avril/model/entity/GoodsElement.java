package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;


/**
 * @ClassName: GoodsElement
 * @Description: 分组码号信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class GoodsElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//tb_goods_element:goods_id  分组标识  

	private Integer elementId;	//tb_goods_element:element_id  码号  

	private Date gmtCreated;	//tb_goods_element:gmt_created  新增时间  

	private Date gmtModify;	//tb_goods_element:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_goods_element:goods_id
	* @Description: 获取属性        分组标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:goods_id
	* @Description: 设置属性        分组标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:element_id
	* @Description: 获取属性        码号
	* @return: Integer
	*/
	public Integer getElementId(){
		return elementId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:element_id
	* @Description: 设置属性        码号
	* @return: Integer
	*/
	public void setElementId(Integer elementId){
		this.elementId = elementId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods_element:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


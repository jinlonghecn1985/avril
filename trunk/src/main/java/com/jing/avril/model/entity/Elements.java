package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: Elements
 * @Description: 码号信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class Elements implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer element;	//tb_elements:element  码号  

	private Date gmtCreated;	//tb_elements:gmt_created  新增时间  

	private Date gmtModify;	//tb_elements:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_elements:element
	* @Description: 获取属性        码号
	* @return: Integer
	*/
	public Integer getElement(){
		return element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_elements:element
	* @Description: 设置属性        码号
	* @return: Integer
	*/
	public void setElement(Integer element){
		this.element = element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_elements:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_elements:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_elements:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_elements:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


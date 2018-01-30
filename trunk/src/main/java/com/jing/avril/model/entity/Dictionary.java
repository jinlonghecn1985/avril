package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: Dictionary
 * @Description: 字典信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年08月02日 14时22分
 */
public class Dictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicId;	//tb_dictionary:dic_id  标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicGroup;	//tb_dictionary:dic_group  组别  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicCode;	//tb_dictionary:dic_code  代码  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicValue;	//tb_dictionary:dic_value  值  

	private Integer dicFlag;	//tb_dictionary:dic_flag  排序  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicNote;	//tb_dictionary:dic_note  说明  

	@Length(min=0, max=4, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicBonus;	//tb_dictionary:dic_bonus  数据1-倍率  

	@Length(min=0, max=2, message="{org.hibernate.validator.constraints.Length.message}")
	private String dicBack;	//tb_dictionary:dic_back  数据二 返点  

	private Date gmtCreated;	//tb_dictionary:gmt_created  创建时间  

	private Date gmtModify;	//tb_dictionary:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_dictionary:dic_id
	* @Description: 获取属性        标识
	* @return: String
	*/
	public String getDicId(){
		return dicId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_id
	* @Description: 设置属性        标识
	* @return: String
	*/
	public void setDicId(String dicId){
		this.dicId = dicId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_group
	* @Description: 获取属性        组别
	* @return: String
	*/
	public String getDicGroup(){
		return dicGroup;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_group
	* @Description: 设置属性        组别
	* @return: String
	*/
	public void setDicGroup(String dicGroup){
		this.dicGroup = dicGroup;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_code
	* @Description: 获取属性        代码
	* @return: String
	*/
	public String getDicCode(){
		return dicCode;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_code
	* @Description: 设置属性        代码
	* @return: String
	*/
	public void setDicCode(String dicCode){
		this.dicCode = dicCode;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_value
	* @Description: 获取属性        值
	* @return: String
	*/
	public String getDicValue(){
		return dicValue;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_value
	* @Description: 设置属性        值
	* @return: String
	*/
	public void setDicValue(String dicValue){
		this.dicValue = dicValue;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_flag
	* @Description: 获取属性        排序
	* @return: Integer
	*/
	public Integer getDicFlag(){
		return dicFlag;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_flag
	* @Description: 设置属性        排序
	* @return: Integer
	*/
	public void setDicFlag(Integer dicFlag){
		this.dicFlag = dicFlag;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_note
	* @Description: 获取属性        说明
	* @return: String
	*/
	public String getDicNote(){
		return dicNote;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_note
	* @Description: 设置属性        说明
	* @return: String
	*/
	public void setDicNote(String dicNote){
		this.dicNote = dicNote;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_bonus
	* @Description: 获取属性        数据1-倍率
	* @return: String
	*/
	public String getDicBonus(){
		return dicBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_bonus
	* @Description: 设置属性        数据1-倍率
	* @return: String
	*/
	public void setDicBonus(String dicBonus){
		this.dicBonus = dicBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_back
	* @Description: 获取属性        数据二 返点
	* @return: String
	*/
	public String getDicBack(){
		return dicBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:dic_back
	* @Description: 设置属性        数据二 返点
	* @return: String
	*/
	public void setDicBack(String dicBack){
		this.dicBack = dicBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:gmt_created
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:gmt_created
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_dictionary:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


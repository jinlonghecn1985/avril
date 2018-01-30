package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: Persion
 * @Description: 下家信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class Persion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionId;	//tb_persion:persion_id  下家标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionName;	//tb_persion:persion_name  下家名称  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionKey;	//tb_persion:persion_key  快捷代号  

	private Integer ratioBonus;	//tb_persion:ratio_bonus  特号倍率  

	private Integer ratioRate;	//tb_persion:ratio_rate  普通返利百分比  

	private Integer percentRate;	//tb_persion:percent_rate  百分比计算返利百分比  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//tb_persion:note  备注  

	private Date gmtCreated;	//tb_persion:gmt_created  新增时间  

	private Date gmtModify;	//tb_persion:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_persion:persion_id
	* @Description: 获取属性        下家标识
	* @return: String
	*/
	public String getPersionId(){
		return persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:persion_id
	* @Description: 设置属性        下家标识
	* @return: String
	*/
	public void setPersionId(String persionId){
		this.persionId = persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:persion_name
	* @Description: 获取属性        下家名称
	* @return: String
	*/
	public String getPersionName(){
		return persionName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:persion_name
	* @Description: 设置属性        下家名称
	* @return: String
	*/
	public void setPersionName(String persionName){
		this.persionName = persionName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:persion_key
	* @Description: 获取属性        快捷代号
	* @return: String
	*/
	public String getPersionKey(){
		return persionKey;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:persion_key
	* @Description: 设置属性        快捷代号
	* @return: String
	*/
	public void setPersionKey(String persionKey){
		this.persionKey = persionKey;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:ratio_bonus
	* @Description: 获取属性        特号倍率
	* @return: Integer
	*/
	public Integer getRatioBonus(){
		return ratioBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:ratio_bonus
	* @Description: 设置属性        特号倍率
	* @return: Integer
	*/
	public void setRatioBonus(Integer ratioBonus){
		this.ratioBonus = ratioBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:ratio_rate
	* @Description: 获取属性        普通返利百分比
	* @return: Integer
	*/
	public Integer getRatioRate(){
		return ratioRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:ratio_rate
	* @Description: 设置属性        普通返利百分比
	* @return: Integer
	*/
	public void setRatioRate(Integer ratioRate){
		this.ratioRate = ratioRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:percent_rate
	* @Description: 获取属性        百分比计算返利百分比
	* @return: Integer
	*/
	public Integer getPercentRate(){
		return percentRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:percent_rate
	* @Description: 设置属性        百分比计算返利百分比
	* @return: Integer
	*/
	public void setPercentRate(Integer percentRate){
		this.percentRate = percentRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:note
	* @Description: 获取属性        备注
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:note
	* @Description: 设置属性        备注
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


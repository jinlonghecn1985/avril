package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: StageDetail
 * @Description: 期号交易数据实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class StageDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String billId;	//tb_stage_detail:bill_id  标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageId;	//tb_stage_detail:stage_id  期号标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer element;	//tb_stage_detail:element  码号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long upbill;	//tb_stage_detail:upbill  上报金额  

	private Date gmtCreated;	//tb_stage_detail:gmt_created  创建时间  

	private Date gmtModify;	//tb_stage_detail:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_stage_detail:bill_id
	* @Description: 获取属性        标识
	* @return: String
	*/
	public String getBillId(){
		return billId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:bill_id
	* @Description: 设置属性        标识
	* @return: String
	*/
	public void setBillId(String billId){
		this.billId = billId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:stage_id
	* @Description: 获取属性        期号标识
	* @return: String
	*/
	public String getStageId(){
		return stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:stage_id
	* @Description: 设置属性        期号标识
	* @return: String
	*/
	public void setStageId(String stageId){
		this.stageId = stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:element
	* @Description: 获取属性        码号
	* @return: Integer
	*/
	public Integer getElement(){
		return element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:element
	* @Description: 设置属性        码号
	* @return: Integer
	*/
	public void setElement(Integer element){
		this.element = element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:upbill
	* @Description: 获取属性        上报金额
	* @return: Long
	*/
	public Long getUpbill(){
		return upbill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:upbill
	* @Description: 设置属性        上报金额
	* @return: Long
	*/
	public void setUpbill(Long upbill){
		this.upbill = upbill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:gmt_created
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:gmt_created
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage_detail:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


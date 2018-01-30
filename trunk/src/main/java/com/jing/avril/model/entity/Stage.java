package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: Stage
 * @Description: 期号信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class Stage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageId;	//tb_stage:stage_id  期别标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageName;	//tb_stage:stage_name  期别名称yyyyMMdd  

	private Integer element;	//tb_stage:element  特号  

	private Integer status;	//tb_stage:status  状态0正常1锁定  

	private Long stageRisk;	//tb_stage:stage_risk  风险金  

	private Long stageBill;	//tb_stage:stage_bill  总量  

	private Long stageBack;	//tb_stage:stage_back  返利  

	private Long stageGift;	//tb_stage:stage_gift  结算赢亏  

	private Integer upRate;	//tb_stage:up_rate  上报返利百分比  

	private Long upBill;	//tb_stage:up_bill  上报总额  

	private Long upBack;	//tb_stage:up_back  上报返利  

	private Long upGift;	//tb_stage:up_gift  上报特号结算  
	
	private Long balance;  //本期结算-
	
	

	private Date gmtCreated;	//tb_stage:gmt_created  新增时间  

	private Date gmtModify;	//tb_stage:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_stage:stage_id
	* @Description: 获取属性        期别标识
	* @return: String
	*/
	public String getStageId(){
		return stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_id
	* @Description: 设置属性        期别标识
	* @return: String
	*/
	public void setStageId(String stageId){
		this.stageId = stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_name
	* @Description: 获取属性        期别名称yyyyMMdd
	* @return: String
	*/
	public String getStageName(){
		return stageName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_name
	* @Description: 设置属性        期别名称yyyyMMdd
	* @return: String
	*/
	public void setStageName(String stageName){
		this.stageName = stageName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:element
	* @Description: 获取属性        特号
	* @return: Integer
	*/
	public Integer getElement(){
		return element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:element
	* @Description: 设置属性        特号
	* @return: Integer
	*/
	public void setElement(Integer element){
		this.element = element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:status
	* @Description: 获取属性        状态0正常1锁定
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:status
	* @Description: 设置属性        状态0正常1锁定
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_risk
	* @Description: 获取属性        风险金
	* @return: Long
	*/
	public Long getStageRisk(){
		return stageRisk;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_risk
	* @Description: 设置属性        风险金
	* @return: Long
	*/
	public void setStageRisk(Long stageRisk){
		this.stageRisk = stageRisk;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_bill
	* @Description: 获取属性        总量
	* @return: Long
	*/
	public Long getStageBill(){
		return stageBill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_bill
	* @Description: 设置属性        总量
	* @return: Long
	*/
	public void setStageBill(Long stageBill){
		this.stageBill = stageBill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_back
	* @Description: 获取属性        返利
	* @return: Long
	*/
	public Long getStageBack(){
		return stageBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_back
	* @Description: 设置属性        返利
	* @return: Long
	*/
	public void setStageBack(Long stageBack){
		this.stageBack = stageBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_gift
	* @Description: 获取属性        结算赢亏
	* @return: Long
	*/
	public Long getStageGift(){
		return stageGift;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:stage_gift
	* @Description: 设置属性        结算赢亏
	* @return: Long
	*/
	public void setStageGift(Long stageGift){
		this.stageGift = stageGift;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_rate
	* @Description: 获取属性        上报返利百分比
	* @return: Integer
	*/
	public Integer getUpRate(){
		return upRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_rate
	* @Description: 设置属性        上报返利百分比
	* @return: Integer
	*/
	public void setUpRate(Integer upRate){
		this.upRate = upRate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_bill
	* @Description: 获取属性        上报总额
	* @return: Long
	*/
	public Long getUpBill(){
		return upBill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_bill
	* @Description: 设置属性        上报总额
	* @return: Long
	*/
	public void setUpBill(Long upBill){
		this.upBill = upBill;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_back
	* @Description: 获取属性        上报返利
	* @return: Long
	*/
	public Long getUpBack(){
		return upBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_back
	* @Description: 设置属性        上报返利
	* @return: Long
	*/
	public void setUpBack(Long upBack){
		this.upBack = upBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_gift
	* @Description: 获取属性        上报特号结算
	* @return: Long
	*/
	public Long getUpGift(){
		return upGift;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:up_gift
	* @Description: 设置属性        上报特号结算
	* @return: Long
	*/
	public void setUpGift(Long upGift){
		this.upGift = upGift;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_stage:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	
	
	
}


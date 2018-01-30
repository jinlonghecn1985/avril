package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: PersionDetail
 * @Description: 期别下家交易数据实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class PersionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String spId;	//tb_persion_detail:sp_id  标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageId;	//tb_persion_detail:stage_id  期别标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionId;	//tb_persion_detail:persion_id  下家标识  
	
	private String persionName;//下家姓名
	private String persionKey;	//快捷代号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long totalMoney;	//tb_persion_detail:total_money  总金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long bonusMoney;	//tb_persion_detail:bonus_money  奖金金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long backMoney;	//tb_persion_detail:back_money  返点金额  
	
	private Long balance;  //本期结算-

	private Date gmtCreated;	//tb_persion_detail:gmt_created  创建时间  

	private Date gmtModify;	//tb_persion_detail:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_persion_detail:sp_id
	* @Description: 获取属性        标识
	* @return: String
	*/
	public String getSpId(){
		return spId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:sp_id
	* @Description: 设置属性        标识
	* @return: String
	*/
	public void setSpId(String spId){
		this.spId = spId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:stage_id
	* @Description: 获取属性        期别标识
	* @return: String
	*/
	public String getStageId(){
		return stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:stage_id
	* @Description: 设置属性        期别标识
	* @return: String
	*/
	public void setStageId(String stageId){
		this.stageId = stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:persion_id
	* @Description: 获取属性        下家标识
	* @return: String
	*/
	public String getPersionId(){
		return persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:persion_id
	* @Description: 设置属性        下家标识
	* @return: String
	*/
	public void setPersionId(String persionId){
		this.persionId = persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:total_money
	* @Description: 获取属性        总金额
	* @return: Long
	*/
	public Long getTotalMoney(){
		return totalMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:total_money
	* @Description: 设置属性        总金额
	* @return: Long
	*/
	public void setTotalMoney(Long totalMoney){
		this.totalMoney = totalMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:bonus_money
	* @Description: 获取属性        奖金金额
	* @return: Long
	*/
	public Long getBonusMoney(){
		return bonusMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:bonus_money
	* @Description: 设置属性        奖金金额
	* @return: Long
	*/
	public void setBonusMoney(Long bonusMoney){
		this.bonusMoney = bonusMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:back_money
	* @Description: 获取属性        返点金额
	* @return: Long
	*/
	public Long getBackMoney(){
		return backMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:back_money
	* @Description: 设置属性        返点金额
	* @return: Long
	*/
	public void setBackMoney(Long backMoney){
		this.backMoney = backMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:gmt_created
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:gmt_created
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_persion_detail:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}

	public String getPersionName() {
		return persionName;
	}

	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}

	public String getPersionKey() {
		return persionKey;
	}

	public void setPersionKey(String persionKey) {
		this.persionKey = persionKey;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	
	
	
}


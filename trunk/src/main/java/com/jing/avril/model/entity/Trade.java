package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: Trade
 * @Description: 交易总情况实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class Trade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String tradeId;	//tb_trade:trade_id  流水标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String tradeCode;	//tb_trade:trade_code  快捷输入  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageId;	//tb_trade:stage_id  期别标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionId;	//tb_trade:persion_id  下家标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_trade:status  状态0正常  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//tb_trade:goods_id  组号  

	private String goodsName; //名称
	
	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long sfee;	//tb_trade:sfee  费用，单个 
	
	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long fee;	//tb_trade:fee  费用，总计  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long back;	//tb_trade:back  返利金额  
	
	private Long bonus;	//tb_trade:bonus  奖金

	private Date gmtCreated;	//tb_trade:gmt_created  新增时间  

	private Date gmtModify;	//tb_trade:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_trade:trade_id
	* @Description: 获取属性        流水标识
	* @return: String
	*/
	public String getTradeId(){
		return tradeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:trade_id
	* @Description: 设置属性        流水标识
	* @return: String
	*/
	public void setTradeId(String tradeId){
		this.tradeId = tradeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:trade_code
	* @Description: 获取属性        快捷输入
	* @return: String
	*/
	public String getTradeCode(){
		return tradeCode;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:trade_code
	* @Description: 设置属性        快捷输入
	* @return: String
	*/
	public void setTradeCode(String tradeCode){
		this.tradeCode = tradeCode;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:stage_id
	* @Description: 获取属性        期别标识
	* @return: String
	*/
	public String getStageId(){
		return stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:stage_id
	* @Description: 设置属性        期别标识
	* @return: String
	*/
	public void setStageId(String stageId){
		this.stageId = stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:persion_id
	* @Description: 获取属性        下家标识
	* @return: String
	*/
	public String getPersionId(){
		return persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:persion_id
	* @Description: 设置属性        下家标识
	* @return: String
	*/
	public void setPersionId(String persionId){
		this.persionId = persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:status
	* @Description: 获取属性        状态0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:status
	* @Description: 设置属性        状态0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:goods_id
	* @Description: 获取属性        货号
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:goods_id
	* @Description: 设置属性        货号
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:fee
	* @Description: 获取属性        费用，总计
	* @return: Long
	*/
	public Long getFee(){
		return fee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:fee
	* @Description: 设置属性        费用，总计
	* @return: Long
	*/
	public void setFee(Long fee){
		this.fee = fee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:sfee
	* @Description: 获取属性        费用，单个
	* @return: Long
	*/
	public Long getSfee(){
		return sfee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:sfee
	* @Description: 设置属性        费用，单个
	* @return: Long
	*/
	public void setSfee(Long sfee){
		this.sfee = sfee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:back
	* @Description: 获取属性        返利金额
	* @return: Long
	*/
	public Long getBack(){
		return back;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:back
	* @Description: 设置属性        返利金额
	* @return: Long
	*/
	public void setBack(Long back){
		this.back = back;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getBonus() {
		return bonus;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}
	
	
	
	
	
}


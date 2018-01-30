package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: TradeDetail
 * @Description: 交易详细码号情况实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
public class TradeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String detailId;	//tb_trade_detail:detail_id  交易详情标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String tradeId;	//tb_trade_detail:trade_id  交易流水  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String stageId;	//tb_trade_detail:stage_id  期别标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String persionId;	//tb_trade_detail:persion_id  下家标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer element;	//tb_trade_detail:element  元素  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Long efee;	//tb_trade_detail:efee  金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date gmtCreated;	//tb_trade_detail:gmt_created  新增时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date gmtModify;	//tb_trade_detail:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_trade_detail:detail_id
	* @Description: 获取属性        交易详情标识
	* @return: String
	*/
	public String getDetailId(){
		return detailId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:detail_id
	* @Description: 设置属性        交易详情标识
	* @return: String
	*/
	public void setDetailId(String detailId){
		this.detailId = detailId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:trade_id
	* @Description: 获取属性        交易流水
	* @return: String
	*/
	public String getTradeId(){
		return tradeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:trade_id
	* @Description: 设置属性        交易流水
	* @return: String
	*/
	public void setTradeId(String tradeId){
		this.tradeId = tradeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:stage_id
	* @Description: 获取属性        期别标识
	* @return: String
	*/
	public String getStageId(){
		return stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:stage_id
	* @Description: 设置属性        期别标识
	* @return: String
	*/
	public void setStageId(String stageId){
		this.stageId = stageId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:persion_id
	* @Description: 获取属性        下家标识
	* @return: String
	*/
	public String getPersionId(){
		return persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:persion_id
	* @Description: 设置属性        下家标识
	* @return: String
	*/
	public void setPersionId(String persionId){
		this.persionId = persionId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:element
	* @Description: 获取属性        元素
	* @return: Integer
	*/
	public Integer getElement(){
		return element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:element
	* @Description: 设置属性        元素
	* @return: Integer
	*/
	public void setElement(Integer element){
		this.element = element;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:efee
	* @Description: 获取属性        金额
	* @return: Long
	*/
	public Long getEfee(){
		return efee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:efee
	* @Description: 设置属性        金额
	* @return: Long
	*/
	public void setEfee(Long efee){
		this.efee = efee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_trade_detail:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


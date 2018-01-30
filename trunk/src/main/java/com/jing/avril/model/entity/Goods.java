package com.jing.avril.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ClassName: Goods
 * @Description: 分组信息实体类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年08月02日 14时22分
 */
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//tb_goods:goods_id  分组标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsName;	//tb_goods:goods_name  分组名称  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=4, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsKey;	//tb_goods:goods_key  快捷输入代码  

	private Integer goodsBack;	//tb_goods:goods_back  包号返水  

	private Integer goodsBonus;	//tb_goods:goods_bonus  包号倍率  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsNote;	//tb_goods:goods_note  说明  

	private Date gmtCreated;	//tb_goods:gmt_created  新增时间  

	private Date gmtModify;	//tb_goods:gmt_modify  修订时间  

	/**
	* @DatabasetableColumnName: tb_goods:goods_id
	* @Description: 获取属性        分组标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_id
	* @Description: 设置属性        分组标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_name
	* @Description: 获取属性        分组名称
	* @return: String
	*/
	public String getGoodsName(){
		return goodsName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_name
	* @Description: 设置属性        分组名称
	* @return: String
	*/
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_key
	* @Description: 获取属性        快捷输入代码
	* @return: String
	*/
	public String getGoodsKey(){
		return goodsKey;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_key
	* @Description: 设置属性        快捷输入代码
	* @return: String
	*/
	public void setGoodsKey(String goodsKey){
		this.goodsKey = goodsKey;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_back
	* @Description: 获取属性        包号返水
	* @return: Integer
	*/
	public Integer getGoodsBack(){
		return goodsBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_back
	* @Description: 设置属性        包号返水
	* @return: Integer
	*/
	public void setGoodsBack(Integer goodsBack){
		this.goodsBack = goodsBack;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_bonus
	* @Description: 获取属性        包号倍率
	* @return: Integer
	*/
	public Integer getGoodsBonus(){
		return goodsBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_bonus
	* @Description: 设置属性        包号倍率
	* @return: Integer
	*/
	public void setGoodsBonus(Integer goodsBonus){
		this.goodsBonus = goodsBonus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_note
	* @Description: 获取属性        说明
	* @return: String
	*/
	public String getGoodsNote(){
		return goodsNote;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:goods_note
	* @Description: 设置属性        说明
	* @return: String
	*/
	public void setGoodsNote(String goodsNote){
		this.goodsNote = goodsNote;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:gmt_created
	* @Description: 获取属性        新增时间
	* @return: Date
	*/
	public Date getGmtCreated(){
		return gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:gmt_created
	* @Description: 设置属性        新增时间
	* @return: Date
	*/
	public void setGmtCreated(Date gmtCreated){
		this.gmtCreated = gmtCreated;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:gmt_modify
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getGmtModify(){
		return gmtModify;	
	}
	
	/**
	* @DatabasetableColumnName: tb_goods:gmt_modify
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;	
	}
	
	
	
	
	
}


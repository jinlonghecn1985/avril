package com.jing.avril.controller.bo;

import java.util.List;

import com.jing.avril.model.entity.Persion;
import com.jing.avril.model.entity.Trade;

/**
 * @ClassName: TradeBo
 * @Description: 快捷输入参数
 * @author: 
 * @date: 2017年7月13日 下午2:25:51
 */
public class TradeBo {
	
	private String stageId;	//期号
	private String stageName;
	private String persionId;	//人员
	private String persionName;
	private String optCode;	//输入
	private String batchCode;	//批号
	private Float totalFeef;	//总交易额
	private List<Trade> tradeList;	//交易
	private Persion persion; //人员信息
	
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getPersionId() {
		return persionId;
	}
	public void setPersionId(String persionId) {
		this.persionId = persionId;
	}
	public String getPersionName() {
		return persionName;
	}
	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}
	public String getOptCode() {
		return optCode;
	}
	public void setOptCode(String optCode) {
		this.optCode = optCode;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public List<Trade> getTradeList() {
		return tradeList;
	}
	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}
	public Float getTotalFeef() {
		return totalFeef;
	}
	public void setTotalFeef(Float totalFeef) {
		this.totalFeef = totalFeef;
	}
	public Persion getPersion() {
		return persion;
	}
	public void setPersion(Persion persion) {
		this.persion = persion;
	}

}

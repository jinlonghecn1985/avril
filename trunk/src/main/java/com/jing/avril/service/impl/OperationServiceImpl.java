package com.jing.avril.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.avril.controller.bo.TradeBo;
import com.jing.avril.model.dao.DictionaryMapper;
import com.jing.avril.model.dao.ElementsMapper;
import com.jing.avril.model.dao.GoodsElementMapper;
import com.jing.avril.model.dao.GoodsMapper;
import com.jing.avril.model.dao.PersionDetailMapper;
import com.jing.avril.model.dao.PersionMapper;
import com.jing.avril.model.dao.StageDetailMapper;
import com.jing.avril.model.dao.StageMapper;
import com.jing.avril.model.dao.TradeDetailMapper;
import com.jing.avril.model.dao.TradeMapper;
import com.jing.avril.model.entity.Dictionary;
import com.jing.avril.model.entity.Elements;
import com.jing.avril.model.entity.Goods;
import com.jing.avril.model.entity.GoodsElement;
import com.jing.avril.model.entity.PersionDetail;
import com.jing.avril.model.entity.Stage;
import com.jing.avril.model.entity.StageDetail;
import com.jing.avril.model.entity.Trade;
import com.jing.avril.model.entity.TradeDetail;
import com.jing.avril.service.GoodsElementService;
import com.jing.avril.service.GoodsService;
import com.jing.avril.service.OperationService;
import com.jing.avril.service.PersionDetailService;
import com.jing.avril.service.StageService;
import com.jing.avril.service.StatisticsService;
import com.jing.avril.service.TradeDetailService;
import com.jing.avril.service.TradeService;
import com.jing.avril.util.AvrilUtil;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.utils.StringUtil;

/**
 * @ClassName: Dictionary
 * @Description: 字典信息服务实现类
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月27日 17时26分
 */
@Service("operationService")
@Transactional(readOnly=true)
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	private StageDetailMapper stageDetailMapper;

	@Autowired
	private ElementsMapper elementsMapper;

	@Autowired
	private GoodsElementMapper goodsElementMapper;

	@Autowired
	private GoodsElementService goodsElementService;

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private PersionMapper persionMapper;
	
	@Autowired
	private PersionDetailService persionDetailService;

	@Autowired
	private StageMapper stageMapper;
	
	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Autowired
	private TradeMapper tradeMapper;
	
	@Autowired
	private TradeService  tradeService ;
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired
	private AvrilUtil avrilUtil;
	
	@Autowired
	private TradeDetailMapper tradeDetailMapper;
	
	@Autowired
	private PersionDetailMapper persionDetailMapper;
	
	private static String TRADE_MULTI = "/";//多个操作代码分隔符
	
	private static String TRADE_PLUS  = "+";//加
	private static String TRADE_REDUCE  = "-";//减
	
	private static String TRADE_SINGLE  = "*";//单号操作	
	private static String TRADE_AND = "\\.";//输入 与符号
	private static String TRADE_TO = "*";//输入 到符号

	@Override
	@Transactional(readOnly = false)
	public int clearAllConfig() {
		tradeDetailMapper.clearTableData();	
		persionDetailMapper.clearTableData();
		stageDetailMapper.clearTableData();
		tradeMapper.clearTableData();	
		
		persionMapper.clearTableData();
		stageMapper.clearTableData();
		
		goodsElementMapper.clearTableData();
		goodsMapper.clearTableData();		
		elementsMapper.clearTableData();
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int justDestructSystem() {
		dictionaryMapper.clearTableData();
		
		tradeDetailMapper.clearTableData();	
		persionDetailMapper.clearTableData();
		stageDetailMapper.clearTableData();
		tradeMapper.clearTableData();	
		
		persionMapper.clearTableData();
		stageMapper.clearTableData();
		
		goodsElementMapper.clearTableData();
		goodsMapper.clearTableData();		
		elementsMapper.clearTableData();
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int dropStage(String stageId) {
		tradeDetailMapper.clearDataOnStageId(stageId);
		persionDetailMapper.clearDataOnStageId(stageId);
		stageDetailMapper.clearDataOnStageId(stageId);
		tradeMapper.clearDataOnStageId(stageId);	
		stageMapper.dropStageByStageId(stageId);
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public Object initSystem() throws Exception {
		clearAllConfig();
		Map<String, Object> ret = new HashMap<String, Object>();

		String[] zodiacs = new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };// 备用，混淆
		int max = 0; //码数
		String zodiac = ""; //生肖
		int offerset = 0; //位移
		
		int bonus = 410; //正常倍率
		int bonus2 = 0; //包数倍率
		int back = 13; //正常返利
		int back2 = 2;	//包数返利
		int qkey = 0; //快捷输入编号
		String zodiacBonus="";
		String zodiacBack = "";

		Map<String, Object> query = new HashMap<String, Object>();
		// 基础配置
		query.put("dicGroup", "config");
		List<Dictionary> dicList = dictionaryMapper.queryDictionaryByProperty(query);
		for (Dictionary dic : dicList) {
			if ("maxNum".equals(dic.getDicCode())) {
				max = Integer.parseInt(dic.getDicValue());
				qkey = max + 1;
				//ret.put("maxNum", max);
			} else if ("zodiac".equals(dic.getDicCode())) {
				zodiac = dic.getDicValue();
				zodiacBonus = dic.getDicBonus();
				zodiacBack = dic.getDicBack();
				//ret.put("zodiac", zodiac);
			} else if ("cool".equals(dic.getDicCode())) {
				offerset = Integer.parseInt(dic.getDicValue());
				//ret.put("cool", offerset);
			} else if ("backrate".equals(dic.getDicCode())) {
				back = Integer.parseInt(dic.getDicValue());
				//ret.put("backrate", back);
			} else if ("backrate2".equals(dic.getDicCode())) {
				back2 = Integer.parseInt(dic.getDicValue());
				//ret.put("backrate2", back);
			} else if ("bonus".equals(dic.getDicCode())) {
				bonus = Integer.parseInt(dic.getDicValue());
				//ret.put("bonus", bonus);
			}
		}
		// 码号配置落实
		Map<String, String> eleMap = new HashMap<String, String>();
		for (int i = 1; i <= max; i++) {
			Elements elements = new Elements();
			elements.setElement(i);
			elementsMapper.addElements(elements); // 码号
			
			Goods goods = new Goods();
			goods.setGoodsName("" + i);
			goods.setGoodsKey("" + i);
			goods.setGoodsNote("基本号");
//			goods.setGoodsBonus(bonus); //倍率与返点设置
//			goods.setGoodsBack(back);			
			goods = goodsService.addGoods(goods); //添加分类
			GoodsElement goodsElement = new GoodsElement();
			goodsElement.setGoodsId(goods.getGoodsId());
			goodsElement.setElementId(i);
			goodsElementMapper.addGoodsElement(goodsElement); //添加分类码号
			
		}
		
		//生肖码号对应关系
		for (int j = max; j > 0; j--) {
			String key = zodiacs[(max - j + offerset) % zodiacs.length]; // 基本分类
			if (eleMap.containsKey(key)) {
				eleMap.put(key, eleMap.get(key) + "," + j);
			} else {
				eleMap.put(key, "" + j);
			}
		}
		for (int k = 0; k < zodiacs.length; k++) {
			Goods goods = new Goods();
			goods.setGoodsName(zodiacs[k]);
			goods.setGoodsNote("生肖");
			goods.setGoodsKey("" + qkey++);
			if(zodiacBonus!=null && zodiacBonus.length()>0 && !"0".equals(zodiacBonus)){
				goods.setGoodsBonus(Integer.parseInt(zodiacBonus));
				if(zodiacBack!=null && zodiacBack.length()>0 && !"0".equals(zodiacBack)){
					goods.setGoodsBack(Integer.parseInt(zodiacBack));
				}else{
					goods.setGoodsBack(back2);
				}
			}
			ret.put(zodiacs[k], eleMap.get(zodiacs[k]));
			bindGoods(goods, eleMap.get(zodiacs[k])); // 基本元素分类信息
		}

		// 一级配置
		query.put("dicGroup", "config_ele");
		List<Dictionary> eleList = dictionaryMapper.queryDictionaryByProperty(query);
		for (Dictionary dic : eleList) {
			Goods goods = new Goods();
			goods.setGoodsName(dic.getDicCode());
			goods.setGoodsKey("" + qkey++);
			goods.setGoodsNote(dic.getDicNote());
			//ret.put(dic.getDicCode(), dic.getDicValue());
			zodiacBonus = dic.getDicBonus();
			zodiacBack = dic.getDicBack();
			if(zodiacBonus!=null && zodiacBonus.length()>0 && !"0".equals(zodiacBonus)){
				goods.setGoodsBonus(Integer.parseInt(zodiacBonus));
				if(zodiacBack!=null && zodiacBack.length()>0 && !"0".equals(zodiacBack)){
					goods.setGoodsBack(Integer.parseInt(zodiacBack));
				}else{
					goods.setGoodsBack(back2);
				}
			}
			bindGoods(goods, dic.getDicValue());
		}
		// 二级配置
		query.put("dicGroup", "config_ele_group");
		List<Dictionary> eleGroupDicList = dictionaryMapper.queryDictionaryByProperty(query);
		for (Dictionary dic : eleGroupDicList) {
			Goods goods = new Goods();
			goods.setGoodsName(dic.getDicCode());
			goods.setGoodsKey("" + qkey++);
			goods.setGoodsNote(dic.getDicNote());
			zodiacBonus = dic.getDicBonus();
			zodiacBack = dic.getDicBack();
			if(zodiacBonus!=null && zodiacBonus.length()>0 && !"0".equals(zodiacBonus)){
				goods.setGoodsBonus(Integer.parseInt(zodiacBonus));
				if(zodiacBack!=null && zodiacBack.length()>0 && !"0".equals(zodiacBack)){
					goods.setGoodsBack(Integer.parseInt(zodiacBack));
				}else{
					goods.setGoodsBack(back2);
				}
			}
			goodsService.addGoods(goods);
			String dicV = dic.getDicValue();
			dicV = dicV.replaceAll(",", "' ,'");
			dicV +="'";
			goodsElementMapper.addGoodsElementsBatch(goods.getGoodsId(), "'"+dicV);
		}		
		avrilUtil.reloadData();
		return ret;
	}
	
	

	@Override
	public int loadOtherConfig() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	private Integer bindGoods(Goods goods, String goodsElements){		
		if(goods.getGoodsId()!=null){
			goodsService.modifyGoods(goods);
			goodsElementMapper.dropGoodsElementByGoodsId(goods.getGoodsId());
		}else{
			goods = goodsService.addGoods(goods);
		}
		if(goods.getGoodsId()!=null && goodsElements!=null){
			goodsElements = goodsElements.replace("，", ",");
			String[] gds = goodsElements.split(",");
			for(int i=0; i<gds.length; i++){
				GoodsElement goodsElement = new GoodsElement();
				goodsElement.setGoodsId(goods.getGoodsId());
				goodsElement.setElementId(Integer.parseInt(gds[i]));
				goodsElementMapper.addGoodsElement(goodsElement);
			}
		}
		return 1;
	}
	
	@Override
	@Transactional(readOnly = false)
	public TradeBo addTradeBo(TradeBo tradeBo) {
		String optCode = tradeBo.getOptCode();
		optCode = StringUtil.ToDBC(optCode); //全角转半角
		optCode = optCode.replaceAll(" ", "");//去空格
		
		//处理特殊代码
		if(doSpecialCode(tradeBo.getStageId(), tradeBo.getPersionId(), optCode)){
			tradeBo.setTotalFeef(0f);
			return tradeBo;
		}
		//tradeBo.setBatchCode(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()); //批次号
		//正常操作
		String[] trades = optCode.split(TRADE_MULTI);//操作码拆分
		for(int i=0; i<trades.length; i++){			
			int ind = trades[i].indexOf(TRADE_PLUS)==-1?trades[i].indexOf(TRADE_REDUCE):trades[i].indexOf(TRADE_PLUS);
			if(ind==-1){				
				//continue;//无输入终止符，不与分析
				throw new ParameterException(trades[i]+" 快捷输入错误：无输入终止符("+TRADE_PLUS+"或"+TRADE_REDUCE+")，不予分析。");
			}
			
			//格式验证
			String t1 = trades[i].substring(0, ind);
			String t2 = trades[i].substring(ind+1);
			if(t1==null || t1.length()==0){
				//continue;//数据项拆分后错误
				throw new ParameterException(trades[i]+" 快捷输入错误：拆分后快捷键为空，不予分析。");
			}
			if(t2==null || t2.length()==0 || t2.equals(TRADE_SINGLE)){
				//continue;//数据项拆分后错误
				throw new ParameterException(trades[i]+" 快捷输入错误：拆分后金额为空，不予分析。");
			}
			Long bill = 0l;
			try{
				bill = Long.parseLong(t2.startsWith(TRADE_SINGLE)?t2.substring(1):t2);
			}catch(Exception e){
				throw new ParameterException(trades[i]+" 快捷输入错误：拆分后金额格式错误，不予分析。");
			}
			
			//分析快捷键
			System.out.println(trades[i]+">>>"+t1+"      "+t2);			
			String[] codes = t1.split(TRADE_AND);
			List<String> clist = new ArrayList<String>();
			for(int j=0; j<codes.length; j++){
				int toInd = codes[j].indexOf(TRADE_TO);//到符号位置
				if(toInd==-1){
					if(codes[j].startsWith("0")){
						codes[j] = codes[j].substring(1); //去首位0
					}
					clist.add(codes[j]);
				}else{
					try{
						String f = codes[j].substring(0, toInd);
						if(f.startsWith("0")){//去首位0
							f = f.substring(1);
						}
						String t = codes[j].substring(toInd+1);
						if(t.startsWith("0")){//去首位0
							t = t.substring(1);
						}
						int startNum = Integer.parseInt(f);
						int endNum = Integer.parseInt(t);
						clist.add(startNum+"");
						while(startNum<endNum){
							clist.add(++startNum+"");
						}
					}catch(Exception e){
						throw new ParameterException(trades[i]+" 快捷输入错误："+codes[j]+"无法解析，不予分析。");
					}
				}
			}
			//统计-整合
			List<Goods> saveGoods = new ArrayList<Goods>(); //组别存放
			Integer eleCount = 0;	//总数统计
			Map<String, List<GoodsElement>> saveElement = new HashMap<String, List<GoodsElement>>(); //号码存放
			int eleCounts = 0;
			for(int k=0; k<clist.size(); k++){
				if(avrilUtil.goodsMap.containsKey(clist.get(k))){
					List<GoodsElement> temp = avrilUtil.goodsElementMap.get(clist.get(k));
					if(temp==null || temp.size()==0){
						throw new ParameterException(trades[i]+"快捷输入错误："+clist.get(k)+"无法解析到对应基本号码，不予分析。");
					}
					saveGoods.add(avrilUtil.goodsMap.get(clist.get(k)));
					saveElement.put(clist.get(k), temp);
					eleCount+= temp.size();
				}else{
					throw new ParameterException(trades[i]+" 快捷输入错误："+clist.get(k)+"非快捷代码，不予分析。");
				}
			}
//			if(saveGoods==null || saveGoods.size()==0 || saveElement==null || eleCount==0){
//				throw new ParameterException(trades[i]+" 快捷输入错误：快捷代码无法解析到对应基本号码，不予分析。");
//			}
			//计算单、总金额
			Long total = 0l;
			Long single = 0l;
			if(t2.startsWith(TRADE_SINGLE)){
				total = (Long) (bill*eleCount);
				single = (Long) bill;				
			}else{
				//4舍5入取整
//				total = (float) bill;
//				single = (float)(Math.round(total/eleCount));
//				total = single*eleCount;
				//取2位小数
//				BigDecimal d = new BigDecimal((Long)bill/eleCount); 
//				single = d.setScale(2, bill/eleCount).floatValue(); 
				single = bill/eleCount;
				total = single*eleCount;
			}	
			if(trades[i].indexOf(TRADE_REDUCE)!=-1){
				total = 0-total;
				single = 0-single;
			}
			System.out.println(clist.size()+"组有元素："+eleCount+"共"+total+"元-单号"+single);
			//存储组别信息
			List<Trade> retTrade = new ArrayList<Trade>();
			for(Goods sg : saveGoods){
				Trade tr = new Trade();
				List<GoodsElement> tempList = saveElement.get(sg.getGoodsKey());
				tr.setFee(single*tempList.size());				
				tr.setGoodsId(sg.getGoodsId());
				if(sg.getGoodsBonus()!=null && sg.getGoodsBonus()>0){
					//比例
					tr.setSfee(tr.getFee());
					tr.setBack(tr.getFee()*tradeBo.getPersion().getPercentRate()/100);
				}else{
					//非比例
					tr.setSfee(single);
					tr.setBack(tr.getFee()*tradeBo.getPersion().getRatioRate()/100);
				}
				tr.setPersionId(tradeBo.getPersionId());
				tr.setStageId(tradeBo.getStageId());
//				tr.setStatus(0);
				tr.setTradeCode(trades[i]);//tradeBo.getBatchCode());
				tradeBo.setTotalFeef(tr.getFee()+(tradeBo.getTotalFeef()==null?0f:tradeBo.getTotalFeef()));
				retTrade.add(tradeService.addTrade(tr));
				
				//存储元素详情 
				for(GoodsElement sge : tempList){
					TradeDetail td = new TradeDetail();
					td.setTradeId(tr.getTradeId());
					td.setEfee(single);
					td.setElement(sge.getElementId());
					td.setPersionId(tradeBo.getPersionId());
					td.setStageId(tradeBo.getStageId());
					tradeDetailService.addTradeDetail(td);
				}				
			}
			tradeBo.setTradeList(retTrade);
		}
		calculationStage(tradeBo.getStageId()); //计算
		return tradeBo;
	}
	
	/** 
	* @Title: doSpecialCode 
	* @Description: 特殊代码处理
	* @param stageId
	* @param persionId
	* @param optCode
	* @return  boolean    返回类型 
	* @throws 
	*/
	private boolean doSpecialCode(String stageId, String persionId, String optCode){
//		if("000000".equals(optCode)){
//			tradeMapper.deleteTradeBySP(stageId, persionId);
//			return true;
//		}
		//publicService
		System.out.println("doSpecialCode");
		return false;
	}
	
	/** 
	* @Title: makeStage 
	* @Description: 期别整体计算
	* @param stageId
	* @return  Object    返回类型 
	* @throws 
	*/
	@Override
	@Transactional(readOnly = false)
	public Object calculationStage(String stageId){
		//获取期别信息
		Stage stage = stageMapper.queryStageByStageId(stageId);
		if(stage==null || stage.getStageName()==null){
			throw new NotFoundException("分组信息");
		}
		stage.setGmtCreated(null);
		stage.setGmtModify(null);
		
		//获取下家总额		
		Map<String, Object> qbill = tradeMapper.queryPersionTotalFeeBackOnStageID(stageId, null);
		Long ttb = ((java.math.BigDecimal)qbill.get("fee")).longValue();
		Long tbb = ((java.math.BigDecimal)qbill.get("back")).longValue();
		//更新下家总额及返水总额
		stage.setStageBill(ttb);
		stage.setStageBack(tbb);
		
		Long risk = (stage.getStageRisk().longValue()+ttb-tbb)/avrilUtil.maxNum;//风险金结果
		//获取下家总量
		Map<Integer, Long> eleDetail = queryElementDetail(stage.getStageId(), null);
		//获取上报数据
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("stageId", stageId);
		List<StageDetail> stageDetailList = stageDetailMapper.queryStageDetailByProperty(query);
		Long srisk = 0L;
		for(StageDetail sd : stageDetailList){
			if(sd.getUpbill().longValue()>risk.longValue()){
				sd.setUpbill(sd.getUpbill());
			}else if(risk.longValue()<eleDetail.get(sd.getElement())){
				sd.setUpbill(eleDetail.get(sd.getElement())-risk.longValue());
			}else{
				sd.setUpbill(0L);
			}
			stageDetailMapper.modifyStageDetail(sd);
			srisk += sd.getUpbill().longValue();
		}
		//设置上报及返水
		stage.setUpBill(srisk);
		stage.setUpBack(srisk.longValue()*avrilUtil.upBackRate/100);		
		stageMapper.modifyStage(stage);		
		return stage;
	}
	
	
	/** 
	* @Title: terminatorStage 
	* @Description: 期号结算
	* @param stageId
	* @return  Object    返回类型 
	* @throws 
	*/
	@Override
	@Transactional(readOnly = false)
	public Object terminatorStage(String stageId){
		
		
		Stage stage = stageMapper.queryStageByStageId(stageId);
		if(stage==null || stage.getElement()==null || stage.getElement().intValue()<0){
			throw new NotFoundException("分组信息特号没有设置");
		}
		
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("stageId", stageId);
		query.put("element", stage.getElement());
		List<StageDetail> stageDetailList = stageDetailMapper.queryStageDetailByProperty(query);
		if(stageDetailList==null || stageDetailList.size()!=1){
			throw new NotFoundException("上报信息");
		}
		
		
		
		StageDetail stageDetail = stageDetailList.get(0);
		stage.setStageGift(stageDetail.getUpbill()*avrilUtil.backBonus); //设置上家
		//获取所有中奖分组
		List<Goods> bonusGoodsList = goodsService.queryGoodsByElementId(stage.getElement());
		Map<String, Goods> bonusMap = new HashMap<String, Goods>();
		for(Goods goods : bonusGoodsList){
			bonusMap.put(goods.getGoodsId(), goods);
		}
		
		tradeMapper.resetBonusZore(stageId);
		
		//计算下家
		Long totalBonus = 0l;//总奖金
		query.clear();
		query.put("stageId", stageId);
		List<PersionDetail> pdList = persionDetailMapper.queryPersionDetailByProperty(query);
		//取出当期所有下家信息 一一计算
		if(pdList!=null && pdList.size()>0){
			for(PersionDetail pd : pdList){
				Long persionBonus = queryBonusByStageIdPersionId(bonusMap, stageId, pd.getPersionId(), stage.getElement());
				totalBonus += persionBonus;
				pd.setBonusMoney(persionBonus);
				pd.setBalance(pd.getTotalMoney()-pd.getBackMoney()-pd.getBonusMoney());
				persionDetailService.modifyPersionDetail(pd);
//				PersionDetail persionDetail = new PersionDetail();
//				persionDetail.setBonusMoney(persionBonus);
//				persionDetail.setPersionId(pd.getPersionId());
//				persionDetail.setStageId(stage.getStageId());
//				persionDetailService.modifyPersionDetailByStagePerion(persionDetail);
			}
		}
		stage.setStageGift(totalBonus); 
		stage.setBalance(stage.getStageBill()-stage.getStageBack()-stage.getStageGift()-stage.getUpBill()+stage.getUpBack()+stage.getUpGift());
		stageMapper.modifyStage(stage);
		return stage;
	}
	
	private Long queryBonusByStageIdPersionId(Map<String, Goods> bonusMap, String stageId, String persionId, Integer elementBonus){
		Long ret = 0l;
		List<Trade> tradeList = tradeService.queryBonusTradeByElement(elementBonus, stageId, persionId);
		if(tradeList!=null && tradeList.size()>0){
			for(Trade trade: tradeList){
				if(bonusMap.containsKey(trade.getGoodsId())){
					//中奖
					Goods goods = bonusMap.get(trade.getGoodsId());
					Long bonus = 0l;
					if(goods.getGoodsBonus()!=null && goods.getGoodsBonus().intValue()>0){
						//特殊倍率
						bonus = trade.getSfee()*goods.getGoodsBonus()/100;						
					}else{
						//正常倍率
						bonus = trade.getFee()*avrilUtil.backBonus;
					}
					trade.setBonus(bonus);					
					tradeService.modifyTrade(trade);//更新数据
					ret +=bonus;
				}
			}
		}		
		return ret;
	}
	
	
	
	/** 
	* @Title: queryElementDetail 
	* @Description: 获取期号或用户购买详情，包括0
	* @param stageId
	* @param persionId
	* @return  Map<Integer,Long>    返回类型 
	* @throws 
	*/
	private Map<Integer, Long> queryElementDetail(String stageId, String persionId){
		Map<String, Object> query = new HashMap<String, Object>();
		
		query.put("stageId", stageId);
		if(persionId!=null && persionId.length()>0){
			query.put("persionId", persionId);
		}
		Map<Integer, Long> ret = new HashMap<Integer, Long>();
		List<Map<String, Object>> tdlist = statisticsService.queryTradeDetailStatistics(query);
		for(Map<String, Object> td : tdlist){
			ret.put((Integer)td.get("element"), ((java.math.BigDecimal)td.get("efee")).longValue());
		}
		return ret;
	}
}

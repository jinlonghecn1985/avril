package com.jing.avril.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.avril.model.entity.Trade;
import com.jing.avril.service.TradeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TradeController
 * @Description: 交易总情况HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="交易总情况")
public class TradeController{
	
	@Autowired
	private TradeService tradeService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加交易总情况信息", notes = "添加交易总情况信息")
	@RequestMapping(value = "/trade", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTrade(HttpServletResponse response,
			@ApiParam(value = "trade") @RequestBody Trade trade) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(trade, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		trade.setTradeId(null);
		tradeService.addTrade(trade);
		return trade;
	}
	
	
	@ApiOperation(value = "更新 根据交易总情况标识更新交易总情况信息", notes = "根据交易总情况标识更新交易总情况信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.PUT)
	public Object modifyTradeById(HttpServletResponse response,
			@PathVariable String tradeId,
			@ApiParam(value = "trade", required = true) @RequestBody Trade trade
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(trade, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Trade tempTrade = tradeService.queryTradeByTradeId(tradeId);
		trade.setTradeId(tradeId);
		if(null == tempTrade){
			throw new NotFoundException("交易总情况");
		}
		return tradeService.modifyTrade(trade);
	}

	@ApiOperation(value = "删除 根据交易总情况标识删除交易总情况信息", notes = "根据交易总情况标识删除交易总情况信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.DELETE)
	public Object dropTradeByTradeId(HttpServletResponse response, @PathVariable String tradeId) {
		Trade trade = tradeService.queryTradeByTradeId(tradeId);
		if(null == trade){
			throw new NotFoundException("交易总情况");
		}
		return tradeService.dropTradeByTradeId(tradeId);
	}
	
	@ApiOperation(value = "查询 根据交易总情况标识查询交易总情况信息", notes = "根据交易总情况标识查询交易总情况信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.GET)
	public Object queryTradeById(HttpServletResponse response,
			@PathVariable String tradeId) {
		Trade trade = tradeService.queryTradeByTradeId(tradeId);
		if(null == trade){
			throw new NotFoundException("交易总情况");
		}
		return trade;
	}
	
	@ApiOperation(value = "查询分页 根据交易总情况属性分页查询交易总情况信息列表", notes = "根据交易总情况属性分页查询交易总情况信息列表")
	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	public Object queryTradePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Trade trade) {				
		return tradeService.queryTradeForPage(pagenum, pagesize, sort, trade);
	}

}

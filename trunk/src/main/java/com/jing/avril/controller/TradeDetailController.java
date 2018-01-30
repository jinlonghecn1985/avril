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
import com.jing.avril.model.entity.TradeDetail;
import com.jing.avril.service.TradeDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TradeDetailController
 * @Description: 交易详细码号情况HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="交易详细码号情况")
public class TradeDetailController{
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加交易详细码号情况信息", notes = "添加交易详细码号情况信息")
	@RequestMapping(value = "/tradeDetail", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTradeDetail(HttpServletResponse response,
			@ApiParam(value = "tradeDetail") @RequestBody TradeDetail tradeDetail) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(tradeDetail, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		tradeDetail.setDetailId(null);
		tradeDetailService.addTradeDetail(tradeDetail);
		return tradeDetail;
	}
	
	
	@ApiOperation(value = "更新 根据交易详细码号情况标识更新交易详细码号情况信息", notes = "根据交易详细码号情况标识更新交易详细码号情况信息")
	@RequestMapping(value = "/tradeDetail/{detailId:.+}", method = RequestMethod.PUT)
	public Object modifyTradeDetailById(HttpServletResponse response,
			@PathVariable String detailId,
			@ApiParam(value = "tradeDetail", required = true) @RequestBody TradeDetail tradeDetail
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(tradeDetail, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TradeDetail tempTradeDetail = tradeDetailService.queryTradeDetailByDetailId(detailId);
		tradeDetail.setDetailId(detailId);
		if(null == tempTradeDetail){
			throw new NotFoundException("交易详细码号情况");
		}
		return tradeDetailService.modifyTradeDetail(tradeDetail);
	}

	@ApiOperation(value = "删除 根据交易详细码号情况标识删除交易详细码号情况信息", notes = "根据交易详细码号情况标识删除交易详细码号情况信息")
	@RequestMapping(value = "/tradeDetail/{detailId:.+}", method = RequestMethod.DELETE)
	public Object dropTradeDetailByDetailId(HttpServletResponse response, @PathVariable String detailId) {
		TradeDetail tradeDetail = tradeDetailService.queryTradeDetailByDetailId(detailId);
		if(null == tradeDetail){
			throw new NotFoundException("交易详细码号情况");
		}
		return tradeDetailService.dropTradeDetailByDetailId(detailId);
	}
	
	@ApiOperation(value = "查询 根据交易详细码号情况标识查询交易详细码号情况信息", notes = "根据交易详细码号情况标识查询交易详细码号情况信息")
	@RequestMapping(value = "/tradeDetail/{detailId:.+}", method = RequestMethod.GET)
	public Object queryTradeDetailById(HttpServletResponse response,
			@PathVariable String detailId) {
		TradeDetail tradeDetail = tradeDetailService.queryTradeDetailByDetailId(detailId);
		if(null == tradeDetail){
			throw new NotFoundException("交易详细码号情况");
		}
		return tradeDetail;
	}
	
	@ApiOperation(value = "查询分页 根据交易详细码号情况属性分页查询交易详细码号情况信息列表", notes = "根据交易详细码号情况属性分页查询交易详细码号情况信息列表")
	@RequestMapping(value = "/tradeDetails", method = RequestMethod.GET)
	public Object queryTradeDetailPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TradeDetail tradeDetail) {				
		return tradeDetailService.queryTradeDetailForPage(pagenum, pagesize, sort, tradeDetail);
	}

}

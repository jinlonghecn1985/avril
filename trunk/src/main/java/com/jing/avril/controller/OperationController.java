package com.jing.avril.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jing.avril.controller.bo.TradeBo;
import com.jing.avril.model.entity.Persion;
import com.jing.avril.service.OperationService;
import com.jing.avril.service.PersionService;
import com.jing.avril.service.StageService;
import com.jing.config.web.exception.ParameterException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: OperationController
 * @Description: 公共操作HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="公共操作")
@RequestMapping(value="/operation")
public class OperationController {

	
	@Autowired
	private OperationService operationService;
	@Autowired 
	private StageService stageService;
	@Autowired
	private PersionService persionService;
	
	@ApiOperation(value = "初始化系统", notes = "初始化系统")
	@RequestMapping(value = "/init", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object initSystem(HttpServletResponse response) throws Exception{			
		return operationService.initSystem();	
	}
	
	
	@ApiOperation(value = "新增 添加交易信息", notes = "添加交易信息")
	@RequestMapping(value = "/trades", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTradeBo(HttpServletResponse response,
			@ApiParam(value = "tradeBo") @RequestBody TradeBo tradeBo) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if(tradeBo.getOptCode()==null || tradeBo.getOptCode().length()<3){
			throw new ParameterException("optCode为空或长度小于3");
		}
		if(tradeBo==null || tradeBo.getStageId()==null || stageService.queryStageByStageId(tradeBo.getStageId())==null ){
			throw new ParameterException("stageId为空或找不到相应的期号");
		}		
		if(tradeBo.getPersionId()==null){	
			throw new ParameterException("persionId为空");
		}
		Persion persion = persionService.queryPersionByPersionId(tradeBo.getPersionId());
		if(persion==null || persion.getPersionKey()==null){
			throw new ParameterException("persionId为空或找不到相应的人员" );
		}
		tradeBo.setPersion(persion);
		return operationService.addTradeBo(tradeBo);
	}
	
	@ApiOperation(value = "结算", notes = "结算")
	@RequestMapping(value = "/terminator/{stageId}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object terminatorStage(HttpServletResponse response, @PathVariable String stageId) throws Exception{			
		return operationService.terminatorStage(stageId);
	}
}

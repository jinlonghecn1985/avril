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
import com.jing.avril.model.entity.StageDetail;
import com.jing.avril.service.StageDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: StageDetailController
 * @Description: 期号交易数据HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="期号交易数据")
public class StageDetailController{
	
	@Autowired
	private StageDetailService stageDetailService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加期号交易数据信息", notes = "添加期号交易数据信息")
	@RequestMapping(value = "/stageDetail", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addStageDetail(HttpServletResponse response,
			@ApiParam(value = "stageDetail") @RequestBody StageDetail stageDetail) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(stageDetail, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		stageDetail.setBillId(null);
		stageDetailService.addStageDetail(stageDetail);
		return stageDetail;
	}
	
	
	@ApiOperation(value = "更新 根据期号交易数据标识更新期号交易数据信息", notes = "根据期号交易数据标识更新期号交易数据信息")
	@RequestMapping(value = "/stageDetail/{billId:.+}", method = RequestMethod.PUT)
	public Object modifyStageDetailById(HttpServletResponse response,
			@PathVariable String billId,
			@ApiParam(value = "stageDetail", required = true) @RequestBody StageDetail stageDetail
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(stageDetail, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		StageDetail tempStageDetail = stageDetailService.queryStageDetailByBillId(billId);
		stageDetail.setBillId(billId);
		if(null == tempStageDetail){
			throw new NotFoundException("期号交易数据");
		}
		return stageDetailService.modifyStageDetail(stageDetail);
	}

	@ApiOperation(value = "删除 根据期号交易数据标识删除期号交易数据信息", notes = "根据期号交易数据标识删除期号交易数据信息")
	@RequestMapping(value = "/stageDetail/{billId:.+}", method = RequestMethod.DELETE)
	public Object dropStageDetailByBillId(HttpServletResponse response, @PathVariable String billId) {
		StageDetail stageDetail = stageDetailService.queryStageDetailByBillId(billId);
		if(null == stageDetail){
			throw new NotFoundException("期号交易数据");
		}
		return stageDetailService.dropStageDetailByBillId(billId);
	}
	
	@ApiOperation(value = "查询 根据期号交易数据标识查询期号交易数据信息", notes = "根据期号交易数据标识查询期号交易数据信息")
	@RequestMapping(value = "/stageDetail/{billId:.+}", method = RequestMethod.GET)
	public Object queryStageDetailById(HttpServletResponse response,
			@PathVariable String billId) {
		StageDetail stageDetail = stageDetailService.queryStageDetailByBillId(billId);
		if(null == stageDetail){
			throw new NotFoundException("期号交易数据");
		}
		return stageDetail;
	}
	
	@ApiOperation(value = "查询分页 根据期号交易数据属性分页查询期号交易数据信息列表", notes = "根据期号交易数据属性分页查询期号交易数据信息列表")
	@RequestMapping(value = "/stageDetails", method = RequestMethod.GET)
	public Object queryStageDetailPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, StageDetail stageDetail) {				
		return stageDetailService.queryStageDetailForPage(pagenum, pagesize, sort, stageDetail);
	}

}

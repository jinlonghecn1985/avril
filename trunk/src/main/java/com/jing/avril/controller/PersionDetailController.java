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
import com.jing.avril.model.entity.PersionDetail;
import com.jing.avril.service.PersionDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: PersionDetailController
 * @Description: 期别下家交易数据HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="期别下家交易数据")
public class PersionDetailController{
	
	@Autowired
	private PersionDetailService persionDetailService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加期别下家交易数据信息", notes = "添加期别下家交易数据信息")
	@RequestMapping(value = "/persionDetail", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addPersionDetail(HttpServletResponse response,
			@ApiParam(value = "persionDetail") @RequestBody PersionDetail persionDetail) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(persionDetail, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		persionDetail.setSpId(null);
		persionDetailService.addPersionDetail(persionDetail);
		return persionDetail;
	}
	
	
	@ApiOperation(value = "更新 根据期别下家交易数据标识更新期别下家交易数据信息", notes = "根据期别下家交易数据标识更新期别下家交易数据信息")
	@RequestMapping(value = "/persionDetail/{spId:.+}", method = RequestMethod.PUT)
	public Object modifyPersionDetailById(HttpServletResponse response,
			@PathVariable String spId,
			@ApiParam(value = "persionDetail", required = true) @RequestBody PersionDetail persionDetail
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(persionDetail, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		PersionDetail tempPersionDetail = persionDetailService.queryPersionDetailBySpId(spId);
		persionDetail.setSpId(spId);
		if(null == tempPersionDetail){
			throw new NotFoundException("期别下家交易数据");
		}
		return persionDetailService.modifyPersionDetail(persionDetail);
	}

	@ApiOperation(value = "删除 根据期别下家交易数据标识删除期别下家交易数据信息", notes = "根据期别下家交易数据标识删除期别下家交易数据信息")
	@RequestMapping(value = "/persionDetail/{spId:.+}", method = RequestMethod.DELETE)
	public Object dropPersionDetailBySpId(HttpServletResponse response, @PathVariable String spId) {
		PersionDetail persionDetail = persionDetailService.queryPersionDetailBySpId(spId);
		if(null == persionDetail){
			throw new NotFoundException("期别下家交易数据");
		}
		return persionDetailService.dropPersionDetailBySpId(spId);
	}
	
	@ApiOperation(value = "查询 根据期别下家交易数据标识查询期别下家交易数据信息", notes = "根据期别下家交易数据标识查询期别下家交易数据信息")
	@RequestMapping(value = "/persionDetail/{spId:.+}", method = RequestMethod.GET)
	public Object queryPersionDetailById(HttpServletResponse response,
			@PathVariable String spId) {
		PersionDetail persionDetail = persionDetailService.queryPersionDetailBySpId(spId);
		if(null == persionDetail){
			throw new NotFoundException("期别下家交易数据");
		}
		return persionDetail;
	}
	
	@ApiOperation(value = "查询分页 根据期别下家交易数据属性分页查询期别下家交易数据信息列表", notes = "根据期别下家交易数据属性分页查询期别下家交易数据信息列表")
	@RequestMapping(value = "/persionDetails", method = RequestMethod.GET)
	public Object queryPersionDetailPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, PersionDetail persionDetail) {				
		return persionDetailService.queryPersionDetailForPage(pagenum, pagesize, sort, persionDetail);
	}

}

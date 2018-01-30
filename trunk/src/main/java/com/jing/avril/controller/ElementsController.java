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
import com.jing.avril.model.entity.Elements;
import com.jing.avril.service.ElementsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ElementsController
 * @Description: 码号信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="码号信息")
public class ElementsController{
	
	@Autowired
	private ElementsService elementsService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加码号信息信息", notes = "添加码号信息信息")
	@RequestMapping(value = "/elements", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addElements(HttpServletResponse response,
			@ApiParam(value = "elements") @RequestBody Elements elements) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(elements, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		elements.setElement(null);
		elementsService.addElements(elements);
		return elements;
	}
	
	
	@ApiOperation(value = "更新 根据码号信息标识更新码号信息信息", notes = "根据码号信息标识更新码号信息信息")
	@RequestMapping(value = "/elements/{element:.+}", method = RequestMethod.PUT)
	public Object modifyElementsById(HttpServletResponse response,
			@PathVariable Integer element,
			@ApiParam(value = "elements", required = true) @RequestBody Elements elements
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(elements, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Elements tempElements = elementsService.queryElementsByElement(element);
		elements.setElement(element);
		if(null == tempElements){
			throw new NotFoundException("码号信息");
		}
		return elementsService.modifyElements(elements);
	}

	@ApiOperation(value = "删除 根据码号信息标识删除码号信息信息", notes = "根据码号信息标识删除码号信息信息")
	@RequestMapping(value = "/elements/{element:.+}", method = RequestMethod.DELETE)
	public Object dropElementsByElement(HttpServletResponse response, @PathVariable Integer element) {
		Elements elements = elementsService.queryElementsByElement(element);
		if(null == elements){
			throw new NotFoundException("码号信息");
		}
		return elementsService.dropElementsByElement(element);
	}
	
	@ApiOperation(value = "查询 根据码号信息标识查询码号信息信息", notes = "根据码号信息标识查询码号信息信息")
	@RequestMapping(value = "/elements/{element:.+}", method = RequestMethod.GET)
	public Object queryElementsById(HttpServletResponse response,
			@PathVariable Integer element) {
		Elements elements = elementsService.queryElementsByElement(element);
		if(null == elements){
			throw new NotFoundException("码号信息");
		}
		return elements;
	}
	
	@ApiOperation(value = "查询分页 根据码号信息属性分页查询码号信息信息列表", notes = "根据码号信息属性分页查询码号信息信息列表")
	@RequestMapping(value = "/elementss", method = RequestMethod.GET)
	public Object queryElementsPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Elements elements) {				
		return elementsService.queryElementsForPage(pagenum, pagesize, sort, elements);
	}

}

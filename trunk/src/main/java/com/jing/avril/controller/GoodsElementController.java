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
import com.jing.avril.model.entity.GoodsElement;
import com.jing.avril.service.GoodsElementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsElementController
 * @Description: 分组码号信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="分组码号信息")
public class GoodsElementController{
	
	@Autowired
	private GoodsElementService goodsElementService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加分组码号信息信息", notes = "添加分组码号信息信息")
	@RequestMapping(value = "/goodsElement", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoodsElement(HttpServletResponse response,
			@ApiParam(value = "goodsElement") @RequestBody GoodsElement goodsElement) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsElement, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goodsElement.setGoodsId(null);
		goodsElementService.addGoodsElement(goodsElement);
		return goodsElement;
	}
	
	
	@ApiOperation(value = "更新 根据分组码号信息标识更新分组码号信息信息", notes = "根据分组码号信息标识更新分组码号信息信息")
	@RequestMapping(value = "/goodsElement/{goodsId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsElementById(HttpServletResponse response,
			@PathVariable String goodsId,
			@ApiParam(value = "goodsElement", required = true) @RequestBody GoodsElement goodsElement
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsElement, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		List<GoodsElement> tempGoodsElement = goodsElementService.queryGoodsElementByGoodsId(goodsId);
		goodsElement.setGoodsId(goodsId);
		if(null == tempGoodsElement){
			throw new NotFoundException("分组码号信息");
		}
		return goodsElementService.modifyGoodsElement(goodsElement);
	}

	@ApiOperation(value = "删除 根据分组码号信息标识删除分组码号信息信息", notes = "根据分组码号信息标识删除分组码号信息信息")
	@RequestMapping(value = "/goodsElement/{goodsId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsElementByGoodsId(HttpServletResponse response, @PathVariable String goodsId) {
		List<GoodsElement> goodsElement = goodsElementService.queryGoodsElementByGoodsId(goodsId);
		if(null == goodsElement){
			throw new NotFoundException("分组码号信息");
		}
		return goodsElementService.dropGoodsElementByGoodsId(goodsId);
	}
	
	@ApiOperation(value = "查询 根据分组码号信息标识查询分组码号信息信息", notes = "根据分组码号信息标识查询分组码号信息信息")
	@RequestMapping(value = "/goodsElement/{goodsId:.+}", method = RequestMethod.GET)
	public Object queryGoodsElementById(HttpServletResponse response,
			@PathVariable String goodsId) {
		List<GoodsElement> goodsElement = goodsElementService.queryGoodsElementByGoodsId(goodsId);
		if(null == goodsElement){
			throw new NotFoundException("分组码号信息");
		}
		return goodsElement.get(0);
	}
	
	@ApiOperation(value = "查询分页 根据分组码号信息属性分页查询分组码号信息信息列表", notes = "根据分组码号信息属性分页查询分组码号信息信息列表")
	@RequestMapping(value = "/goodsElements", method = RequestMethod.GET)
	public Object queryGoodsElementPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, GoodsElement goodsElement) {				
		return goodsElementService.queryGoodsElementForPage(pagenum, pagesize, sort, goodsElement);
	}

}

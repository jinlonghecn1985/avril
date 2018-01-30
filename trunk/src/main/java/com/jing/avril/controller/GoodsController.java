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
import com.jing.avril.model.entity.Goods;
import com.jing.avril.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsController
 * @Description: 分组信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="分组信息")
public class GoodsController{
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加分组信息信息", notes = "添加分组信息信息")
	@RequestMapping(value = "/goods", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoods(HttpServletResponse response,
			@ApiParam(value = "goods") @RequestBody Goods goods) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goods, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goods.setGoodsId(null);
		goodsService.addGoods(goods);
		return goods;
	}
	
	
	@ApiOperation(value = "更新 根据分组信息标识更新分组信息信息", notes = "根据分组信息标识更新分组信息信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsById(HttpServletResponse response,
			@PathVariable String goodsId,
			@ApiParam(value = "goods", required = true) @RequestBody Goods goods
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goods, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Goods tempGoods = goodsService.queryGoodsByGoodsId(goodsId);
		goods.setGoodsId(goodsId);
		if(null == tempGoods){
			throw new NotFoundException("分组信息");
		}
		return goodsService.modifyGoods(goods);
	}

	@ApiOperation(value = "删除 根据分组信息标识删除分组信息信息", notes = "根据分组信息标识删除分组信息信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsByGoodsId(HttpServletResponse response, @PathVariable String goodsId) {
		Goods goods = goodsService.queryGoodsByGoodsId(goodsId);
		if(null == goods){
			throw new NotFoundException("分组信息");
		}
		return goodsService.dropGoodsByGoodsId(goodsId);
	}
	
	@ApiOperation(value = "查询 根据分组信息标识查询分组信息信息", notes = "根据分组信息标识查询分组信息信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.GET)
	public Object queryGoodsById(HttpServletResponse response,
			@PathVariable String goodsId) {
		Goods goods = goodsService.queryGoodsByGoodsId(goodsId);
		if(null == goods){
			throw new NotFoundException("分组信息");
		}
		return goods;
	}
	
	@ApiOperation(value = "查询分页 根据分组信息属性分页查询分组信息信息列表", notes = "根据分组信息属性分页查询分组信息信息列表")
	@RequestMapping(value = "/goodss", method = RequestMethod.GET)
	public Object queryGoodsPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Goods goods) {				
		return goodsService.queryGoodsForPage(pagenum, pagesize, sort, goods);
	}

}

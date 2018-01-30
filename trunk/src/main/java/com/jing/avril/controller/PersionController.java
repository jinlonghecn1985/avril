package com.jing.avril.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.avril.model.entity.Persion;
import com.jing.avril.service.PersionService;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: PersionController
 * @Description: 下家信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="下家信息")
public class PersionController{
	
	@Autowired
	private PersionService persionService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加下家信息信息", notes = "添加下家信息信息")
	@RequestMapping(value = "/persion", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addPersion(HttpServletResponse response,
			@ApiParam(value = "persion") @RequestBody Persion persion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if(persion.getPersionName()==null){
			persion.setPersionName(persion.getPersionKey());
		}
		List<Map<String, String>> errors = beanValidator.validateClassAuto(persion, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("persionKeyOnly", persion.getPersionKey());
		List<Persion> list = persionService.queryPersionByProperty(map);
		if(list!=null && !list.isEmpty()){
			throw new ParameterException("下家快捷码重复,请修订后提交!");
		}
		persion.setPersionId(null);
		persionService.addPersion(persion);
		return persion;
	}
	
	
	@ApiOperation(value = "更新 根据下家信息标识更新下家信息信息", notes = "根据下家信息标识更新下家信息信息")
	@RequestMapping(value = "/persion/{persionId:.+}", method = RequestMethod.PUT)
	public Object modifyPersionById(HttpServletResponse response,
			@PathVariable String persionId,
			@ApiParam(value = "persion", required = true) @RequestBody Persion persion
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(persion, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Persion tempPersion = persionService.queryPersionByPersionId(persionId);
		persion.setPersionId(persionId);
		if(null == tempPersion){
			throw new NotFoundException("下家信息");
		}
		if(persion.getPersionKey()!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("persionKeyOnly", persion.getPersionKey());
			map.put("persionIdNot", persionId);
			List<Persion> list = persionService.queryPersionByProperty(map);
			if(list!=null && !list.isEmpty()){
				throw new ParameterException("下家快捷码重复,请修订后提交!");
			}
		}
		return persionService.modifyPersion(persion);
	}

	@ApiOperation(value = "删除 根据下家信息标识删除下家信息信息", notes = "根据下家信息标识删除下家信息信息")
	@RequestMapping(value = "/persion/{persionId:.+}", method = RequestMethod.DELETE)
	public Object dropPersionByPersionId(HttpServletResponse response, @PathVariable String persionId) {
		Persion persion = persionService.queryPersionByPersionId(persionId);
		if(null == persion){
			throw new NotFoundException("下家信息");
		}
		return persionService.dropPersionByPersionId(persionId);
	}
	
	@ApiOperation(value = "查询 根据下家信息标识查询下家信息信息", notes = "根据下家信息标识查询下家信息信息")
	@RequestMapping(value = "/persion/{persionId:.+}", method = RequestMethod.GET)
	public Object queryPersionById(HttpServletResponse response,
			@PathVariable String persionId) {
		Persion persion = persionService.queryPersionByPersionId(persionId);
		if(null == persion){
			throw new NotFoundException("下家信息");
		}
		return persion;
	}
	
	@ApiOperation(value = "查询分页 根据下家信息属性分页查询下家信息信息列表", notes = "根据下家信息属性分页查询下家信息信息列表")
	@RequestMapping(value = "/persions", method = RequestMethod.GET)
	public Object queryPersionPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Persion persion) {				
		return persionService.queryPersionForPage(pagenum, pagesize, sort, persion);
	}
	
	@ApiOperation(value = "根据快捷号查询或新增用户", notes = "根据快捷号查询或新增用户")
	@RequestMapping(value = "/persions", method = RequestMethod.POST)
	public Persion bindPersionByPersionKey(HttpServletResponse response, @RequestBody Persion persion) {
		if(persion.getPersionId()!=null){
			Persion persion2 = persionService.queryPersionByPersionId(persion.getPersionId());
			if(persion2!=null){
				return persion2;
			}
		}
		if(persion.getPersionKey()!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("persionKey", persion.getPersionKey());
			List<Persion> plist = persionService.queryPersionByProperty(map );
			if(plist!=null && plist.size()>0){
				return plist.get(0);
			}else{
				persion.setPersionName(persion.getPersionKey());
				return persionService.addPersion(persion);
			}
		}else{
			new ParameterException("快捷码不能为空,请修订后提交!"); 
		}
		return null;
	}
	
}

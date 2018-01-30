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
import com.jing.avril.model.entity.Dictionary;
import com.jing.avril.service.DictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: DictionaryController
 * @Description: 字典信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="字典信息")
public class DictionaryController{
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加字典信息信息", notes = "添加字典信息信息")
	@RequestMapping(value = "/dictionary", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addDictionary(HttpServletResponse response,
			@ApiParam(value = "dictionary") @RequestBody Dictionary dictionary) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionary, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		dictionary.setDicId(null);
		dictionaryService.addDictionary(dictionary);
		return dictionary;
	}
	
	
	@ApiOperation(value = "更新 根据字典信息标识更新字典信息信息", notes = "根据字典信息标识更新字典信息信息")
	@RequestMapping(value = "/dictionary/{dicId:.+}", method = RequestMethod.PUT)
	public Object modifyDictionaryById(HttpServletResponse response,
			@PathVariable String dicId,
			@ApiParam(value = "dictionary", required = true) @RequestBody Dictionary dictionary
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionary, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Dictionary tempDictionary = dictionaryService.queryDictionaryByDicId(dicId);
		dictionary.setDicId(dicId);
		if(null == tempDictionary){
			throw new NotFoundException("字典信息");
		}
		return dictionaryService.modifyDictionary(dictionary);
	}

	@ApiOperation(value = "删除 根据字典信息标识删除字典信息信息", notes = "根据字典信息标识删除字典信息信息")
	@RequestMapping(value = "/dictionary/{dicId:.+}", method = RequestMethod.DELETE)
	public Object dropDictionaryByDicId(HttpServletResponse response, @PathVariable String dicId) {
		Dictionary dictionary = dictionaryService.queryDictionaryByDicId(dicId);
		if(null == dictionary){
			throw new NotFoundException("字典信息");
		}
		return dictionaryService.dropDictionaryByDicId(dicId);
	}
	
	@ApiOperation(value = "查询 根据字典信息标识查询字典信息信息", notes = "根据字典信息标识查询字典信息信息")
	@RequestMapping(value = "/dictionary/{dicId:.+}", method = RequestMethod.GET)
	public Object queryDictionaryById(HttpServletResponse response,
			@PathVariable String dicId) {
		Dictionary dictionary = dictionaryService.queryDictionaryByDicId(dicId);
		if(null == dictionary){
			throw new NotFoundException("字典信息");
		}
		return dictionary;
	}
	
	@ApiOperation(value = "查询分页 根据字典信息属性分页查询字典信息信息列表", notes = "根据字典信息属性分页查询字典信息信息列表")
	@RequestMapping(value = "/dictionarys", method = RequestMethod.GET)
	public Object queryDictionaryPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Dictionary dictionary) {				
		return dictionaryService.queryDictionaryForPage(pagenum, pagesize, sort, dictionary);
	}

}

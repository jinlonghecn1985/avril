package com.jing.avril.controller;

import java.util.Map;
import java.util.HashMap;
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
import com.jing.avril.model.entity.Stage;
import com.jing.avril.service.StageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: StageController
 * @Description: 期号信息HTTP接口
 * @author: JIM
 * @email: mailto:
 * @date: 2017年07月26日 17时26分
 */
@RestController
@Api(description="期号信息")
public class StageController{
	
	@Autowired
	private StageService stageService;
	
	@Autowired 
	private BeanValidator beanValidator; 
	
	@ApiOperation(value = "新增 添加期号信息信息", notes = "添加期号信息信息")
	@RequestMapping(value = "/stage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addStage(HttpServletResponse response,
			@ApiParam(value = "stage") @RequestBody Stage stage) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(stage, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stageName", stage.getStageName());
		List<Stage> slist = stageService.queryStageByProperty(map);
		if(slist!=null && slist.size()>0){
			throw new ParameterException("期号已经存在,不允许重复添加!");
		}
		stage.setStageId(null);
		stageService.addStage(stage);
		return stage;
	}
	
	
	@ApiOperation(value = "更新 根据期号信息标识更新期号信息信息", notes = "根据期号信息标识更新期号信息信息")
	@RequestMapping(value = "/stage/{stageId:.+}", method = RequestMethod.PUT)
	public Object modifyStageById(HttpServletResponse response,
			@PathVariable String stageId,
			@ApiParam(value = "stage", required = true) @RequestBody Stage stage
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(stage, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Stage tempStage = stageService.queryStageByStageId(stageId);
		stage.setStageId(stageId);
		if(null == tempStage){
			throw new NotFoundException("期号信息");
		}
		return stageService.modifyStage(stage);
	}

	@ApiOperation(value = "删除 根据期号信息标识删除期号信息信息", notes = "根据期号信息标识删除期号信息信息")
	@RequestMapping(value = "/stage/{stageId:.+}", method = RequestMethod.DELETE)
	public Object dropStageByStageId(HttpServletResponse response, @PathVariable String stageId) {
		Stage stage = stageService.queryStageByStageId(stageId);
		if(null == stage){
			throw new NotFoundException("期号信息");
		}
		return stageService.dropStageByStageId(stageId);
	}
	
	@ApiOperation(value = "查询 根据期号信息标识查询期号信息信息", notes = "根据期号信息标识查询期号信息信息")
	@RequestMapping(value = "/stage/{stageId:.+}", method = RequestMethod.GET)
	public Object queryStageById(HttpServletResponse response,
			@PathVariable String stageId) {
		Stage stage = stageService.queryStageByStageId(stageId);
		if(null == stage){
			throw new NotFoundException("期号信息");
		}
		return stage;
	}
	
	@ApiOperation(value = "查询分页 根据期号信息属性分页查询期号信息信息列表", notes = "根据期号信息属性分页查询期号信息信息列表")
	@RequestMapping(value = "/stages", method = RequestMethod.GET)
	public Object queryStagePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Stage stage) {				
		return stageService.queryStageForPage(pagenum, pagesize, sort, stage);
	}

}

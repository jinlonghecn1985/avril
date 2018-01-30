document.write("<script language='javascript' src='./jl/http.jl.js'></script>");
document.write("<script language='javascript' src='./jl/jquery.ajax.jl.js'></script>");
document.write("<script language='javascript' src='./jl/jquerysession.js'></script>");

//初始化代码
$(document).ready(function(){ 	
	console.log('load avril.js');	
	AVRIL.info();		
});

function showJLWarning(message){
	new $.zui.Messager(message, {
		type : 'warning',
		placement : 'top-right',
		close : false
	// 禁用关闭按钮
	}).show();
}

function showJLSuccess(message){
	new $.zui.Messager(message, {
		type : 'success',
		placement : 'top-right',
		close : false
	// 禁用关闭按钮
	}).show();
}

function showJLError(message){
	new $.zui.Messager(message, {
		type : 'danger',
		placement : 'top-right',
		close : false
	// 禁用关闭按钮
	}).show();
}

(function($) {
	//注册全局系统对象
	window['AVRIL'] = {};
	
	AVRIL.setPersion=function(persionId, persionName){
		$.session.set("persionId", persionId);
		$.session.set("persionName", persionName);
	};
	
	AVRIL.clearPersion=function(){
		$.session.remove("persionId");
		$.session.remove("persionName");
	};
	
	AVRIL.setStage=function(stageId, stageName, sStatus){
		$.session.set("stageId", stageId);
		$.session.set("stageName", stageName);
		$.session.set("stageStatus", sStatus);
		AVRIL.clearPersion();
	}
	
	AVRIL.clearStage=function(stageId, stageName){
		AVRIL.clearPersion();
		$.session.remove("stageId");
		$.session.remove("stageName");
		$.session.remove("stageStatus");
	}
	
	AVRIL.persionId=function(){
		return $.session.get("persionId");
	}
	
	AVRIL.persionName=function(){
		return $.session.get("persionName");
	}
	
	AVRIL.stageId=function(){
		return $.session.get("stageId");
	}
	
	AVRIL.stageName=function(){
		return $.session.get("stageName");
	}
	
	AVRIL.stageStatus=function(){
		return $.session.get("stageStatus");
	}
	
	
	//定义方法-属性
	AVRIL.info = function(){
		console.log('AVRIL FUCK');
	};
	
	//加载风险金
	AVRIL.loadStageDetail=function(fn){
		myAjax("/stageDetails?pageNo=1&pageSize=100&sort=%7B%22element%22%3A%22asc%22%7D&stageId="+AVRIL.stageId(), "get", {}, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}	
	
	//初始化配置参数
	AVRIL.initConfig = function(fn){
		myAjax("/operation/init", "post", {}, function(data){
			AVRIL.clearStage();
			if(fn){
				fn();
			}
		}, false);
	};
	
	//更新风险金
	AVRIL.saveStageDetail=function(params, fn){
		params.stageId = AVRIL.stageId();
		myAjaxJson('/stageDetail/'+params.billId, "put", params, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//保存
	AVRIL.saveStageInfo=function(params, fn){
		//params.stageId = AVRIL.stageId();
		myAjaxJson('/stage/'+AVRIL.stageId(), "put", params, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	
	
	//删除配置
	AVRIL.deleteConfig=function(dicId, $row){
		myAjax("/dictionary/"+dicId, "delete", {}, function(data){
			if($row){
				$row.remove();
			}
		}, false);
	}
	
	//配置添加或修改
	AVRIL.bindConfig=function(params, fn){
		var url = '/dictionary';
		params.dicGroup = 'config_ele_group';
		if(params.dicId!=undefined && params.dicId.length>0){
			url += ('/'+params.dicId);
			params.dicGroup = null;
		}
		myAjaxJson(url, url=='/dictionary'?"post":"put", params, function(data){			
			//if(data!=null && data.batchCode!=null){
				if(fn){fn(data);}				
			//}
		}, false);
	}
	
	//配置信息查询
	AVRIL.queryConfig=function(){		
		myAjax("/dictionarys?pageNo=1&pageSize=100&sort=%7B%22dicGroup%22%3A%22asc%22%2C%22dicFlag%22%3A%22asc%22%7D", "get", {}, function(data){
			$configTable = $("#configTable");
			$configTable.html('');
			if(data!=null && data.data!=null && data.data.length>0){
				$data = data.data;
				var ihtml = "";
				for(var i=0; i<$data.length; i++){
					ihtml+=("<tr>"
							+"<td><i onclick=\"doModify(this)\" class=\"icon icon-cog modify\"  data-toggle=\"tooltip\" data-placement=\"left\" title=\"修改\"></i>" 
								+"<i onclick=\"doCannel(this)\" class=\"icon icon-circle-arrow-left saves elehidden\"  data-toggle=\"tooltip\" data-placement=\"left\" title=\"取消\"></i>&nbsp;&nbsp;"
								+"<input type=\"hidden\" class=\"dicId\" value=\""+$data[i].dicId+"\">"
								+"<input type=\"hidden\" class=\"dicGroup\" value=\""+$data[i].dicGroup+"\">"
								+"<i onclick=\"doSave(this)\" class=\"icon icon-save saves elehidden\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"保存\"></i>"
								+('config_ele_group'==$data[i].dicGroup?
										"<i class=\"icon icon-remove-sign modify\" onclick=\"doDrop(this)\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"删除\"></i>"
								:"")
							+"</td>"
							+"<td>"+$data[i].dicCode+"</td>"
							+"<td>"+$data[i].dicValue+"</td>"
							+"<td>"+$data[i].dicFlag+"</td>"							
							+"<td>"+($data[i].dicNote==undefined?"":$data[i].dicNote)+"</td>"
							+"<td>"+$data[i].gmtCreated+"</td>"
							+"<td>"+$data[i].gmtModify+"</td>"
							+"</tr>");
				}
				$configTable.html(ihtml);				
				$configTable.children("td").children("i.saves").hide();
			}
		}, false);
	}
	
	//更新交易状态
	AVRIL.changTradeStatus=function(params, fn){
		myAjaxJson("/trade/"+params.tradeId, "put", params, function(data){
			if(fn){fn(data);}
		}, false);
	}
	
	//查询指定期别所有人员交易详情
	AVRIL.queryAllPersionTrade=function(fn, pn, ps){
		myAjax("/persionDetails?pageNo="+pn+"&pageSize="+ps+"&sort=%7B%22backMoney%22%3A%22desc%22%7D&stageId="+AVRIL.stageId(), "get", {}, function(data){
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//查询人员交易历史记录
	AVRIL.queryPersionTrade=function(fn, pn, ps){		
		myAjax("/trades?pageNo="+pn+"&pageSize="+ps+"&sort=%7B%22gmtCreated%22%3A%22DESC%22%2C%20%22batch%22%3A%22ASC%22%7D&stageId="+AVRIL.stageId()+"&persionId="+AVRIL.persionId(), "get", {}, function(data){
			if(fn){
				fn(data);
			}
		}, false);	
	}
	
//	//查询人员交易数据详情
//	AVRIL.queryPersionTradeElement=function(){
//		myAjax("/persions?stageId="+AVRIL.stageId(), "post", {}, function(data){
//			if(fn){
//				fn(data);
//			}	
//		}, false);
//	}
	
	//查询交易数据
	AVRIL.queryPersionTradeElement=function(showPersion, fn){
		var qustr = (showPersion==undefined || showPersion=='undefined')?"":"&persionId="+AVRIL.persionId();
		myAjax("/statistics/tradeDetail?stageId="+AVRIL.stageId()+qustr, "get", {}, function(data){
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//添加交易数据
	AVRIL.bindTradeInfo=function(optCode, fn){
		myAjaxJson("/operation/trades", "post", {"stageId": AVRIL.stageId(), "persionId":AVRIL.persionId(), "optCode":optCode}, function(data){
			if(fn){
				fn(data);
			}			
		}, false);
	}
	
	//初始化卡片组
	AVRIL.queryElementGoodInfo=function(fn){
		myAjax("/statistics/goods/elements", "get", {}, function(data){
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//加载大类详情--帮助信息
	AVRIL.initGoodsHelp=function(fn){		
		myAjax("/statistics/goods/help", "get", {}, function(data){
			if(fn){
				fn(data);
			}
		}, false);
		
	};
	
	//加载指定期人员列表
//	AVRIL.refPersonList=function(fn){
//		myAjax("/persions?pageNo=1&pagesize=100&stageId=43F2EB4DA4514095BE146B7BA29E561B&sort=gmt_modify%20desc", "post", {}, function(data){			
//			if(data!=null ){
//					$personItem = $("#personItem");
//					$personItem.empty();
//					var $datainfo = data;
//					var ihtml = "";
//					for(var i=0; i<$datainfo.length; i++){
//						ihtml+=("<div class=\"item\"><div class=\"item-heading\">"
//									+"<div class=\"pull-right\"><span class=\"text-muted\">"+(data[i].gmt_modity==null?'--':data[i].gmt_modity)
//									+"</span> &nbsp; <a href=\"#\" class=\"text-muted\"><i class=\"icon-comments\"></i>"+data[i].fee+"</a></div>"
//								+"<h4><a href=\"###\">"+data[i].persion_name+"</a></h4></div></div>");//persion_id
//					}
//					$personItem.append(ihtml);
//			}			
//		} , false);	
//	};
	
	//查询人员信息
	AVRIL.queryPersionInfo=function(fn){
		myAjax("/persion/"+AVRIL.persionId(), "get", {}, function(data){
			if(fn){
				fn(data);
			}			
		}, false);
	}
	
	//绑定人员
	AVRIL.bindPersion=function(persionKey, fn){
		myAjaxJson("/persions", "post", {"persionKey":persionKey}, function(data){
			if(fn){
				fn(data);
			}			
		}, false);
	}
	
	//删除人员信息
	AVRIL.deletePersionInfo = function(fn, persionId){
		myAjax('/persion/'+persionId, "delete", {}, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//保存人员信息
	AVRIL.savePersionInfo = function(fn, params){
		if(params.persionId!=undefined && params.persionId.length>0){
			//修订
			myAjaxJson('/persion/'+params.persionId, "put", params, function(data){			
				if(fn){
					fn(data);
				}
			}, false);
		}else{
			//新增
			myAjaxJson('/persion', "post", params, function(data){			
				if(fn){
					fn(data);
				}
			}, false);
		}		
	}
	
	//加载人员信息
	AVRIL.loadPersionList=function(fn, pn, ps, searchWord){
		var sw = '';
		if(searchWord!=undefined && searchWord.length>0){
			sw = '&persionName='+searchWord;
		}
		myAjax("/persions?pageNo="+pn+"&pageSize="+ps+"&sort=%7B%22persionName%22%3A%22asc%22%7D"+sw, "get", {}, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//加载
	AVRIL.queryStageInfo=function(fn){		
		myAjax('/stage/'+AVRIL.stageId(), "get", null, function(data){			
			if(fn){
				fn(data);
			}
		}, false);
	}
	
	//添加期号信息
	AVRIL.addStage=function(fn){	
		var d = new Date();
		var ymd = d.getFullYear()+((d.getMonth()+1)<10?"0"+(d.getMonth()+1):(d.getMonth()+1))+(d.getDate()<10?"0"+d.getDate():d.getDate());
		myAjaxJson("/stage", "post", {"element": 0, "stageName": ymd}, function(data){			
			if(fn){
				fn(data);
			}
		}, false);		
	}
	
	//删除期号信息
	AVRIL.deleteStage=function(stageId, fn){
		myAjax("/stage/"+stageId, "delete", {}, function(data){			
			if(fn){
				fn(data);
			}		
		}, false);
	}
	
	//加载期号信息
	AVRIL.loadStageList=function(fn){
		myAjax("/stages?pageNo=1&pageSize=200&sort=%7B%22gmtModify%22%3A%22DESC%22%7D", "get", {}, function(data){
			fn(data);
		}, false);
	};
	
	
	//期号结算
	AVRIL.goStageTerminator=function(fn){
		myAjax("/operation/terminator/"+AVRIL.stageId(), "post", {}, function(data){
			fn(data);
		}, false);
	};
	
	
	
	/**
	 * 
	 * 初始化分页条
	 * @param pageBe
	 */
	AVRIL.initPageBar = function(pageBe){
		var maxPage;
		if(pageBe==null || pageBe.totalCount==0){
			maxPage=1;
			$(".pager").html("<li class=\"active\"><a href=\"javascript:void(0);\" onclick=\"goPage(1)\" class=\"on\">刷新</a></li>");
			//无数据
			return;
		}
		if(pageBe.totalPages==1){
			$(".pager").html("<li class=\"active\"><a href=\"javascript:void(0);\" onclick=\"goPage(1)\" class=\"on\">1</a></li>");
			return;
		}
		var khtml = "";
		if(pageBe.hasPrePage==true){
			khtml+="<li class=\"previous\"><a href=\"javascript:void(0);\" onclick=\"goPage("+(pageBe.page-1)+")\">« 上一页</a></li>";
		}
		if(pageBe.totalPages<10){
			var phtml=khtml;
			for(var j=0; j<pageBe.totalPages; j++){
				phtml += "<li "+(j+1==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage("+(j+1)+")\" >"+(j+1)+"</a></li>";
			}
			if(pageBe.page!=pageBe.totalPages){
				phtml+="<li class=\"next\"><a href=\"javascript:void(0);\" onclick=\"goPage("+(pageBe.page+1)+")\">下一页  »</a></li>";
			}
			$(".pager").html(phtml);
			return;
		}
		khtml += "<li "+(1==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage(1)\" >1</a></li><li "+(2==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage(2)\" >2</a></li>";
		var cpage = pageBe.page; //准备中间页
		if(pageBe.page<6){
			//在头5页时
			cpage=3;
		}else if(pageBe.page>pageBe.totalPages-4){
			cpage=pageBe.totalPages-6;
			khtml+=" <li><a href=\"javascript:void(0);\">⋯</a></li>";
		}else{
			cpage=pageBe.page-2;
			khtml+=" <li><a href=\"javascript:void(0);\">⋯</a></li>";
		}
		
		for(var k=0; k<5; k++){
			khtml+=("<li "+((cpage+k)==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage("+(cpage+k)+")\" >"+(cpage+k)+"</a></li>");
		}
		if(pageBe.page<pageBe.totalPages-4){
			khtml+=" <li><a href=\"javascript:void(0);\">⋯</a></li>";
		}
		khtml += ("<li "+((pageBe.totalPages-1)==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage("+(pageBe.totalPages-1)+")\" >"+(pageBe.totalPages-1)+"</a></li><li "+(pageBe.totalPages==pageBe.page?"class=\"active\"":"")+"><a href=\"javascript:void(0);\" onclick=\"goPage("+(pageBe.totalPages)+")\" >"+(pageBe.totalPages)+"</a></li>");
		if(pageBe.hasNextPage==true){
			khtml+="<li class=\"next\"><a href=\"javascript:void(0);\" onclick=\"goPage("+(pageBe.page+1)+")\">下一页  »</a></li>";
		}
		$(".pager").html(khtml);
		return;
	};
	
})(jQuery);
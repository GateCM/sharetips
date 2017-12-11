var CONTENT_TYPE_DEFAULT = "application/x-www-form-urlencoded;charset=UTF-8";
var CONTENT_TYPE_JSON = "application/json; charset=utf-8";

// 获取GET数据
function ajaxGetData(getUrl, requestData) {
	var resultData;
	$.ajax({
		type : "GET",
		url : getUrl,
		dataType : "JSON",
		data : requestData,
		async : false,
		success : function(data) {
			resultData = data;
		}
	});
	return resultData;
}

/**
 * 快捷ajax
 * 
 * @param buttonNode
 * @param url
 * @returns
 */
function dajax(buttonNode,isJson) {
	var formNode = buttonNode.parents("form");
	if (formNode.valid()) {
		var aurl = formNode.attr("action");
		var atype = formNode.attr("method");
		var adata;
		var acontentType;
		if (isJson) {
			acontentType = CONTENT_TYPE_JSON;
			adata = JSON.stringify(formNode.serializeObject());
		} else {
			acontentType = CONTENT_TYPE_DEFAULT;
			adata = formNode.serialize();
		}
		return ajax(aurl, adata, atype,acontentType);
	} else {
		return false;
	}
}

/* ajax 表单 */
function ajax(aurl, adata, atype,acontentType) {
	var resultData;
	$.ajax({
		type : atype,
		url : aurl,
		dataType : "JSON",
		data : adata,
		async : false,
		contentType : acontentType,
		success : function(data) {
			resultData = data;
		}
	});
	return resultData;
}

$(function() {
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

});

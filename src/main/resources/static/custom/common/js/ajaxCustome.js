// 获取GET数据
function ajaxGetData(requestData, getUrl) {
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

/* ajax post 表单 */
function ajaxPost(postUrl, postData) {
	var resultData;
	$.ajax({
		type : "POST",
		url : postUrl,
		dataType : "JSON",
		data : postData,
		async : false,
		success : function(data) {
			resultData = data;
		}
	});
	return resultData;
}

/* ajax post json */
function ajaxPostJson(postUrl, postData) {
	$.ajax({
		type : "POST",
		url : postUrl,
		dataType : "JSON",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(postData),
		success : function(data) {
			return data.result;
		}
	});
}

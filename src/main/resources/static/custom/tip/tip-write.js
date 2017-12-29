var taskId;
var hasSaved = true;
var draftUrl = "/api/tip/draft";
var releaseUrl = "/api/tip/release";
// save tip draft task
function saveTask() {
	taskId = setInterval(saveDraft, 3000);
}
// ini editor
var E = window.wangEditor;
var editor = new E('#editBox');

// save tip draft
function saveDraft() {
	if (!hasSaved) {
		saveTip(draftUrl);
	}
}

function saveTip(postUrl) {
	var adata = {};
	adata.tipId = $("input[name='tipId']").val();
	adata.headImg = $(".img-big-upload img").attr("src");
	adata.title = $("input[name='title']").val();
	adata.content = editor.txt.html();
	if (adata.title == "" || adata.content == "<p><br></p>") {
		hasSaved = true;
		return;
	}
	$.ajax({
		type : "POST",
		url : postUrl,
		dataType : "JSON",
		data : JSON.stringify(adata),
		contentType : CTJ,
		success : function(data) {
			hasSaved = data.result;
			if(hasSaved){
				$("input[name='tipId']").val(data.data);
				console.log("保存成功");
			}else{
				console.log("保存失败");
			}
		}
	});
}

$(function() {
	
	$(document).on("click",'[data-type="release-tip"]',function(){
		saveTip(releaseUrl);
	});
	
	// 题图上传
	$(".img-big-upload")
			.click(
					function() {
						var divNode = $(this);
						var fileInput = $("#file-input");
						// 模拟点击input
						fileInput.trigger('click');
						fileInput.change(function() {
									$.ajaxFileUpload({
												url : '/api/img/upload/tip',
												secureuri : false,
												dataType : 'json',
												fileElementId : 'file-input',
												success : function(data) {
													if (data.result == true) {
														var imgUrl = data.data;
														divNode.empty();
														divNode
																.addClass("show-img");
														divNode
																.append('<img class="img-thumbnail" src="'
																		+ imgUrl
																		+ '"/>');
													} else {
														alert("上传失败");
													}
												}
											});
								});
					});
	// config editor
	editor.customConfig.uploadFileName = 'file';
	editor.customConfig.uploadImgServer = '/api/img/wang/upload/tip';
	// check editor change
	editor.customConfig.onchange = function(html) {
		hasSaved = false;
	}
	editor.create();
	// check input change
	$(document).on("change",'input[data-type="auto-save"]',function() {
		hasSaved = false;
	});

	// start task
	saveTask();
});

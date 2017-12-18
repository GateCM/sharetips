$(function() {
	// 保存草稿
	$('a[data-type="save-draft"]').click(function() {
		var aurl = "/api/tip/draft";
		var adata = {};
		adata.headImg = $(".img-big-upload img").attr("src");
		adata.title = $("input[name='title']").val();
		adata.content = editor.txt.html();
		var result = ajaxPostJson(aurl, adata);

	});
	// 题图上传
	$(".img-big-upload")
			.click(
					function() {
						var divNode = $(this);
						var fileInput = $("#file-input");
						// 模拟点击input
						fileInput.trigger('click');
						fileInput
								.change(function() {
									$
											.ajaxFileUpload({
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
	// 初始化编辑框
	var E = window.wangEditor
	var editor = new E('#editBox');
	editor.customConfig.uploadFileName = 'file';
	editor.customConfig.uploadImgServer = '/api/img/wang/upload/tip';
	editor.create();

});
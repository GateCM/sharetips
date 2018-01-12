layui.use([ 'layer', 'form', 'element' ], function() {
	var layer = layui.layer;
	var form = layui.form;
	var element = layui.element;
	
	//select type change
	form.on('select(type)',function(data){
		hasSaved = false;
	});
	
	//4s save
	var saveInterval = 4000;
	var hasSaved = true;
	// save tip draft task
	function saveTask() {
		setInterval(saveDraft, saveInterval);
	}
	// ini editor
	var E = window.wangEditor;
	var editor = new E('#editBox');

	// save tip draft
	function saveDraft() {
		if (!hasSaved) {
			var adata = validateParam();
			if (adata == null) {
				hasSaved = true;
				return;
			}
			hasSaved = true;
			$.ajax({
				type : "POST",
				url : "/api/tip/a/draft",
				dataType : "JSON",
				data : JSON.stringify(adata),
				contentType : CTJ,
				success : function(data) {
					if (data.result) {
						$("input[name='tipId']").val(data.data);
						console.log("保存成功");
					} else {
						console.log("保存失败");
					}
				}
			});
		}
	}

	function validateParam() {
		var adata = {};
		adata.tipId = $("input[name='tipId']").val();
		adata.headImg = $(".img-big-upload img").attr("src");
		adata.title = $("input[name='title']").val();
		adata.type = $("select[name='type']").val();
		adata.content = editor.txt.html();
		if (adata.title == "" || adata.content == "<p><br></p>") {
			return null;
		}
		var plates = new Array();
		$("#plate-checked span").each(function(n,value){
			plates[n] = $(value).attr("data");
		});
		if(plates.length==0){
			return null;
		}
		adata.plateIds = plates;
		return adata;
	}

	$(function() {
		// colla
		$(".tip-setup-switch").click(function() {
			$(".tip-setup-box").toggle(600);
			$(".tip-setup-switch i").toggleClass("fa-rotate-90");
		});

		// ini plate
		$.get("/api/base/plate", function(rd) {
			if (rd.result) {
				var setUpBox = $(".tip-setup-box");
				setUpBox.hide();
				var plateBox = $("#tip-plate-box");
				$.each(rd.data, function(n, value) {
					plateBox.append(
							'<span data="' + value.id + '">' + value.name
									+ '</span>');
				});
				$("#plate-checked span").each(function(n,ele){
					plateBox.children('span[data="'+$(ele).attr("data")+'"]').remove();
				});
				setUpBox.show(900);
				form.render();
			}
		})

		// add plate
		$(document).on('click', '#tip-plate-box span', function() {
			var checkedParent = $("#plate-checked");
			if (checkedParent.children('span').length >= 3) {
				layer.msg('最多只能选择3个版块');
				return;
			}
			checkedParent.append($(this).remove());
			hasSaved = false;
		});
		// del plate
		$(document).on('click', '#plate-checked span', function() {
			var delNode = $(this);
			var plateNode = delNode.clone();
			delNode.fadeOut(300, function() {
				$("#tip-plate-box").append(plateNode);
				delNode.remove();
			});
			hasSaved = false;
		});

		$(document).on("click", '[data-type="release-tip"]', function() {
			var adata = validateParam();
			if (adata == null) {
				hasSaved = true;
				return;
			}
			hasSaved = true;
			$.ajax({
				type : "POST",
				url : "/api/tip/a/release",
				dataType : "JSON",
				data : JSON.stringify(adata),
				contentType : CTJ,
				success : function(data) {
					if (data.result) {
						$("input[name='tipId']").val(data.data);
						layer.msg("保存成功");
					} else {
						layer.msg("保存失败");
					}
				}
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
		$(document).on("change", 'input[data-type="auto-save"]', function() {
			hasSaved = false;
		});
		// start task
		saveTask();
	});

});

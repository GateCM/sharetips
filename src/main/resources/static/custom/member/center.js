layui.use([ 'laypage', 'upload', 'layer' ], function() {
	var laypage = layui.laypage;
	var upload = layui.upload;
	var layer = layui.layer;
	// 执行实例
	var uploadInst = upload.render({
		elem : '#member-info .head-img img', // 绑定元素
		url : '/api/img/upload/tip', // 上传接口
		done : function(rd) {
			if (rd.result) {
				var imgUrl = rd.data;
				var patchData = {
					"headUrl" : imgUrl
				};
				$.ajax({
					url : '/api/member/a/reset/basic',
					type : "PATCH",
					contentType : CTJ,
					dataType : "JSON",
					data : JSON.stringify(patchData),
					success : function(rdu) {
						if (rdu.result) {
							changHeadImg(imgUrl);
						}
					}
				});
			}
		},
		error : function() {
			// 请求异常回调
		}
	});

	// 每页记录数
	var pageSize = 10;
	// 技巧列表数据接口
	var tipListUrl = "/api/tip/a/member/release/list";
	$(function() {

		$.get("/api/member/a/basic", function(rd) {
			// alert(JSON.stringify(rd));
			changHeadImg(rd.data.headUrl);
			$("#member-info .nickname span").text(rd.data.nickname);
			$("#member-info .motto span").text(rd.data.motto);
			$("#member-info .point span").text(rd.data.totalPoint);
		});

		// left nav
		$(document).on("click", "#center-nav li a", function() {
			clearMain();
			$("#center-nav li").removeClass("layui-nav-itemed");
			$(this).parent().addClass("layui-nav-itemed");
			var showBoxId = $(this).attr("data");
			$("#" + showBoxId).removeClass("hide");
			if (showBoxId == "tip-list") {
				var tipShowBoxId = "my-tip";
				var layPageId = "bottom-laypage";
				loadListWithLayPage(1, tipShowBoxId, layPageId);
			}
		});

		// member basic
		$('#member-info a[data="edit"]').click(function() {
			clearMain();
			$("#member-edit").removeClass("hide");
			$.get("/api/member/a/basic", function(rd) {
				// alert(JSON.stringify(rd));
				$('input[name="nickname"]').val(rd.data.nickname);
				$('input[name="age"]').val(rd.data.age);
				$('input[name="sex"]').val(rd.data.sex);
				$('input[name="motto"]').val(rd.data.motto);
				$('input[name="birthday"]').val(rd.data.birthday);
				$('input[name="occupation"]').val(rd.data.occupation);
				$('input[name="email"]').val(rd.data.email);
			});
		});
		
		//update basic
		$("#updateBasic").click(function(){
			var patchData = $("#form-basic").serializeObject();
			alert(JSON.stringify(patchData));
			$.ajax({
				url : '/api/member/a/reset/basic',
				type : "PATCH",
				contentType : CTJ,
				dataType : "JSON",
				data : JSON.stringify(patchData),
				success : function(rdu) {
					if (rdu.result) {
						layer.msg("信息修改成功");
					}
				}
			});
		});
		
	});

	function clearMain() {
		$("#main-container").children().addClass("hide");
	}

	function changHeadImg(headUrl) {
		$("#member-info .head-img img").attr("src", headUrl);
	}

	function loadListWithLayPage(pageNum, boxId, layPageId) {
		$.get(tipListUrl, {
			"pageNum" : pageNum,
			"pageSize" : pageSize
		}, function(result) {
			laypage.render({
				elem : layPageId, // 注意，这里的 是 id，不用加 # 号
				count : result.data.total, // 数据总数，从服务端得到
				limit : pageSize, // 每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
				layout : [ 'count', 'prev', 'page', 'next', 'limit', 'skip' ],
				jump : function(obj, first) {
					iniTipShowBox(result.data.list, boxId);
					if (!first) {
						$.get(tipListUrl, {
							"pageNum" : obj.curr,
							"pageSize" : obj.limit
						}, function(rd) {
							iniTipShowBox(rd.data.list, boxId);
						});
					}
				}
			});
		});
	}

	function iniTipShowBox(recordList, boxId) {
		var tipShowBox = $("#" + boxId);
		tipShowBox.empty();
		$.each(recordList, function(n, value) {
			tipShowBox.append('<div class="tip-entry">' + (n + 1) + '. '
					+ '<a class="tip-info"' + 'href="/tip/' + value.id
					+ '/detail">' + value.title + '</a>' + '<span>'
					+ getDateDiff(value.gmtCreate) + '</span></div>');
		});
	}
});
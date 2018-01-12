layui.use([ 'laypage', 'upload' ], function() {
	var laypage = layui.laypage;
	var upload = layui.upload;
	// 执行实例
	var uploadInst = upload.render({
		elem : '#test1', // 绑定元素
		url : '/api/img/upload/tip', // 上传接口
		done : function(res) {
			// 上传完毕回调
			console.log(JSON.stringify(res));
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
		
		$.get("/api/member/a/basic",function(rd){
//			alert(JSON.stringify(rd));
		})
		

		// left nav
		$(document).on("click", "#center-nav li a", function() {
			$("#center-nav li").removeClass("layui-nav-itemed");
			$(this).parent().addClass("layui-nav-itemed");
			$("#main-container").children().addClass("hide");
			var showBoxId = $(this).attr("data");
			$("#" + showBoxId).removeClass("hide");
			if (showBoxId == "tip-list") {
				var tipShowBoxId = "my-tip";
				var layPageId = "bottom-laypage";
				loadListWithLayPage(1, tipShowBoxId, layPageId);
			}
		});
	});

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
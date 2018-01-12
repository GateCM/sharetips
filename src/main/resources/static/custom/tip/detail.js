layui.use(['layer','util','laypage'],function() {
		var layer = layui.layer;
		var util = layui.util;
		var laypage = layui.laypage;
		var isLogged = entryStatus();
		//回顶部
		util.fixbar({
		});

		$(function() {
			var pageNum = 1;
			var pageSize = 5;

			//ini comment
			iniComment(pageNum, pageSize);

			//commit comment
			$(document).on("click",'[data-type="submitComment"]',function() {	
				if(!isLogged){
					layer.msg("请先登录再评论");
					return false;
				}
				if($("#commentContent").val()== ""){
					layer.msg("不能发表空评论");
					return false;
				}
				var tipId = $('input[name="tipId"]').val();
				var postJson = {};
				postJson.content = $("#commentContent").val();
				postJson.tfReply= $('input[name="tfReply"]').val();
				$.ajax({
					type: "POST",
					url: "/api/tip/a/" + tipId+ "/comment",
					contentType: CTJ,
					dataType: "JSON",
					data:JSON.stringify(postJson),
					success:function(rd){
						if (rd.result) {
							layer.msg("操作成功", {icon: 1});
							setTimeout(function() {
								iniComment(pageNum, pageSize);
								$("#commentContent").val("");
							}, 1000);
							
						}
					}
				});
			});
			//submitButton control
			$('#commentContent').on('change',function() {
				var submitButton = $('#submitComment');
				if ($(this).val() == "") {
					submitButton.attr("data-type", "");
					submitButton.addClass("layui-btn-disabled");
				} else {
					submitButton.attr("data-type","submitComment");
					submitButton.removeClass("layui-btn-disabled");
				}
			});
		});

	//ini comment
	function iniComment(pageNum, pageSize) {
		var tipId = $('input[name="tipId"]').val();
		var url = "/api/tip/" + tipId + "/comment";
		$.get(url,{"pageNum":pageNum,"pageSize":pageSize},function(rd){
			//list
			if(iniCommentList(rd.data)){
				//page
				laypage.render({
				    elem: "bottom-laypage", //注意，这里的 是 id，不用加 # 号
				    count: rd.data.total, //数据总数，从服务端得到
				    limit: pageSize, //每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
				    prev:'<i class="fa fa-chevron-left"></i>',
				    next:'<i class="fa fa-chevron-right"></i>',
				    layout: ['count','prev', 'next'],
				    jump: function(obj, first){
				        if(!first){
				        	$.get(url,{"pageNum":obj.curr,"pageSize":obj.limit},function(rd){
				    			iniCommentList(rd.data);
				        	});
				        }
				      }
			 	 });
			}
		});
	}
		
	//ini comment
	function iniCommentList(pageInfo) {
		var total  = pageInfo.total;
		//update top
		autoIncrease(pageInfo.total,$("#commentNumber"));
		//ini show box
		var showBox = $("#comment-show-box");
		showBox.empty();
		if(total==0){
			showBox.append('<div class="no-comment">抢沙发啦！</div>');
			return false;
		}
		
		$.each(pageInfo.list,function(n, value) {
			console.log(JSON.stringify(value));
			if (value.tfReply) {
				showBox.append('<div class="comment-entity"><div class="member-show">'
								+ '<img src="'+value.belongUser.headUrl+'">'
								+ '<span data="'+value.belongUser.id+'" class="member-link">'
								+ value.belongUser.nickname
								+ '</span>'
								+ '<span class="reply">回复</span>'
								+ '<span data="'+value.replyMember.id+'" class="member-link">'
								+ value.replyMember.nickname
								+ '</span>'
								+ '<span class="time" >'
								+ getDateDiff(value.gmtCreate)
								+ '</span>'
								+ '</div>'
								+ '<div class="comment-content">'
								+ '<span>'
								+ value.content
								+ '</span>'
								+ '</div></div>');
			} else {
				showBox.append('<div class="comment-entity"><div class="member-show">'
								+ '<img src="'+value.belongUser.headUrl+'">'
								+ '<span data="'+value.belongUser.id+'" class="member-link">'
								+ value.belongUser.nickname
								+ '</span>'
								+ '<span class="time" >'
								+ getDateDiff(value.gmtCreate)
								+ '</span>'
								+ '</div>'
								+ '<div class="comment-content">'
								+ '<span>'
								+ value.content
								+ '</span>'
								+ '</div></div>');
			}
		});
		return true;
	}
});
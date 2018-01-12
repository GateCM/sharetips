layui.use(['layer','util'], function() {
	var util = layui.util;
	var layer = layui.layer;
	
	$(function() {
		loadList(1, 3, "new-tip");
		loadList(1, 5, "hot-tip");
		loadList(1, 5, "audit-tip");
		//绑定技巧跳转链接
		// 		$('a[class="tip-info"]').click(function() {
		// 			var tipId = $(this).attr("data");
		// 			location.href = "/tip/" + tipId + "/detail";
		// 		});
	
		iniSignButton();
		iniWebStatus();
		
		$('button[data-type="sign"]').on("click",function(){
			$.post("/api/member/a/sign",function(rd){
				if(rd.result){
					layer.msg("签到成功，获得 10 积分");
					iniSignButton();
				}
			});
		});
		
		
	});
	function loadList(pageNum, pageSize, boxId) {
		var tipShowBox = $("#" + boxId);
		tipShowBox.empty();
		var getUrl = "/api/tip/release/list";
		$.get(getUrl,{"pageNum":pageNum,"pageSize":pageSize},function(result) {
				$.each(result.data.list,function(n, value) {
					var memberId = value.belongMember.id;
					tipShowBox
							.append('<div class="tip-entry">'
									+ '<div class="tip-record">'
									+ '<div class="member" data="'+memberId+'">'
									+ '<img src="'+value.belongMember.headUrl+'" />'
									+ '<a class="member-info"'+ 'href="/member/'+ memberId+'/space">'+ value.belongMember.nickname+ '</a>'
									+ '<span class="motto">'+value.belongMember.motto+'</span>'
									+ '</div>'
									+ '<div class="tip-info">'
									+'<a class="tip-title"'
									+ 'href="/tip/'+value.id+'/detail">'
									+ value.title
									+ '</a>'
									+ '<div class="tip-bottom">'
									+ '<span class="time">'
									+ getDateDiff(value.gmtCreate)
									+ '</span>'
									+ '<span>'
									+'&nbsp;<i class="layui-icon">&#xe65f;</i>'  
									+ '</span>'
									+ '<span>'+value.commentCount+'<i class="fa fa-commenting-o"></i></span>'
									+ '<span>'
									+'23<i class="fa fa-thumbs-o-up"></i>'  
									+ '</span>'
									+ '<span>'
									+'0<i class="fa fa-thumbs-o-down"></i>'  
									+ '</span>'
									+'</div></div></div></div>');
				});
			});
	}
	
	//ini sign button 
	function iniSignButton(){
		var signButton = $('button[data-type="sign"]');
		var unAbleClass = "layui-btn-disabled";
		var ableClass = "layui-btn-danger";
		if(entryStatus()){
			$.get("/api/member/a/sign",function(rd){
				if(rd.result){
					signButton.addClass(unAbleClass);
					signButton.removeClass(ableClass);
					signButton.text("已签到");
					signButton.attr("data-type","");
					signButton.unbind();
				}else{
					signButton.addClass(ableClass);
					signButton.removeClass(unAbleClass);
				}
			});
		}else{
			signButton.parent().remove();
		}
	}
	
	function iniWebStatus(){
		$.get("/api/m/index",function(rd){
			if(rd.result){
				autoIncrease(rd.data.actMemberNum, $("#actMemberNum"));
			}
		});
	}


	//bottom right
	util.fixbar({
	   bar1: "&#xe642;",
	   click: function(type){
	      console.log(type);
	      if(type === 'bar1'){
	       location.href="/tip/a/write";
	      }
	    }
	});
});
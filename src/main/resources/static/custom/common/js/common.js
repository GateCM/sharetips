$(function() {
	/** member link */
	$("body").on("click", ".member-link", function() {
		var memberId = $(this).attr("data");
		location.href = "/member/" + memberId + "/space";
	});
});

/**paginatoin*/
function iniPaginatoin(pageInfo, boxId) {
	console.log(JSON.stringify(pageInfo));
	var prePage = pageInfo.prePage;
	var nextPage = pageInfo.nextPage;
	var totalPages = pageInfo.pages;
	var hasPreviousPage = pageInfo.hasPreviousPage;
	var hasNextPage = pageInfo.hasNextPage;
	var pageNum = pageInfo.pageNum;
	var isFirstPage = pageInfo.isFirstPage;
	var isLastPage = pageInfo.isLastPage;
	// 加载页码
	var tipPaginationNode = $("#" + boxId);
	tipPaginationNode.empty();
	// 首页
	if (isFirstPage) {
		tipPaginationNode.append('<li class="disabled"><a data="' + 1
				+ '" href="javascript:void(0);">首页</a></li>');
	} else {
		tipPaginationNode.append('<li><a data="' + 1
				+ '" href="javascript:void(0);">首页</a></li>');
	}
	// 上一页
	if (hasPreviousPage) {
		tipPaginationNode
				.append('<li class="previous"><a data="'
						+ prePage
						+ '" href="javascript:void(0);"><i class="fa fa-chevron-left"></i></a></li>');
	} else {
		tipPaginationNode
				.append('<li class="disabled"><a href="javascript:void(0);"><i class="fa fa-chevron-left"></i></a></li>');
	}
	// 页码
	$.each(pageInfo.navigatepageNums, function(index, value) {
		// 当前页判断
		if (pageNum == value) {
			tipPaginationNode.append('<li class="active"><a data="' + value
					+ '" href="javascript:void(0);">' + value + '</a></li>');
		} else {
			tipPaginationNode.append('<li><a data="' + value
					+ '" href="javascript:void(0);">' + value + '</a></li>');
		}
	});
	// 下一页
	if (hasNextPage) {
		tipPaginationNode
				.append('<li class="next"><a data="'
						+ nextPage
						+ '" href="javascript:void(0);"><i class="fa fa-chevron-right"></i></a></li>');
	} else {
		tipPaginationNode
				.append('<li class="disabled"><a href="javascript:void(0);"><i class="fa fa-chevron-right"></i></a></li>');
	}
	// 尾页
	if (isLastPage) {
		tipPaginationNode.append('<li class="disabled"><a data="' + totalPages
				+ '" href="javascript:void(0);">尾页</a></li>');
	} else {
		tipPaginationNode.append('<li><a data="' + totalPages
				+ '" href="javascript:void(0);">尾页</a></li>');
	}
}

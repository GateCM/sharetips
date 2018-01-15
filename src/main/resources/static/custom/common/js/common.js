var CTJ = "application/json; charset=utf-8";

layui.use('element', function() {
	var element = layui.element;

	$(function() {
		/** member space link */
		$(document).on("click", ".member-link", function() {
			var memberId = $(this).attr("data");
			location.href = "/member/" + memberId + "/space";
		});
		iniIndexNav();
	});
	/** ini index nav */
	function iniIndexNav() {
		var currentNav = location.href.split("/").pop();
		$('.main-nav li[data="' + currentNav + '"]').addClass("layui-this");
	}
});

function entryStatus() {
	var memberId = $("#lmInfo").attr("data");
	if (memberId !=undefined) {
		return true;
	}
	return false;
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

$(function() {
	/** member link */
	$("body").on("click", ".member-link", function() {
		var memberId = $(this).attr("data");
		location.href = "/member/" + memberId + "/space";
	});
});

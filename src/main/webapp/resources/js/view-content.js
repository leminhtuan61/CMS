$(document).ready(function() {

	$("#button-search").click(function() {
		var title = $("#search-title").val();
		var contextPath = $(this).attr("contextPath");

		document.location = contextPath + "/search-content/" + title;

	})
});
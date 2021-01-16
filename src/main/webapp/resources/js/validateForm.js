$().ready(function() {
	$("#addContent-form").validate({
		rules : {
			title : {
				required : true,
				minlength : 10,
				maxlength : 200,
			},
			brief : {
				required : true,
				minlength : 30,
				maxlength : 150,
			},
			content : {
				required : true,
				minlength : 50,
				maxlength : 1000,
			},
		},
		messages : {
			title : {
				required : "You must input title",
				minlength : "Title must contain at least 10 character",
				maxlength : "Title maximum 200 character",
			},
			brief : {
				required : "You must input brief",
				minlength : "Brief must contain at least 30 character",
				maxlength : "Brief maximum 150 character",
			},
			content : {
				required : "You must input content",
				minlength : "Content must contain at least 50 character",
				maxlength : "content maximum 1000 character",
			},
		},

	});
});
$(document).ready(function() {

	$("#button-search").click(function() {
		var title = $("#search-title").val();
		var contextPath = $(this).attr("contextPath");
		$.get({
			url : contextPath + "/find/"+title,

		});
	})
});
$(document).ready(function() {
	$("#editProfile-form").validate({
		rules : {
			firstName : {
				required : true,
				minlength : 3,
				maxlength : 30,
			},
			lastName : {
				required : true,
				minlength : 3,
				maxlength : 30,
			},
			phone : {
				required : true,
				minlength : 9,
				maxlength : 13,
			},
			description : {
				maxlength : 200,
			},
		},
		messages : {
			firstName : {
				required : "You must input first name",
				minlength : "First name must contain at least 3 character",
				maxlength : "First name maximum 30 character",
			},
			lastName : {
				required : "You must input last name",
				minlength : "Last name must contain at least 3 character",
				maxlength : "Last name maximum 30 character",
			},
			phone : {
				required : "Your must input Phone",
				minlength : "Phone number must contain at least 9 number",
				maxlength : "Phone number maximum 13 number",
			},
			description : {
				maxlength : "maximum description is 200 character",
			},
		},

	});
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

	$.validator.addMethod("maxDate", function(value, element) {
		var curDate = new Date();
		var inputDate = new Date(value);
		if (inputDate < curDate)
			return true;
		return false;
	}, "Invalid date of birth");
});
$().ready(function() {
	$("#customer-form").validate({
		rules : {
			fullName : {
				required : true,
				minlength : 3,
				maxlength : 30
			},
			dateOfBirth : {
				required : true,
				minlength : 5
			},
			password : {
				required : true,
				minlength : 8,
				maxlength : 50
			},
			rePassword : {
				equalTo : "#password",
				minlength : 8
			},
			username : {
				equalTo : "#password",
				minlength : 8
			},
			email : {
				equalTo : "#password",
				minlength : 8
			},
			identityCard : {
				equalTo : "#password",
				minlength : 8
			},
			rePassword : {
				equalTo : "#password",
				minlength : 8
			}
		},
		messages : {
			username : {
				required : "you must input username",
				minlength : "Username must contain 3 character",
				maxlength : "Username maximum 30 character"
			},
			email : {
				required : "You must input email.",
				minlength : "Email must contain 5 character"
			},
			password : {
				required : "You must input password",
				minlength : "Password must contain 8 character",
				maxlength : "Password maximum 30 character"
			},
			rePassword : {
				equalTo : "Your Re password does not match",
				minlength : "Password must contain 8 character"
			}
		}
	});
});
$().ready(function() {
	$("#login").validate({
		rules : {
			email : {
				required : true,
				minlength : 5,
				maxlength : 50
			},
			password : {
				required : true,
				minlength : 8,
				maxlength : 30
			}
		},
		messages : {
			email : {
				required : "You must input email.",
				minlength : "Email must contain 5 character",
				maxlength : "email maximum 50 character"
			},
			password : {
				required : "You must input password",
				minlength : "Password must contain 8 character",
				maxlength : "Password maximum 30 character",
			}
		}
	});
});


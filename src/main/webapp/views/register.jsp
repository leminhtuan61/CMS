<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/register.css">

<title>Register page</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">Register</div>
				
					<label style="color: green">${message}</label>
				
			
					<label style="color: red">${messageErr}</label>
				

				<div class="card-body">
					<form:form id="register-form"
						action="${pageContext.request.contextPath}/processRegister"
						method="post" modelAttribute="member">
						<div class="input-group form-group">
							<form:input type="text" class="form-control"
								placeholder="Username" path="userName" id="userName" />
							<form:errors path="userName" cssClass="error" />
						</div>
						<div class="input-group form-group">
							<form:input type="email" class="form-control"
								placeholder="E-mail" path="email" id="email" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="input-group form-group">
							<form:input type="password" class="form-control"
								placeholder="Password" path="password" id="password" />
							<form:errors path="password" cssClass="error" />
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control"
								placeholder="Re Password" name="rePassword" id="rePassword">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Register</button>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/">Click here to
								Login</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/validate.js"></script>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>
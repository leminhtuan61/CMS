<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	href="${pageContext.request.contextPath}/resources/css/login.css">

<title>Login page</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">Please Sign In</div>
				<label style="color: red">${message}</label>

				<div class="card-body">

					<form:form id="login"
						action="${pageContext.request.contextPath}/login" method="post"
						modelAttribute="member">

						<div class="input-group form-group">
							<label for="email-login"></label>
							<form:input path="email" id="email-login" 
								class="form-control" placeholder="E-mail" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="input-group form-group">
							<label for="password-login"></label>
							<form:input path="password" type="password" id="password-login"
								class="form-control" placeholder="Password" />
							<form:errors path="password" cssClass="error" />
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Remember Me
						</div>
						<div class="form-group">

							<button type="submit" class="btn btn-success">Login</button>

						</div>
						<div>
							<a href="${pageContext.request.contextPath}/register">Click
								here to Register</a>
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
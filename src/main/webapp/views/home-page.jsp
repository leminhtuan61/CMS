<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/edit-profile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>CMS</title>
</head>

<body>
	<nav class="navbar">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">CMS</a>

		<div class="btn-group mb-btn">
			<button class="btn dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown">
				<i class="fas fa-user"></i>
			</button>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/edit-profile"><i
					class="fas fa-user"></i> User Profile</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/view-content"
					id="viewContent"><i class="fa fa-table" aria-hidden="true"></i>
					View contents</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/form-content"
					id="formContent"><i class="far fa-edit"></i> Form content</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/logout"><i
					class="fas fa-sign-out-alt"></i> Logout</a>
			</div>
		</div>

		<input class="form-control search-btn-mb" type="text"
			placeholder="Search" aria-label="Search">

		<div class="btn-group tbl-btn">
			<button class="btn dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown">
				<i class="fas fa-user"></i>
			</button>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/edit-profile"><i
					class="fas fa-user"></i> User Profile</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item view-contents list-group-items"
					href="${pageContext.request.contextPath}/logout"><i
					class="fas fa-sign-out-alt"></i> Logout</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid h-100">
		<div class="row h-100">
			<div class="col-md-2 col">
				<ul class="flex-column nav-pills list-group" role="tablist">
					<li class="list-group-item">
						<div class="input-group">
							<input type="text" class="form-control" id="search-title"
								placeholder="Search..." />
							<div class="input-group-append">
								<button type="button" id="button-search"
									class="input-group-text"
									contextPath="${pageContext.request.contextPath}">
									<i class="fas fa-search text-grey" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</li>
					<li class="list-group-item"><a
						class="view-contents list-group-items"
						href="${pageContext.request.contextPath}/view-content"
						id="viewContent1"><i class="fa fa-table" aria-hidden="true"></i>
							View contents</a></li>
					<li class="list-group-item"><a
						class="view-contents list-group-items"
						href="${pageContext.request.contextPath}/form-content"
						id="formContent1"><i class="far fa-edit"></i> Form content</a></li>
				</ul>
			</div>
			<div class="col-md-10 col-sm-12 col">
				<div class="tab-content" id="tab-content">
					<img
						src="https://media3.giphy.com/media/bcKmIWkUMCjVm/giphy.gif?cid=ecf05e47qv9e9y4r7cdhpb728pcytgpeln4uokb38br1el5h&rid=giphy.gif"
						alt="Trulli" width="1560" height="744">

				</div>
			</div>
		</div>
	</div>

</body>

</html>
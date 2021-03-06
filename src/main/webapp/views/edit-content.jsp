<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
					<p class="h2">Add Content</p>
					<hr />
					<div class="card edit-profile">
						<div class="card-header">Content Form Elements</div>
						<div class="card-body">
							<form:form id="addContent-form"
								action="${pageContext.request.contextPath}/add-content"
								method="post" modelAttribute="content">
								<label for="title">
									<p class="h5">Title</p>
								</label>
								<div class="input-group form-group">
									<form:input type="text" class="form-control"
										placeholder="Enter the title" id="title" path="title"
										value="${content.title}" />
										<form:errors path="title" cssClass="error" />
								</div>

								<div class="input-group form-group">
									<form:input type="hidden" class="form-control"
										placeholder="Enter the title" id="contentId" path="contentId"
										value="${content.contentId}" />
					
								</div>

								<label for="Brief">
									<p class="h5">Brief</p>
								</label>
								<form:textarea class="form-control" rows="5" id="brief"
									path="brief" value="${content.brief}" />
									<form:errors path="brief" cssClass="error" />
								<label for="content">
									<p class="h5">Content</p>
								</label>
								<form:textarea class="form-control" rows="5" id="content"
									path="content" value="${content.content}" />
								<div class="form-group">
								<form:errors path="content" cssClass="error" />
									<button type=submit id="btn-addEmp"
										class="btn btn-outline-secondary">Submit Button</button>
									<button type="reset" id="btn-addEmp"
										class="btn btn-outline-secondary">Reset Button</button>
								</div>
							</form:form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/validate.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/view-content.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/edit-content.js"></script>
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
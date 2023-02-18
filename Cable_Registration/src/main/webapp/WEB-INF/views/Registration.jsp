<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

	<div class="container ">
		<h3 class="mt-4 text-center text-primary">Cable TV Registration
			Form</h3>
		<form action="./saveForm" method="post" enctype='multipart/form-data'
			class="form-group">
			<div class="row mx-auto">
				<div class="mx-auto pt-4 mt-4 col-md-4">
					<label>Provider Name*</label> <select class="custom-select"
						name="provider" required>
						<option selected="selected">Choose..</option>

						<c:forEach items="${providerList}" var="provider">
							<option value="${provider.provider_id}">${provider.provider_name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="mx-auto pt-4 mt-4 col-md-4">
					<label>Subscription For*</label> <select class="custom-select"
						name="subscription" required>
						<option selected="selected">Choose..</option>
						<c:forEach items="${SubList}" var="subscription">
							<option value="${subscription.subscription_id}">${subscription.subscription_type }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<fieldset class=" mt-5 border border-dark p-2">
				<legend class="w-25 ">Application Details</legend>
				<div class="row mt-3">
					<div class="col-sm-4">
						<label>Name*</label><br> <input type="text"
							name="applicant_name" class="form-control" required>
					</div>
					<div class="col-sm-4">
						<label>Email*</label><br> <input type="email"
							name="email_id" class="form-control" required>
					</div>
					<div class=" col-sm-4">
						<label>Mobile No*</label><br> <input type="text"
							name="mobile_no" class="form-control" required>
					</div>

				</div>
				<div class="mt-4 row">
					<div class=" col-sm-4">
						<label>Date of Birth*</label><br> <input type="text"
							id="datepicker" name="dob" class="form-control" required>
					</div>
					<div class=" col-sm-4">
						<label>Gender*</label><br>
						<div class="form-control">
							<input type="radio" name="gender" value="Male">Male
							&nbsp;&nbsp; <input type="radio" name="gender" value="Female">Female
							&nbsp;&nbsp;

						</div>
					</div>
					<div class=" col-sm-4">
						<label>Upload Address Proff*</label><br> <input type="file"
							name="image" accept="image/png , image/gif , image/jpeg"
							class="form-control" required>
					</div>
				</div>
				<div class="text-center mt-4">
					<input type="submit" class="btn btn-outline-primary"> <input
						type="reset" class="btn btn-outline-dark" required>
				</div>
			</fieldset>


		</form>
	</div>

	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
</body>
</html>
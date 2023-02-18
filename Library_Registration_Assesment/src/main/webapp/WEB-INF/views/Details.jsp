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
</head>
<body>
	<div class="container">
		<h3 class="display-4 text-primary text-center">Registration
			Details</h3>
		<form action="./searchData" method="get">
			<fieldset class=" mt-5 border border-dark p-2">
				<legend class="w-25 ">Filter</legend>
				<div class="row">
					<div class="col-sm-4 mt-2">

						<select name="library" class="form-control">
							<option selected>Choose..</option>
							<c:forEach items="${LibraryList}" var="library">
								<option value="${library.library_id}">${library.library_name}</option>

							</c:forEach>

						</select> <span id="nameerr" style="color: red;"></span>
					</div>
					<div class="col-sm-4 mt-2">
						<input type="submit" class="btn btn-primary" id="serach"
							value="Search">
					</div>
				</div>
			</fieldset>
		</form>
		<table class="table table-striped table-bordered">
			<thead>
				<th>S.No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>Image</th>
				<th>Library Name</th>
				<th>Subscription Type</th>
				<th>Fees</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach items="${searchLibrary}" var="details">
					<tr>
						<td>${details.registration_id}</td>
						<td>${details.applicant_name }</td>
						<td>${details.email_id }</td>
						<td>${details.mobile_no }</td>
						<td>${details.image_path }</td>
						<td>${details.library.library_name}</td>
						<td>${details.subscription.type }</td>
						<td>${details.subscription.fees}</td>
						<td>
							<a href="./updateDetails?registration_id=${details.registration_id}">Update</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
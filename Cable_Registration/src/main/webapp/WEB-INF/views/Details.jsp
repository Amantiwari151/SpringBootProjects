<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
</style>
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h3 class="display-4 text-primary text-center">Registration Details</h3>
		<table id="datatable" class="table table-striped table-bordered">
			<thead>
				<th>S.No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>Document</th>
				<th>Provider Name</th>
				<th>Subscribed</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach items="${DetailList}" var="details">
					<tr>
						<td>${details.registration_id}</td>
						<td>${details.applicant_name }</td>
						<td>${details.email_id }</td>
						<td>${details.mobile_no }</td>
						<td>${details.image_path }</td>
						<td>${details.provider.provider_name}</td>
						<td>${details.subscription.subscription_type }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$('document').ready(function(){
				$('#datatable').DataTable();
		});
	</script>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Latest compiled and minified CSS -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="patientvalidation.js" ></script> 


</head>
<body>
	   
			

		
		
		<div class="container">
		
		
			<div class="display-4 text-primary text-center ">Library Registration Form</div>
		
		
	
		
		
<form action="./dataRegister" class="form-group w-50 mx-auto" method="post" enctype="multipart/form-data" 
onsubmit="return CheckValidation()">
 	<input  type="hidden" name="registration_id">
	<div class="row text-primary font-weight-bold" >
	
	
	
	<div class="col-sm-6 pt-5">		
	 <label>Library Name*:</label>
	  <select name="library" class="form-control">
	  	<option selected>Choose..</option>
	  		<c:forEach items="${LibraryList}" var="library">
	  			<option value="${library.library_id}">${library.library_name}</option>
	  			
	  		</c:forEach>
	  
	  </select>
	   <span id="nameerr" style="color: red;"></span>
	   </div>
	   
	   <div class="col-sm-6 pt-5">		
	 <label>Subscription Type*:</label>
	  <select name="subscription" class="form-control">
	  	<option>
	  			  	<option selected>Choose..</option>
	  		
	  		<c:forEach items="${SubList}" var="sub">
	  			<option value="${sub.subscriptionId}">${sub.type}</option>
	  			
	  		</c:forEach>
	  	</option>
	  </select>
	   <span id="nameerr" style="color: red;"></span>
	   </div>



				<div class="col-sm-4 mt-5" >
					<label>Name*</label> 
					<input type="text" value="${update.applicant_name}" name="applicant_name" id="name"  class="form-control" /> 
					
					<span id="nameerr" style="color: red;"></span> <br>

				</div>

				<div class="col-sm-4 mt-5">
					<label>Email*</label> 
					<input type="email" value="${update.email_id}" name="email_id" id="fathername"  class="form-control" />
					<span id="fnerr" style="color: red;"></span><br>
				</div>

				<div class="col-sm-4 mt-5">
					<label>Mobile Number* :</label> 
					
					<input type="text" value="${update.mobile_no}" name="mobile_no" id="num" class="form-control"
						maxlength="10" minlength="10"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
						onchange="getDet()">
						
						<span id="numerr" style="color: red;"></span> <br>
				</div>

				<div class="col-sm-4">
					<label>Date of Birth* :</label> 
					<input type="text" value="${update.date}" id="datepicker" name="date"  class="form-control"> 
					<span id="ageerr" style="color: red;"></span><br>
				</div>

				<div class="col-sm-4">
					<label>Gender</label>
					<div class="form-control ">

						<input type="radio"  name="gender" id="male" value="male">Male
						&nbsp&nbsp <input type="radio" name="gender" id="female"
							value="female">Female
					</div>
					<span id="gendererr" style="color: red;"></span> <br>
				</div>


				<div class="col-sm-4">
					<label>Image:</label> <input type="file" name="image" id="image"
						class="form-control" accept="image/png, image/gif, image/jpeg">
					<span id="imggerr" style="color: red;"></span><br>
				</div>



			</div>
		
			<div class="text-center">
	  <input class="btn btn-outline-primary" type="submit"> 
	  <input class="btn btn-outline-dark" type="reset">
	  </div>
 
</form>
	</div>
		
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
		
		
		
		
		
</body>
</html>












  
	 <%--  <div class="col-sm-4">	
	  	<label>Type</label> 
	  	
	  	 <select multiple="multiple" name="department">
	  <c:forEach items="${dept }" var="d">
	  
	  		<option value="${d.name }" <c:if test="${d.name.equals(user.department)}">selected="selected"</c:if> >${d.name }</option>
	  </c:forEach>
	  
	  </select>
	  	<span id="ageerr" style="color: red;"></span><br> 
	  </div> --%>
	  
	  <%--  <div class="col-sm-12">	
	  	<label>Consulting Department:</label> 
	  	<div  class="form-control ">
	  	<c:forEach items="${dList}" var="dl">
		  	<input type="checkbox" name="dept" id="dept" value="${dl.id}">&nbsp${dl.name} 
	  	</c:forEach>
	  	<p id="depterr" style="color: red;"></span>
	  	</div>
	  	<br> 
	  </div> --%>
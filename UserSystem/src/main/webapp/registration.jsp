<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<h2 class="text-center">Registration Form</h2>
			<form action="<%=request.getContextPath()%>/RegistrationController" method="post">
			<div class="form-group">
                        <label for="fisrtName">First Name</label>
                        <input type="text" class="form-control" id="fisrtName" name="firstName" placeholder="Enter First Name" required>
 			</div>
 			<div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name" required>
 			</div>
 			<div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email" required>
 			</div>
 			<div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter 11 digits Phone" required>
 			</div>
 						<button type="submit" class="btn btn-primary btn-block">Register</button>
 			</form>
 		</div>
 	</div>
</div>
</body>
</html>
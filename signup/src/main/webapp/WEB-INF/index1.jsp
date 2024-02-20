<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Campus Portal System</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Welcome to Campus Portal System</h1>
        <h3>Registration </h3>
        
        <div class="row">
            <div class="col-md-3">
                <a href="registration.jsp" class="btn btn-primary btn-block">Student Registration</a>
            </div>
            <div class="col-md-3">
                <a href="" class="btn btn-primary btn-block">Teacher Registration</a>
            </div>
            <div class="col-md-3">
                <a href="" class="btn btn-primary btn-block">HOD Registration</a>
            </div>
		<div class="col-md-3">
                <a href="" class="btn btn-primary btn-block">TPO Registration</a>
            </div>
            
        </div>

        <hr>

        <h3>Login</h3>
        <div class="row">
            <div class="col-md-3">
                <a href="login.jsp" class="btn btn-success btn-block">Student Login</a>
            </div>
            <div class="col-md-3">
                <a href="" class="btn btn-success btn-block">Teacher Login</a>
            </div>
            <div class="col-md-3">
                <a href="" class="btn btn-success btn-block">HOD Login</a>
            </div>
		 <div class="col-md-3">
                <a href="" class="btn btn-success btn-block">TPO Login</a>
            </div>
           
        </div>
    </div>

    <!-- Bootstrap JS and jQuery (add at the end of the body to improve page load time) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
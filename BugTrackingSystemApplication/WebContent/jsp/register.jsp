<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap" rel="stylesheet"/>
	
    <link rel="stylesheet"  href="/BugTrackingSystemApplication/css/registrationStyle.css"/>
	
    <script type="text/javascript" src="/BugTrackingSystemApplication/js/registrationPageValidation.js"></script>
	
</head>

<body>

    <section id="nav-bar">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/BugTrackingSystemApplication/jsp/home.jsp" style="font-size: 60px;"><i
                        class="fas fa-bug fa-spin"></i>&nbsp;BugTracker</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">

                        </li>

                    </ul>
                </div>
            </div>
        </nav>
    </section>
    <form action="/BugTrackingSystemApplication/jsp/RegistrationServlet" method="POST" onsubmit="return validateForm() ">
        <h1 align="center">Register</h1>
        <hr>
	<h4>
        <div class="box">
            <label>Email Address</label>
            <input type="text" name="email" id="email" placeholder="Enter email">
            <div class="error" id="emailErr"></div>
        </div>
        <div class="box">
            <label>Role</label>
            <select name="role" id="role" required>
                <option>Select Role</option>
                <option>ProjectManager</option>
                <option>Developer</option>
                <option>Tester</option>
            </select>
            <div class="error" id="roleErr"></div>
        </div>
        <div class="box">
            <label>Password</label>
            <input type="password" name="psw" id="psw" placeholder="Enter password">
            <div class="error" id="passErr"></div>
        </div>
        <div class="box">
            <label> Confirm Password</label>
            <input type="password" name="passcheck" id="passcheck" placeholder="Re-enter password">
            <div class="error" id="passcheckErr"></div>
        </div>
	
            <input type="submit" class="registerbtn" value="Register" >
            <h4>Already have an account? <a href="/BugTrackingSystemApplication/jsp/login.jsp">Login</a></h4>
    </h4>
           
       
    </form>
   <center> <h2>${requestScope.message}</h2></center>
	<br>
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
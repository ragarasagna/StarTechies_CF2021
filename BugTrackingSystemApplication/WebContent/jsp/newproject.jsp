<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/BugTrackingSystemApplication/css/newprojectstyle.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Project Manager Page</title>

</head>



<body>
	<%@page import="java.util.*, com.hsbc.beans.Users, com.hsbc.beans.Bugs"%>
	<%
		ArrayList<Users> developers = (ArrayList<Users>) request.getAttribute("developers");
		pageContext.setAttribute("developers", developers);
		ArrayList<String> testers = (ArrayList<String>) request.getAttribute("testers");
		pageContext.setAttribute("testers", testers);
	%>
	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container-fluid">
				<a class="navbar-brand"
					href="/BugTrackingSystemApplication/jsp/home.jsp"
					style="font-size: 60px;"><i class="fas fa-bug fa-spin"></i>&nbsp;Bug
					Tracker</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarText"
					aria-controls="navbarText" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<span class="navbar-text">
					<div class="collapse navbar-collapse" id="navbarText">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="btn btn-warning"
								href="/BugTrackingSystemApplication/jsp/pmpage.jsp"
								role="button"><i class="fas fa-user"></i> Profile</a></li>&nbsp;&nbsp;&nbsp;

							<li class="nav-item"><a class="btn btn-warning"
								href="/BugTrackingSystemApplication/jsp/ProjectsServlet/Details"
								role="button"><i class="fas fa-tasks"></i> Project Details</a></li>&nbsp;&nbsp;&nbsp;
							<li class="nav-item"><a class="btn btn-warning"
								href="/BugTrackingSystemApplication/jsp/ProjectsServlet/LogOut"
								role="button"><i class="fas fa-sign-out-alt"></i> Logout</a>
								</button></li>
						</ul>
					</div>
				</span>

			</div>
		</nav>
	</section>
	<br>
	<form action="/BugTrackingSystemApplication/jsp/ProjectsServlet/"
		method="POST">
		<div class="container">
			<b>
				<h3 align="center">Create New Project</h3>
			</b>
			<hr>
			<label for="pname"><b>Project Name</b></label> <br> <input
				type="text" placeholder="Enter name" name="pname" id="pname"
				required> <br> <label for="sdate"><b>Start
					Date</b></label><br> <input type="text" name="sdate"
				class="form-control datepicker"
				placeholder="Choose the starting date" autocomplete="off" required>
			<!--  <input type="date" placeholder="Choose the starting date" name="sdate" id="sdate"
                            required><br><br>-->
			<br> <label for="desc"><b>Description</b></label><br>
			<textarea placeholder="Enter Description" name="desc" id="desc"
				required rows="2" cols="80"></textarea>
			<br> <label for="team"><b>Assign Team Members</b></label>
			<!---- Select Developers-->
			<br> <b>Select developers</b> <br>
			<div class="devTeam">
				<c:forEach items="${developers}" var="user">
					<input type="checkbox" name="teamMembers" value="${user.userName}" />${user.userName}
                                <br>
				</c:forEach>

			</div>
			<br> <b>Select Tester</b> <br>
			<div class="testerTeam">
				<c:forEach items="${testers}" var="user">
					<input type="radio" name="teamMembers" value="${user}" />${user}
                                <br>
				</c:forEach>
			</div>

			<hr>
			<button type="submit" class="teambtn" align="center">Submit</button>
		</div>

	</form>
	<footer class="container-fluid text-center">
		<p>
			<i class="fa fa-copyright"></i>All Rights Reserved
		</p>
	</footer>

</body>
<script type="text/javascript">
	var myDate = new Date();
	$('.datepicker').datepicker({
		startDate : new Date(myDate.getTime() + 2 * 24 * 60 * 60 * 1000)
	});
</script>


</html>
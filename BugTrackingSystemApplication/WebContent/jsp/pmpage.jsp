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
	href="/BugTrackingSystemApplication/css/ptdstyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Project Manager Page</title>
</head>

<body>
<%
Integer projectCounter= (Integer)session.getAttribute("projectCounter");
//int pc= Integer.parseInt(projectCounter);
pageContext.setAttribute("projectCounter", projectCounter);
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
							<c:if test="${projectCounter<4}">
								<li class="nav-item"><a class="btn btn-warning"
									href="/BugTrackingSystemApplication/jsp/ProjectsServlet/NewProject"
									role="button"><i class="fas fa-project-diagram"></i> New
										Project</a>
							</c:if>
							</li>&nbsp;&nbsp;&nbsp;
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
	<br>
	<br>
	<form>
		<div class="container">
			<h1 align="center">Profile</h1>
			<hr>
			<label for="email"><b>Email</b></label>
			<p><%=session.getAttribute("emailId")%></p>

			<label for="role"><b>Role</b></label>
			<p><%=session.getAttribute("role")%></p>
			<label for="lastlogin"><b>Last Login</b></label>
			<p><%=session.getAttribute("last_login")%></p>
            <!-- <h4 align="center" style="color:red"> You Can Create Up To 4 Projects</h4>-->
            <table align="center" cellpadding="2" width="100%">
                <tr style="background-image: linear-gradient(to left, red, rgb(136, 48, 48)); height:40px;color: white;" class="whitetext" align="center" color= white>
                  <th><h5> You Can Create Up To 4 Projects</h5> </th>
                </tr>
                </table>
		</div>

	</form>


	<footer class="container-fluid text-center">
		<p>
			<i class="fa fa-copyright"></i>All Rights Reserved
		</p>
	</footer>

</body>

</html>
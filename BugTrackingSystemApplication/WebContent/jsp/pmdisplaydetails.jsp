<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet"
	href="/BugTrackingSystemApplication/css/display.css" />
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../js/statusupdate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Project Manager Page</title>

</head>

<body>
	<%@page import="java.util.*, com.hsbc.beans.Users, com.hsbc.beans.Bugs"%>
	<%
		ArrayList<Users> users = (ArrayList<Users>) request.getAttribute("team");
		pageContext.setAttribute("team", users);
		ArrayList<Bugs> bugs = (ArrayList<Bugs>) request.getAttribute("bugslist");
		pageContext.setAttribute("bugslist", bugs);

		ArrayList<Users> devlist = (ArrayList<Users>) request.getAttribute("developerList");
		pageContext.setAttribute("devlist", devlist);

		String projectName = (String) request.getAttribute("projectname");
		pageContext.setAttribute("projectName", projectName);
		HttpSession session1 = request.getSession();
		session1.setAttribute("projectname", projectName);
		String managerName = (String) request.getAttribute("managername");
		pageContext.setAttribute("managerName", managerName);
	%>
	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/BugTrackingSystemApplication/jsp/home.jsp" style="font-size: 60px;"><i
					class="fas fa-bug fa-spin"></i>&nbsp;Bug Tracker</a>
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
								href="/BugTrackingSystemApplication/jsp/ProjectsServlet/NewProject"
								role="button"><i class="fas fa-project-diagram"></i> New
									Project</a></li>&nbsp;&nbsp;&nbsp;
							<li class="nav-item"><a class="btn btn-warning"
								href="/BugTrackingSystemApplication/jsp/ProjectsServlet/Details"
							
								role="button"><i class="fas fa-tasks"></i> Project Lists</a></li>&nbsp;&nbsp;&nbsp;
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
	<form  method="POST"  name="severity" id="severity" action="/BugTrackingSystemApplication/jsp/BugsServlet/filter" style="border: transparent"></form>
	<form method="POST" id="assign" name="assign"
		action="/BugTrackingSystemApplication/jsp/BugsServlet/pmdisplaydetails">
		<div class="container">
			<h1 align="center">Project Details</h1>
			<hr>

			<label for="pname"><b>Project Name</b></label>
			<p>
				<%=request.getAttribute("projectName")%></p>

			<label for="sdate"><b>Start Date</b></label>
			<p>
				<%=request.getAttribute("date")%></p>

			<label for="pmanager"><b>Project Manager</b></label>
			<p>
				<%=request.getAttribute("managername")%></p>

			<label for="team"><b>Team members</b></label>

			<table align="center" cellpadding="2" width="100%">
				<tr bgcolor="black" class="whitetext" align="center"
					style="color: white">
					<th>Name</th>
					<th>Role</th>
				</tr>
				<c:forEach items="${team}" var="user">
					<tr>
						<td>${user.userName }</td>
						<td>${user.userRole }</td>
					</tr>
				</c:forEach>

			</table>


			<br> <label for="bugs"><b>Bugs List</b></label>

			<table>
				<tr bgcolor="black" class="whitetext" align="center"
					style="color: white">
					<!--td>Bug ID</td-->
					<th><div class="dropdown mt-1">
							Bug Names
							<button type="button" class="btn btn-danger dropdown-toggle"
								data-toggle="dropdown">
								<i class="fas fa-filter"></i>
							</button>

							<div class="dropdown-menu">

								<select class="form-control" size=5 onchange="severity.submit()" name="filter" form="severity">
									<option value="default" selected>Choose severity</option>
									<option value="all" >All</option>
									<option value="critical">Critical</option>
									<option value="major">Major</option>
									<option value="minor">Minor</option>
									<option value="trivial">Trivial</option>
								</select>
							</div>
						</div></th>
					<th>Severity Level</th>

					<th>Description</th>
					<th>Present status</th>
					<th>Marked For Closing</th>
					<th>Assigned To&nbsp;&nbsp;&nbsp;</th>
					<th>Close&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>

				</tr>

				<c:forEach items="${bugslist}" var="bug">
					<tr>
						<td>${bug.bugTitle }</td>
						<td>${bug.severityLevel }</td>
						<td>${bug.bugDesc }</td>
						<td>${bug.bugStatus }</td>
						<td>${bug.markedForClosing}</td>
						<td>${bug.assignedTo}</td>
						<!-- <td><input type="hidden" value="${bug.bugId}" name="h1" ><input type="hidden" value="${projectName}" name="projectName"></td>
						<td><select name="devName">
								<option value="" selected>Selected</option>
								<c:forEach items="${devlist}" var="developer">
									<option value="${developer.userName}">${developer.userName}</option>
								</c:forEach>
						</select></td> 

						<td><c:if test="${bug.bugStatus.equalsIgnoreCase('open')}">
								 <input type="submit" value="Assign">
								   <input type="button" value="Assign"
									onclick="window.location.href='/BugTrackingSystemApplication/jsp/BugsServlet/${projectName}/AssignBug/${bug.bugId }'">
						
							</c:if></td>
							-->
						<td><c:if
								test="${bug.markedForClosing.equalsIgnoreCase('yes') && bug.bugStatus.equalsIgnoreCase('inprogress')}">
								<input type="button" value="close"
									onclick="window.location.href='/BugTrackingSystemApplication/jsp/ProjectsServlet/Details/${projectName}/close/${bug.bugId }'" />

							</c:if></td>

					</tr>
				</c:forEach>
				
			</table>
			
			<br> <label for="bugs"><b>Assign Bugs</b></label>
			<table>
				<tr bgcolor="black" class="whitetext" align="center"
					style="color: white">
					<th>Bug Title&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>Developers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				</tr>
				<tr >
					<td><input type="hidden" value="${projectName}" name="projectName">
					<input type="hidden" value="${projectName}" name="projectName1" form="severity">
					<select name="bugId">
								<option align="center" value="Bugs" selected>Bugs</option>
								<c:forEach items="${bugslist}" var="bug">
									<c:if test="${bug.bugStatus.equals('Open')}">
									<option value="${bug.bugId}">${bug.bugTitle}</option>
									</c:if>
								</c:forEach>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
					<td ><select name="devName">
							<option value="Developers" selected>Developers</option>
							<c:forEach items="${devlist}" var="developer">
								<option value="${developer.userName}">${developer.userName}</option>
							</c:forEach>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="submit" value="Assign">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>

		<input type="hidden" name="managername" value=" ${managername}" >
	</form>

	<br>
	<br>
	<br>

	<footer class="container-fluid text-center">
		<p>
			<i class="fa fa-copyright"></i>All Rights Reserved
		</p>
	</footer>

</body>

</html>
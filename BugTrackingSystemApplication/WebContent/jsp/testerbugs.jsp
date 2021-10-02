<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="java.util.List" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>



<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!--link rel="stylesheet" href="../css/ptdstyle.css" /-->
    <link rel="stylesheet" href="/BugTrackingSystemApplication/css/display.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tester Page</title>
</head>

<body >


<%@page import="java.util.*, com.hsbc.beans.Users, com.hsbc.beans.Bugs"%>
<%
	ArrayList<Bugs> buglist = (ArrayList<Bugs>) request.getAttribute("testerbuglist");
	pageContext.setAttribute("buglist", buglist);
	int length= buglist.size();
	pageContext.setAttribute("length", length);
    

%>
    <section id="nav-bar">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="home.html" style="font-size: 60px;"><i class="fas fa-bug fa-spin"></i>&nbsp;Bug Tracker</a>                            
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <span class="navbar-text">
                    <div class="collapse navbar-collapse" id="navbarText">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/testerpage.jsp" role="button"><i
                                        class="fas fa-user"></i> Profile</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            
                            <li class="nav-item">
                                <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/BugsServlet/ReportNewBug" role="button"><i
                                        class="fas fa-spider"></i> Report Bugs</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/ProjectsServlet/LogOut" role="button"><i
                                        class="fas fa-sign-out-alt"></i> Logout</a>
                                </button>
                            </li>
                        </ul>
                        </div>
                </span>
            
            </div>
        </nav>
    </section>                                
    <br><br><br>

    
    <form>
        <div class="container">
            <h2 align="center">Project Details</h2>
            <hr>

<c:choose>
  <c:when test="${length==0}">
    <h3 align="center">No Bugs Created Yet</h3>
  </c:when>
  
  <c:otherwise>
    <table align="center" cellpadding="5" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
               
                <th>Project Name</th>
                <th>Bug Name</th>
                <th>Description</th>
                <th>Severity Level</th>
                </tr>
                
                <c:forEach items="${buglist}" var="bug">
					<tr align="center">
						<td>${bug.projectName }</td>
						<td>${bug.bugTitle }</td>
						<td>${bug.bugDesc }</td>
						<td>${bug.severityLevel }</td>
					</tr>
				</c:forEach>
                </table>
  </c:otherwise>
</c:choose>


            <!--  <table align="center" cellpadding="5" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
               
                <th>Project Name</th>
                <th>Bug Name</th>
                <th>Description</th>
                <th>Severity Level</th>
                </tr>
                
                <c:forEach items="${buglist}" var="bug">
					<tr align="center">
						<td>${bug.projectName }</td>
						<td>${bug.bugTitle }</td>
						<td>${bug.bugDesc }</td>
						<td>${bug.severityLevel }</td>
					</tr>
				</c:forEach>
                </table>-->
        </div>

    </form>

<br><br>
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
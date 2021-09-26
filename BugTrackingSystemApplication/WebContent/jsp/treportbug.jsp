<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="java.util.List" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link rel="stylesheet" href="/BugTrackingSystemApplication/css/ptdstyle.css" />
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
<%@page import="java.util.*, com.hsbc.beans.Project"%>
	<%
		List<Project> projects = (ArrayList<Project>)request.getAttribute("testerprojects");
		pageContext.setAttribute("projects", projects);
	    
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
                                <a class="btn btn-warning" href="testerpage.html" role="button"><i
                                        class="fas fa-user"></i> Profile</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href=""/BugTrackingSystemApplication/jsp/BugsServlet/BugsReported"" role="button"><i
                                        class="fas fa-tasks"></i> Projects</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href="home.html" role="button"><i
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
    <form action="/BugTrackingSystemApplication/jsp/BugsServlet/" method="POST">
        <div class="container">
            <h2 align="center">Report Bugs</h2>
            <hr>
            <label for="pname"><b>Project Name</b></label>
            <!--input type="text" placeholder="Enter name" name="pname" id="pname" required-->
            <select name="pname" id="pname">
                <option>Select Project Name</option>
               
                <c:forEach items="${projects}" var="projects">
                 <option>${projects.projectName}</option>
                
                </c:forEach>
            </select>
            <br><br>

            <label for="bugtitle"><b>Bug Name</b></label>
            <input type="text" placeholder="Enter title" name="bugtitle" id="bugtitle" required>

            <label for="descbug"><b>Description</b></label>
            <textarea placeholder="Enter Description" name="descbug" id="descbug" required rows="2" cols="50"></textarea><br><br>
            
            <label for="severity"><b>Severity Level</b></label>
                <select name="severity" id="severity" required>
                    <option value="">Choose Severity</option>
                    <option value="critical">Critical </option>
                    <option value="major">Major </option>
                    <option value="minor">Minor </option>
                    <option value="trivial">Trivial </option>
                </select>
            <hr>

            <button type="submit" class="teambtn" align="center" >Submit</button>
        </div>

    </form>
    <br><br><br><br><br>

        
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
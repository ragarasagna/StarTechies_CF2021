
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" >
    <!--  content="IE=edge"-->

    <link rel="stylesheet" href="/BugTrackingSystemApplication/css/ptdstyle.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Developer Page</title>
    
</head>

<body>

<%@page import="java.util.*, com.hsbc.beans.Users, com.hsbc.beans.Bugs"%>
<% 
   String projectname= (String)request.getAttribute("projectname");
pageContext.setAttribute("projectname", projectname);
String projectmanager= (String)request.getAttribute("projectmanager");
pageContext.setAttribute("projectmanager", projectmanager);
String startdate= (String)request.getAttribute("startdate");
pageContext.setAttribute("startdate", startdate);
List<Users> team= (List<Users>)request.getAttribute("team");
pageContext.setAttribute("team", team);
List<Bugs> bugslist=(List<Bugs>)request.getAttribute("bugslist");
pageContext.setAttribute("bugs", bugslist);

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
                                <a class="btn btn-warning" href="developerpage.html" role="button"><i
                                        class="fas fa-user"></i> Profile</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href="developerproject.html" role="button"><i
                                        class="fas fa-spider"></i> Project Assigned</a>
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
    <br>
    <form>
        <div class="container">
            <h1 align="center">Project Assigned</h1>
            <hr>

            <label for="pname"><b>Project Name</b></label>
            <p> <%=request.getAttribute("projectname")%></p>
            
            <label for="pmanager"><b>Project Manager</b></label>
            <p> <%=request.getAttribute("projectmanager")%></p>

            <label for="sdate"><b>Start Date</b></label>
            <p> <%=request.getAttribute("startdate")%></p>

            <label for="team"><b>Team members</b></label>

            <table align="center" cellpadding="2" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
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

            <label for="bugstatus"><b>Bug Status</b></label>
            <table text-align="center" cellpadding="2" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
                <th>Bug Name</th>
                <th>Status</th>
                <th>Mark For Closing</th>

                </tr>
                
                <c:forEach items="${bugs}" var="bug">
					<tr>
						<td>${bug.bugTitle }</td>
						<td>${bug.bugStatus }</td>
	                    <td>
												
					<c:if test="${bug.markedForClosing.equalsIgnoreCase('no') && bug.bugStatus.equalsIgnoreCase('inprogress')}">
					      <%--  <input type="button" name="close" value="close" href="/BugTrackingSystemApplication/jsp/ProjectsServlet/ProjectAssigned/close/${bug.bugId }" > --%>
					      <input type="button" value="close" onclick="window.location.href='/BugTrackingSystemApplication/jsp/ProjectsServlet/ProjectAssigned/close/${bug.bugId }'"/>
					       </c:if>
					   </td>
					
					
							

					</tr>
				</c:forEach>
                
                
            </table>

        </div>

    </form>
    <br>
    <br>
    <br>
    <br>

        
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
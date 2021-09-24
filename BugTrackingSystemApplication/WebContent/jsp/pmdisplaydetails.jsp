<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
\
    <%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!--link rel="stylesheet" href="../css/ptdstyle.css" /-->
    <link rel="stylesheet" href="../css/display.css" />
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
    <title>Project Manager Page</title>
    
</head>

<body>
<%@page import="java.util.*, com.hsbc.beans.Users" %>
<%
    ArrayList<Users> users = (ArrayList<Users>)request.getAttribute("team");
    pageContext.setAttribute("team", users);
    
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
                                <a class="btn btn-warning" href="pmpage.html" role="button"><i
                                        class="fas fa-user"></i> Profile</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href="newproject.html" role="button"><i
                                        class="fas fa-project-diagram"></i> New Project</a>
                            </li>&nbsp;&nbsp;&nbsp;
                            <li class="nav-item">
                                <a class="btn btn-warning" href="pmdisplayproject.html" role="button"><i
                                        class="fas fa-tasks"></i> Project Details</a>
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
            <h1 align="center">Project Details</h1>
            <hr>

            <label for="pname"><b>Project Name</b></label>
            <p> <%=request.getAttribute("projectname") %></p>

            <label for="sdate"><b>Start Date</b></label>
            <p> <%=request.getAttribute("date") %></p>

            <label for="pmanager"><b>Project Manager</b></label>
            <p> <%=request.getAttribute("managername") %></p>

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
               
              
              
              
              
                
               
<br>
            <label for="bugs"><b>Bugs List</b></label>

            <table align="center" cellpadding="2" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
                <!--td>Bug ID</td-->
                <th><div class="dropdown mt-1">
                    Bug Name
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">  
                    <i class="fas fa-filter"></i> 
                    </button> 
                    
                    <div class="dropdown-menu">  
                    <!--a class="dropdown-item" href="#"> Critial </a>  
                    <a class="dropdown-item" href="#"> Major </a>  
                    <a class="dropdown-item" href="#"> Minor </a>  
                    <a class="dropdown-item" href="#"> Trivial </a-->
                    <select class="form-control" size=5>  
                        <option value="severerity" align="center">Select Severity</option>
                        <option value="critial">Critial</option>
                        <option value="major">Major</option>
                        <option value="minor">Minor</option>
                        <option value="trivial">Trivial</option>
                    </select>
            </div>  
            </div>
                    <!--select class="form-control">
                        <option value="severerity" align="center">Select Severity</option>
                        <option value="critial">Critial</option>
                        <option value="major">Major</option>
                        <option value="minor">Minor</option>
                        <option value="trivial">Trivial</option>
                    </select-->
                </th>
                <th>Assign Developers</th>
                <th>Present status</th>
                <th>Close</th>
                </tr>
                </table>

        </div>

    </form>

        
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link rel="stylesheet" href="../css/ptdstyle.css" />
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
            <h2 align="center">Projects</h2>
            <hr>

            <table align="center" cellpadding="2" width="100%">
                <tr bgcolor="black" class="whitetext" align="center" style="color:white">
                <th>S No.</th>
                <th>Project Name</th>
                
                </tr>
                <tr align="center">
                    <td>1</td>
                    <td><a href="/BugTrackingSystemApplication/ProjectDetailsServlet/projectname1">projectname1</a></td>
                </tr>
                </table>
                
              <!--     <c:forEach items="${list}" var="user">
                 <td><a href="/BugTrackingSystemApplication/ProjectDetailsServlet/projectname1">projectname1</a></td>
                 </c:forEach>-->
                 
                 
        </div>

    </form>

        
    <footer class="container-fluid text-center">
        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
    </footer>

</body>

</html>
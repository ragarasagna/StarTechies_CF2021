<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
        <%@page import="java.util.List" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
                    <meta name="viewport" content="width=device-width, initial-scale=1" />
                    <link rel="stylesheet" href="../css/ptdstyle.css" type="text/css" />
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
                        rel="stylesheet">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
                        rel="stylesheet" />
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Developer Page</title>
                </head>

                <body>
                    <section id="nav-bar">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="../jsp/home.jsp" style="font-size: 60px;"><i
                                        class="fas fa-bug fa-spin"></i>&nbsp;Bug Tracker</a>
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <span class="navbar-text">
                                    <div class="collapse navbar-collapse" id="navbarText">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item">
                                                <a class="btn btn-warning" href="../jsp/developerpage.jsp" role="button"><i
                                                        class="fas fa-user"></i> Profile</a>
                                            </li>&nbsp;&nbsp;&nbsp;
                                            <li class="nav-item">
                                                <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/ProjectsServlet/ProjectAssigned" role="button"><i
                                                        class="fas fa-spider"></i> Project Assigned</a>
                                            </li>&nbsp;&nbsp;&nbsp;
                                            <li class="nav-item">
                                                <a class="btn btn-warning" href = "/BugTrackingSystemApplication/jsp/ProjectsServlet/LogOut" role="button"><i
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
                            <h1 align="center">Profile</h1>
                            <hr>

                            <label for="email"><b>Email</b></label>
                            <p><%=request.getAttribute("emailId") %></p>

                            <label for="role"><b>Role</b></label>
                            <p><%=request.getAttribute("role") %></p>
                            <label for="lastlogin"><b>Last Login</b></label>
                            <p><%=request.getAttribute("last_login") %></p>

                        </div>

                    </form>


                    <footer class="container-fluid text-center">
                        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
                    </footer>

                </body>

                </html>
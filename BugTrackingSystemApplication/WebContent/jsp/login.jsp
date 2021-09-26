<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="java.util.List" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
                        rel="stylesheet">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
                        rel="stylesheet" />
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
                        rel="stylesheet">


                    <link rel="stylesheet" href="../css/loginPageStyle.css" type="text/css">

                </head>

                <body>

                    <body>
                        <section id="nav-bar">
                            <nav class="navbar navbar-expand-lg navbar-light">
                                <div class="container-fluid">
                                    <a class="navbar-brand" href="../html/home.html" style="font-size: 60px;"><i
                                            class="fas fa-bug fa-spin"></i>&nbsp;BugTracker</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                                        aria-label="Toggle navigation">
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

                        <br><br><br>
                        <form action="../jsp/Loginservlet" method="POST">
                            <div class="container">
                                <h1 align="center">Login</h1>
                                <hr>
                                <h4>
                                    <label for="email"><b>Email</b></label>
                                    <input type="email" placeholder="Enter Email" name="email" id="email" required>
                                    <label for="psw"><b>Password</b></label>
                                    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
                                    <hr>

                                    <button type="submit" class="loginbtn">Login</button>
                                </h4>
                                <h4>Don't have an account? <a href="../jsp/register.jsp">Register</a></h4>

                            </div>

                        </form>
                        <footer class="container-fluid text-center">
                            <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
                        </footer>

                    </body>

                </html>
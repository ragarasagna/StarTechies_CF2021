<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.List" %>
        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="/BugTrackingSystemApplication/css/homepagestyle.css" type="text/css">
                <link rel="preconnect" href="https://fonts.googleapis.com">
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" />
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Home Page</title>
            </head>

            <body>
                <section id="nav-bar">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="#" style="font-size: 60px;"><i
                                    class="fas fa-bug fa-spin"></i>&nbsp;Bug
                                Tracker</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false"
                                aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <span class="navbar-text">
                                <div class="collapse navbar-collapse" id="navbarText">
                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                        <li class="nav-item">
                                            <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/register.jsp" role="button"><i
                                                    class="fas fa-user"></i>Register</a>
                                        </li>&nbsp;&nbsp;&nbsp;
                                        <li class="nav-item">
                                            <a class="btn btn-warning" href="/BugTrackingSystemApplication/jsp/login.jsp" role="button"><i
                                                    class="fas fa-sign-in-alt"></i>Login</a>
                                            </button>
                                        </li>
                                    </ul>
                            </span>
                        </div>
                        </div>
                    </nav>
                </section>
                <section id="content">
                    <div class="card bg-dark text-white">
                        <img src="/BugTrackingSystemApplication/jsp/images/finalbg.jpg" class="card-img" alt="...">
                        <div class="card-img-overlay">
                            <h4 class="card-title"><b><i>"Never allow the same bug to bite you twice </i>"</b>-Steve
                                Maguire</h4><br>
                            <p class="card-text">Bug Tracker facilitates the process by which bugs are detected and
                                <br>fixed. It helps to eliminate issues by
                                regulating the tasks of each tester<br> and giving them clarity on what needs to be
                                fixed.Issue
                                tracking
                                software<br> performs
                                an in-depth analysis of bugs in order to offer clarity on how<br> debugging activities
                                should
                                progress. It enables testers to implement<br> timely corrective measures. This obviously
                                facilitates the production<br> of
                                high-quality software.
                            </p><br>
                            <a class="btn btn-danger" href="/BugTrackingSystemApplication/jsp/importusers.jsp" role="button"
                                style="font-size: 18px;">Import
                                Users &nbsp;<i class='fas fa-angle-double-right'></i><a>
                        </div>
                    </div>
                </section>
                <footer class="container-fluid text-center">
                    <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
                </footer>

            </body>

            </html>
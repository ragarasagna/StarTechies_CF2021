<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
        <%@page import="java.util.List" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                
                    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
                    <title>Import Users</title>
                    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
                    <link rel='stylesheet'
                        href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
                    <link rel="stylesheet" href="/BugTrackingSystemApplication/css/importUsersStyle.css">
                    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
                        rel="stylesheet">
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap"
                        rel="stylesheet">
                    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
                    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
                    <script src="/BugTrackingSystemApplication/js/importUsersValidation.js" type="text/javascript"></script>
                </head>


                <body >

                    <section id="nav-bar">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="/BugTrackingSystemApplication/jsp/home.jsp" style="font-size: 60px;"><i
                                        class="fas fa-bug fa-spin"></i>&nbsp;BugTracker</a>
                            </div>
                        </nav>
                    </section>
                    <form method="post" action="/BugTrackingSystemApplication/jsp/ImportUsersServlet" enctype="multipart/form-data">
                        <div class="container">
                            <div class="row it">
                                <div class="col-sm-offset-1 col-sm-10" id="one">
                                    <p>
                                        Please upload user information in json format.
                                    </p>
                                    <div class="row">
                                        <div class="col-sm-offset-4 col-sm-4 form-group">
                                            <h3 class="text-center">Documents</h3>
                                        </div>
                                    </div>
                                    <div id="uploader">
                                        <div class="row uploadDoc">
                                            <div class="col-sm-3">
                                                <div class="docErr">Please upload valid file</div>
                                                <div class="fileUpload btn btn-orange">
                                                    <img src="https://image.flaticon.com/icons/svg/136/136549.svg"
                                                        class="icon">
                                                    <span class="upl" id="upload">Upload document</span>
                                                    <input type="file" class="upload up" id="up" name="up"
                                                        onchange="readURL(this);" required />
                                                        
                                                        
                                                </div>
                                            </div>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="" placeholder="Note">
                                            </div>
                                            <div class="col-sm-1"><a class="btn-check"><i class="fa fa-times"></i></a>
                                            </div>
                                        </div>
                                    </div><br><br><br>
                                    <div class="text-center">
                                       <!--  <a class="btn btn-new"><i class="fa fa-plus"></i> Add new</a>-->
                                        <button type="submit" value="submit" class="btn btn-next"><i class="fa fa-paper-plane"></i>
                                            Submit</a>
                                            <!--<input type="submit" class="btn btn-next"></input>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <footer class="container-fluid text-center">
                        <p><i class="fa fa-copyright"></i>All Rights Reserved </p>
                    </footer>

                </body>

                </html>
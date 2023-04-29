<%-- 
    Document   : index.jsp
    Created on : 04-Feb-2023, 20:50:12
    Author     : mcgeo
--%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html   >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <script src="https://kit.fontawesome.com/b4672bdce5.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/styles.css">

        <title>Get Gud Games</title>
    </head>
    <section class="header">
        <p class="h1">GetGud Games</p>
        <nav class="nav navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="login.jsp">Login</a>
            <a class="navbar-brand" href="register.jsp">Register</a>
            <a class="navbar-brand" href="index.jsp">Home</a>
        </nav>
    </section>
    <body class= "d+
          3 -flex flex-column min-vh-100">
        <%
            User u = (User) session.getAttribute("user");
            if (u == null) {
                String message = (String) session.getAttribute("msg");
                if (message != null) {
                    out.println("<div>" + message + "</div>");
                    session.removeAttribute("msg");
                }

            }%>

        <section class="newsletter">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="content">
                            <div class="input-group col d-flex justify-content-center">
                                <input type="email" class="form-control" placeholder="Sign up to our newsletter">
                                <span class="input-group-btn">
                                    <button class="btn" type="submit">Subscribe Now</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section>
            <div class="card-deck">
                <div class="card col-sm-4 card">
                    <img class="card-img-top" src="css/images/game1.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Game Barter</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
                <div class="card col-sm-4 card">
                    <img class="card-img-top" src="css/images/game2.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">LFG</h5>
                        <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
                <div class="card col-sm-4 card">
                    <img class="card-img-top" src="css/images/game3.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Reviews</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
    </body>
</html>

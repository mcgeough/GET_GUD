
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/styles.css">
        <title>Login</title>
    </head>
    <body> 
        <section class="header">
            <p class="h1">GetGud Games</p>
            <nav class="nav navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="login.jsp">Login</a>
                <a class="navbar-brand" href="register.jsp">Register</a>
                <a class="navbar-brand" href="index.jsp">Home</a>
            </nav>
        </section>
        <section class="h-100">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body p-md-5 mx-md-4">
                                        <div class="text-center">
                                            <img src="css/images/game.jpg" style="width: 350px;" alt="logo">
                                            <h4 class="mt-1 mb-5 pb-1">GetGud Games</h4>
                                        </div>

                                        <form action="controller" method="post">
                                            <p>Please login to your account</p>

                                            <div class="form-outline mb-4">
                                                <label>Username</label>
                                                <input type="username" name="username"
                                                       placeholder="username" required/>
                                            </div>

                                            <div>
                                                <label>Password</label>
                                                <input type="password"  name="password" 
                                                       placeholder="password" required/>
                                            </div>
                                            </br>
                                            <strong>
                                                <div>
                                                    <button class="btn btn-primary btn-block fa-lg mb-3" type="submit">Login
                                                    </button>
                                                    <input type="hidden" name ="action" value="login"/>
                                                </div>
                                                </br> </br>

                                                <a class="text-muted" href="#!">Forgot password?</a>
                                                <div class="d-flex align-items-center justify-content-center pb-4">
                                                    <p class="mb-0 me-2">Don't have an account?
                                                        <button type="button"  onclick="window.location.href = 'register.jsp';"class="btn btn-outline-danger">Create New</button>
                                                    </p>
                                                </div>
                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center">
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    <div class="card">
                                        <div class="card-body"">
                                            <blockquote class="blockquote mb-0">
                                                <p>“The greatest game ever, would play again *****.”</p>
                                                <footer class="blockquote-footer"><cite title="Source Title">Some guy</cite></footer>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </strong>
    <jsp:include page="footer.html" />
</body>
</html>

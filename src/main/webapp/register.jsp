<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/styles.css">
        <title>Register</title>
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
                                            <p>Register for free today</p>

                                            <div class="form-outline mb-4">
                                                <label>Username</label>
                                                <input type="text" name="username"
                                                       placeholder="username" required/>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <label>Password</label>
                                                <input type="password"  name="password" 
                                                       placeholder="password" required/>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <label>Email</label>
                                                <input type="email"  name="email" 
                                                       placeholder="email" required/>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <label>First Name</label>
                                                <input type="text"  name="firstName" 
                                                       placeholder="first name" required/>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label>Last Name</label>
                                                <input type="text"  name="lastName" 
                                                       placeholder="last name" required/>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label>Date of Birth</label>
                                                <input type="date"  name="dob" 
                                                       placeholder="Date of birth" required/>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label>Do you want to become a verified critic?</label></br>
                                                <select name="critic">
                                                    <option value="0">No</option>
                                                    <option value="1">Yes</option>
                                                </select>
                                                </br>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label>Are you an admin?</label>
                                                <select name="admin">
                                                    <option value="0">No</option>
                                                    <option value="1">Yes</option>
                                                </select>
                                                </br>
                                                <div class="form-outline mb-4">
                                                    <button class="btn btn-primary btn-block fa-lg mb-3" type="submit">Register
                                                    </button>
                                                    <input type="hidden" name ="action" value="register"/>
                                                </div>
                                        </form>
                                        <strong>
                                            <a class="text-muted" href="#!">Forgot password?</a>
                                            <div class="d-flex align-items-center justify-content-center pb-4">
                                                <p class="mb-0 me-2">Already have an account?
                                                    <button type="button"  onclick="window.location.href = 'register.jsp';"class="btn btn-outline-danger">Login here</button>
                                                </p>
                                            </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <jsp:include page="footer.jsp" />
    </body>
</html>

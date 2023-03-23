<%-- 
    Document   : register
    Created on : 05-Feb-2023, 01:19:55
    Author     : mcgeo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="js/passwordValidation.js"></script>
        <link rel="stylesheet" href="css/styles.css">
        <title>Registration</title>
    </head>
    <body>
        <section class="header">
            <p class="h1">GetGud Games</p>
            <nav class="nav navbar-expand-lg navbar-light">
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
                                            <img src="css/images/airline.jpg"
                                                 style="width: 350px;" alt="logo">
                                            <h4 class="mt-1 mb-5 pb-1">GetGud Games</h4>
                                        </div>
                                        <form action="controller" method="post">
                                            <strong><p>Register today</p></strong>

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example11">Username</label>
                                                <input type="text" id="form2Example11" name="username" class="form-control"
                                                       placeholder="username here." required/>
                                            </div>
                                            </br>

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example22">Password</label>
                                                <input type="password" id="password" name="password" class="form-control"
                                                       placeholder="password here." required/>
                                            </div>
                                            </br>
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example22">Email</label>
                                                <input type="email" id="email" name="email" class="form-control"
                                                       placeholder="email here." required/>
                                            </div>
                                            </br>

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example22">First Name</label>
                                                <input type="text" id="form2Example22" name="firstname" class="form-control"
                                                       placeholder="first name here." required/>
                                            </div>
                                            </br>

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example22">Last Name</label>
                                                <input type="text" id="form2Example22" name="lastname" class="form-control"
                                                       placeholder="last name here." required/>
                                            </div>
          
                                            </br>
                                            <div class="form-outline mb-4">
                                                <label for="isCritic">Are you a Critic? (Test only)</label>
                                                <select name="isCritic" id="isCritic">
                                                    <option value="0">False</option>
                                                    <option value="1">True</option>
                                                </select>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <label for="isAdmin">Are you an Admin? (Test only)</label>
                                                <select name="isAdmin" id="isAdmin">
                                                    <option value="0">False</option>
                                                    <option value="1">True</option>
                                                </select>

                                            </div>

                                            <div class="text-center pt-1 mb-5 pb-1">
                                                <button class="btn btn-primary btn-block fa-lg mb-3" type="submit" name="register">Register
                                                </button>
                                                <input type="hidden" name ="action" value="login"/>
                                                <a class="text-muted" href="#!">Forgot password?</a>
                                            </div>

                                            <div class="d-flex align-items-center justify-content-center pb-4">
                                                <p class="mb-0 me-2">Already have an account with us?
                                                    <button type="button"  onclick="window.location.href = 'login.jsp'"class="btn btn-outline-danger">             Login here!</button>
                                                </p>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                        <h4 class="mb-4">Sign up today for free, you won't regret it.</h4>
                                        <p class="small mb-0">Hear all of the latest news <strong>PLUS</strong> access to exclusive content.</p>
                                    </div>
                                </div>  
                                <div id="message">
                                    <h3>Password must contain the following:</h3>
                                    <p class="col-lg-6" id="letter" class="invalid">A <b>lowercase</b> letter</p>
                                    <p class="col-lg-6" id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                                    <p class="col-lg-6" id="number" class="invalid">A <b>number</b></p>
                                    <p class="col-lg-6" id="length" class="invalid">Minimum <b>8 characters</b></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </strong>
</body>
</html>


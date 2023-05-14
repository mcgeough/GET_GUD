<%@page import="java.text.NumberFormat"%>
<%@page import="daos.UserDao"%>
<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/b4672bdce5.js" crossorigin="anonymous"></script>
        <title>User Details</title>
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
        <h1>User Details</h1>
        <%
            // Check if the user is currently logged in
            User u = (User) session.getAttribute("user");
            if (u != null) {
                // If they are logged in, then continue
                String userID = request.getParameter("id");
                // If an id was supplied
                if (userID != null && !userID.isEmpty()) {
                    try {
                        // Convert the id from text to a number
                        int id = Integer.parseInt(userID);
                        // Get the appropriate User from the database
                        UserDao userDao = new UserDao("getgud");
                        User user = userDao.findUserById(id);
                        // If a user matching that name is found
                        if (user != null) {
                            // Display user's information
                            // Use a formatter to provide internationalisation on the numeric data
        %>
        <table>
            <tr><th>ID:</th><td><%=user.getId()%></td></tr>
            <tr><th>Username:</th><td><%=user.getUsername()%></td></tr>
            <tr><th>First Name</th><td><%=user.getFirstName()%></td></tr>
            <tr><th>Last Name</th><td><%=user.getLastName()%></td></tr>
            <tr><th>Birthday</th><td><%=user.getDob()%></td></tr>
        </table>
        <%
        } else {
        %>
        <div>No matching user..</div>
        <%
                    }
                } catch (NumberFormatException e) {
                    // Handle where the value supplied was not a number

                    // Redirect the user to the error page, as there was no id supplied
                    String error = "No int supplied..";
                    session.setAttribute("errorMessage", error);
                    response.sendRedirect("error.jsp");
                }
            } else {
                // Redirect the user to the error page, as there was no id supplied
                String error = "No ID supplied";
                session.setAttribute("errorMessage", error);
                response.sendRedirect("error.jsp");
            }
        } else {
        %>
        <div>Not logged in..</div>
        <%
            }
        %>
        <jsp:include page="footer.jsp" />
    </body>
</html>

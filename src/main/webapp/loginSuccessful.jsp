<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/styles.css">
        <title>All Set</title>
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
        <%
            String username = (String) session.getAttribute("username");
            if (username != null) {
                String msg = (String) session.getAttribute("msg");
                if (msg != null) {
                    out.println("<div>" + msg + "</div>");
                    session.removeAttribute("msg");
                }
        %>
        <div><%=username%> : logged in!</div>
        <%
        } else {
        %>
        <div>Only logged in users can access this page. Please <a href="login.jsp">login</a> to continue.
            <%
                }
            %>
    </body>
    <jsp:include page="footer.html" />
</html>

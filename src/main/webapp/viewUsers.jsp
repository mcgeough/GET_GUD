<%-- 
    Document   : viewUsers
    Created on : 12-May-2023, 11:16:18
    Author     : mcgeo
--%>
<%@page import="daos.UserDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user != null) {
                UserDao userDao = new UserDao("getgud");
                ArrayList<User> users = (ArrayList<User>) userDao.findAllUsers();
                if (!users.isEmpty())
        %>
        <ul>
            <%
                for (User u : users) {
            %>
            <!-- 
                Dynamically generate a link for every user in the list. 
                The id is inserted into the link as a request parameter, 
                and the link is labelled with the corresponding username
            -->
            <li><a href="userDetails.jsp?id=<%=u.getId()%>"><%=u.getUsername()%></a></li>
                <%
                    }
                %>
        </ul>
        <!-- Create a link to the servlet that contains an embedded action -->
        <a href="controller?action=logout">Logout</a><br/>
        <a href ="index.jsp">Back to home</a>
        <%
        } else {
        %>
        <div>Sorry, this page is only for logged-in users. Please <a href="login.jsp">login</a> to continue.
            <%
                }
            %>
    </body>
</html>


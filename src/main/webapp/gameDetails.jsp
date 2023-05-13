<%-- 
    Document   : gameDetails
    Created on : 12-May-2023, 08:34:44
    Author     : mcgeo
--%>

<%@page import="daos.GameDao"%>
<%@page import="business.Game"%>
<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <%
            // Check if the user is currently logged in
            User u = (User) session.getAttribute("user");
            if (u != null) {
                // If they are logged in, then continue
                String gameID = request.getParameter("id");
                // If an id was supplied
                if (gameID != null && !gameID.isEmpty()) {
                    try {
                        // Convert the id from text to a number
                        int id = Integer.parseInt(gameID);
                        // Get the appropriate User from the database
                        GameDao gameDao = new GameDao("getgud");
                        Game g = gameDao.findGameById(id);
                        // If a user matching that name is found
                        if (g != null) {
                            // Display game information
                            // Use a formatter to provide internationalisation on the numeric data
%>
        <table>
            <tr><th>ID</th><td><%=g.getId()%></td></tr>
            <tr><th>Title</th><td><%=g.getTitle()%></td></tr>
            <tr><th>Description</th><td><%=g.getGenre()%></td></tr>
            <tr><th>Price</th><td><%=g.getPrice()%></td></tr>
        </table>
        <%
        } else {
        %>
        <div><p>error</p></div>
        <%
                    }
                } catch (NumberFormatException e) {
                    // Handle where the value supplied was not a number

                    // Redirect the user to the error page, as there was no id supplied
                    String error = "invalid input...";
                    session.setAttribute("errorMessage", error);
                    response.sendRedirect("error.jsp");
                }
            } else {
                // Redirect the user to the error page, as there was no id supplied
                String error = "invalid input...";
                session.setAttribute("errorMessage", error);
                response.sendRedirect("error.jsp");
            }
        } else {
        %>
        <div><p>error</p></div>
        <%
            }
        %></h1>
</body>
</html>

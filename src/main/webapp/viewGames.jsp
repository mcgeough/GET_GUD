<%-- 
    Document   : viewGames
    Created on : 11-May-2023, 15:27:20
    Author     : mcgeo
--%>

<%@page import="daos.GameDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.Game"%>
<%@page import="business.User"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <html>
        <body>
            <%
                User user = (User) session.getAttribute("user");
                if (user != null) {
                    GameDao gameDao = new GameDao("getgud");
                    ArrayList<Game> games = (ArrayList<Game>) gameDao.findAllGames();
                    if (!games.isEmpty())
            %>


            <ul>
                <%
                    for (Game g : games) {
                %>
                <!-- 
                    Dynamically generate a link for every game in the list. 
                    The id is inserted into the link as a request parameter, 
                    and the link is labelled with the corresponding username
                -->
                <li><a href="gameDetails.jsp?id=<%=g.getId()%>"><%=g.getTitle()%></a></li>
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
    </body>
</html>

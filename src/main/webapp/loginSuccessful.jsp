<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if(username != null){
                String msg = (String) session.getAttribute("msg");
                if(msg != null){
                    out.println("<div>" + msg + "</div>");
                    session.removeAttribute("msg");
                }
        %>
        <div><%=username%> : logged in!</div>
        <%
            }else{
        %>
        <div>Only logged in users can access this page. Please <a href="login.jsp">login</a> to continue.
        <%
            }
        %>
    </body>
</html>

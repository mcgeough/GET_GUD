<%-- 
    Document   : viewGame
    Created on : 11-May-2023, 15:27:20
    Author     : mcgeo
--%>

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
            <div align="center">
                <h2><c:out value="${book.title}" /></h2>
                <h3><c:out value="${book.author}" /></h3>
                <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
            </div>
        </body>
    </body>
</html>

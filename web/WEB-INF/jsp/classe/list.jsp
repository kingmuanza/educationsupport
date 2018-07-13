<%-- 
    Document   : list
    Created on : 13 juil. 2018, 13:04:32
    Author     : N9-T
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLASSE | List</title>
    </head>
    <body>
        <table>
            <thead>
                <td>CODE</td>
                <td>DELETED</td>
            </thead>
            <c:forEach items="${classes}" var="classe">
                <tr>
                    
                        <td><a href="view/${classe.idclasse}">${classe.code}</a></td>
                    
                    <td>${classe.deleted}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

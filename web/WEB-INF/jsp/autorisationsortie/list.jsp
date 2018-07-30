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
        <title>AUTORISATION SORTIE | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>CODE</td>
            <td>DATE JOUR</td>
            <td>CREATED</td>
            <td>MODIFIED</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${autorisationsorties}" var="autorisationsortie">
            <a href="view/${autorisationsortie.idautorisationSortie}">
                <tr>

                    <td>${autorisationsortie.code}</td>
                    <td>${autorisationsortie.dateJour}</td>

                    <td>${autorisationsortie.created}</td>
                    <td>${autorisationsortie.modified}</td>
                    <td>${autorisationsortie.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

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
        <title>CONSEIL DE DISCIPLINE | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>CODE</td>
            <td>Date Debut</td>
            <td>Date Fin</td>
            <td>CREATED</td>
            <td>MODIFIED</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${conseildisciplines}" var="conseildiscipline">
            <a href="view/${conseildiscipline.idconseilDiscipline}">
                <tr>

                    <td>${conseildiscipline.code}</td>
                    <td>${conseildiscipline.dateDebut}</td>
                    <td>${conseildiscipline.dateFin}</td>

                    <td>${conseildiscipline.created}</td>
                    <td>${conseildiscipline.modified}</td>
                    <td>${conseildiscipline.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

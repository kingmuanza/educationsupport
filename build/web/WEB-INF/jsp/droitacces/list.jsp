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
        <title>DROIT D'ACCES | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>Niveau</td>
            <td>Description</td>
            <td>Date Création</td>
            <td>Date Modification</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${droitaccess}" var="droitacces">
            <a href="view/${droitacces.iddroitAcces}">
                <tr>

                    <td>${droitacces.niveau}</td>
                    <td>${droitacces.description}</td>
                    <td>${droitacces.motif}</td>

                    <td>${droitacces.created}</td>
                    <td>${droitacces.modified}</td>
                    <td>${droitacces.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

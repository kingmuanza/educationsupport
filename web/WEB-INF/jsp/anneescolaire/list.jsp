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
        <title>ANNEE SCOLAIRE | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>DEBUT</td>
            <td>FIN</td>
            <td>EN COURS</td>
            <td>CREATED</td>
            <td>MODIFIED</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${anneescolaires}" var="anneescolaire">
            <a href="view/${anneescolaire.idanneescolaire}">
                <tr>
                    <td>${anneescolaire.dateDebut}</td>
                    <td>${anneescolaire.dateFin}</td>
                    <td>${anneescolaire.enCours}</td>

                    <td>${anneescolaire.created}</td>
                    <td>${anneescolaire.modified}</td>
                    <td>${anneescolaire.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

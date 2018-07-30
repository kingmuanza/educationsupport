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
        <title>ELEVE | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>ELEVE</td>
            <td>Individu</td>
            <td>Classe</td>
            <td>Date Création</td>
            <td>Date Modification</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${eleves}" var="eleve">
            <a href="view/${eleve.ideleve}">
                <tr>

                    <td>${eleve.ideleve}</td>
                    <td>${eleve.individuIdindividu.noms}</td>
                    <td>${eleve.classeIdclasse.code}</td>
                    
                    <td>${eleve.created}</td>
                    <td>${eleve.modified}</td>
                    <td>${eleve.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

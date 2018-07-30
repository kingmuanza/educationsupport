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
        <title>ABSENCE | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>JOUR ABSENCE</td>
            <td>JUSTIFIE</td>
            <td>MOTIF</td>
            <td>Date Création</td>
            <td>Date Modification</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${absences}" var="absence">
            <a href="view/${absence.idabsence}">
                <tr>

                    <td>${absence.jourAbsence}</td>
                    <td>${absence.justifee}</td>
                    <td>${absence.motif}</td>

                    <td>${absence.created}</td>
                    <td>${absence.modified}</td>
                    <td>${absence.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

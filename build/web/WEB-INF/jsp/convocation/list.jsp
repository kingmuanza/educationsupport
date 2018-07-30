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
        <title>CONVOCATION | List</title>
    </head>
    <body>
        <table>
            <thead>
            <td>MOTIF</td>
            <td>Date Création</td>
            <td>Date Modification</td>
            <td>DELETED</td>
        </thead>
        <c:forEach items="${convocations}" var="convocation">
            <a href="view/${convocation.idconvocation}">
                <tr>

                    <td>${convocation.motif}</td>

                    <td>${convocation.created}</td>
                    <td>${convocation.modified}</td>
                    <td>${convocation.deleted}</td>
                </tr>
            </a>
        </c:forEach>
    </table>
</body>
</html>

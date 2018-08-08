<%-- 
    Document   : create
    Created on : 13 juil. 2018, 13:04:11
    Author     : N9-T
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSEIL DE DISCIPLINE | Create</title>
    </head>
    <body>
        <form:errors path="conseildiscipline.*"/>
        <form method="post" action="create">
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Debut</label></td>
                    <td><input type="date" name="dateDebut" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Fin</label></td>
                    <td><input type="date" name="dateFin" required="true"/></td>
                </tr>
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>

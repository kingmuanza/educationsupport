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
        <title>ANNEE SCOLAIRE | Create</title>
    </head>
    <body>
        <form:errors path="anneescolaire.*"/>
        <form method="post" action="create">
            <table>
                <tr>
                    <td><label>Début</label></td>
                    <td><input type="text" name="dateDebut" required="true"/></td>
                    <td><label>Fin</label></td>
                    <td><input type="text" name="dateFin" required="true"/></td>
                    <td><label>En cours</label></td>
                    <td><input type="text" name="enCours" required="true"/></td>
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

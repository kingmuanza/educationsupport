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
        <title>Reatrd | Create</title>
    </head>
    <body>
        <form:errors path="retard.*"/>
        <form method="post" action="/educationsupport/retard/create" style="margin-top: 50px;">
            <table>
                <tr>
                    <td><label>Individu en retard</label></td>
                    <td><select name="individuIdindividu">
                            <option> -- SELECT --</option>
                            <c:forEach items="${individus}" var="individu">
                                <option value="${individu.idindividu}">${individu.noms}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Jour Retard</label></td>
                    <td><input type="date" name="jourRetard" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Nombre heure de retard</label></td>
                    <td><input type="number" name="marge" required="true"/></td>
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

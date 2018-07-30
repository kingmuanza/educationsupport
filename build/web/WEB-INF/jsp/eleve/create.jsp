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
        <title>ELEVE | Create</title>
    </head>
    <body>
        <form:errors path="eleve.*"/>
        <form method="post" action="create">
            <table>
                <tr>
                    <td><label>Individu</label></td>
                    <td>
                        <select name="individus">
                            <option >Aucune valeur</option>
                            <c:forEach items="${individus}" var="individu">
                                <option value="${individu.idindividu}">${individu.noms} ${individu.prenoms}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Classe</label></td>
                    <td>
                        <select name="classes">
                            <option >Aucune valeur</option>
                            <c:forEach items="${classes}" var="classe">
                                <option value="${classe.idclasse}">${classe.code}</option>
                            </c:forEach>
                        </select>
                    </td>
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

<%-- 
    Document   : edit
    Created on : 13 juil. 2018, 13:04:25
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
        <title>ELEVE | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/eleve/edit">
            <input type="hidden" name="ideleve" value="${eleve.ideleve}"/>
            <table>
                <tr>
                    <td><label>Individu</label></td>
                    <td>
                        <select name="individus">
                            <c:forEach items="${individus}" var="individu">
                                <option value="${individu.idindividu}" ${eleve.individuIdindividu==individu.idindividu?"selected":""}>${individu.noms} ${individu.prenoms}</option>
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
                                <option value="${classe.idclasse}" ${eleve.classeIdclasse==classe.idclasse?"selected":""}>${classe.code}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
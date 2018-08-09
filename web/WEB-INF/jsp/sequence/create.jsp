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
        <title>SEQUENCE | Create</title>
    </head>
    <body>
        <form:errors path="sequence.*"/>
        <form method="post" action="<c:url value="/sequence/create"/>">
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Numero </label></td>
                    <td><input type="number" name="numero" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Trimestre </label></td>
                            <td><select name="trimestreIdtrimestre" required="true">
                                    <option> Aucune valeur</option>
                                    <c:forEach items="${trimestres}" var="trimestre">
                                        <option value="${trimestre.idtrimestre}">Trimestre N° ${trimestre.numero}</option>
                                    </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Année Scolaire </label></td>
                            <td><select name="anneeScolaireIdanneeScolaire" required="true">
                                    <option> Aucune valeur</option>
                                    <c:forEach items="${anneescolaires}" var="annee">
                                        <option value="${annee.idanneeScolaire}">Année Scolaire ${annee.dateDebut.year} - ${annee.dateFin.year}</option>
                                    </c:forEach>
                        </select></td>
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

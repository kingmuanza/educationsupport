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
        <title>EVALUATION | Create</title>
    </head>
    <body>
        <form:errors path="evaluation.*"/>
        <form method="post" action="<c:url value="/evaluation/create"/>">
            <table>
                <tr>
                    <td><label>Classe</label></td>
                            <td><select name="classeIdclasse" required="true">
                                    <option> Aucune valeur</option>
                                    <c:forEach items="${classes}" var="classe">
                                        <option value="${classe.idclasse}">${classe.code}</option>
                                    </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Matiere</label></td>
                            <td><select name="matiereIdmatiere" required="true">
                                    <option> Aucune valeur</option>
                                    <c:forEach items="${matieres}" var="matiere">
                                        <option value="${matiere.idmatiere}">${matiere.code} ${matiere.libelle}</option>
                                    </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Sequence</label></td>
                            <td><select name="sequenceIdsequence" required="true">
                                    <option> Aucune valeur</option>
                                    <c:forEach items="${sequences}" var="sequence">
                                        <option value="${sequence.idsequence}">${sequence.numero} - ${sequence.code}</option>
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

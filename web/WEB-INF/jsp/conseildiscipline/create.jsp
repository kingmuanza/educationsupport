<%-- 
    Document   : create
    Created on : 13 juil. 2018, 13:04:11
    Author     : N9-T
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSEIL DE DISCIPLINE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des conseils de discipline
        </h1>
        <form:errors path="conseildiscipline.*"/>
        <form method="post" class="ui form" action="<c:url value="/conseildiscipline/create"/>">

            <div class="field">
                <label>Code</label>
                <input type="text" name="code" required="true"/>
            </div>
            <div class="field">
                <label>Libelle</label>
                <input type="text" name="libelle" required="true"/>
            </div>
            <div class="field">
                <label>Date de Début</label>
                <input type="date" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="dateDebut" required="true"/>
            </div>
            <div class="field">
                <label>Date de Fin</label>
                <input type="date" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="dateFin" required="true"/>
            </div>
            <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
            <button class="ui button" type="submit">Enregistrer</button>
        </form>

    </body>
</html>

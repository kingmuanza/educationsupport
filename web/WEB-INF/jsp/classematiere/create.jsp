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
        <title>CLASSE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des matières par classes
        </h1>
        <form:errors path="classematiere.*"/>
        <form method="post" class="ui form" action="<c:url value="/classematiere/create"/>">

            <div class="field">
                <label>Salle de classe</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez une salle de classes</div>
                    <select id="multi-select" name="salleDeClasseIdsalleDeClasse" multiple="true" required="true">
                        <c:forEach items="${salleDeClasses}" var="salleDeClasse">
                            <option value="${salleDeClasse.idsalleDeClasse}" >${salleDeClasse.code}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Matières</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez les matières</div>
                    <select id="multi-select" name="matiereIdmatiere" multiple="true" required="true">
                        <c:forEach items="${matieres}" var="matiere">
                            <option value="${matiere.idmatiere}" >${matiere.code} ${matiere.libelle}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Coefficient</label>
                <input type="text" name="coeficient" required="true"/>
            </div>
            <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
            <button class="ui button" type="submit">Enregistrer</button>
        </form>

    </body>
</html>

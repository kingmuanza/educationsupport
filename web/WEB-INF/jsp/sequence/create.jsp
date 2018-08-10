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
        <title>SEQUENCE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des sequences
        </h1>
        <form:errors path="sequence.*"/>
        <form method="post" class="ui form" class="ui form" action="<c:url value="/sequence/create"/>">
            
                <div class="field">
                    <label>Code</label>
                    <input type="text" name="code" required="true"/>
                </div>
                <div class="field">
                    <label>Numero </label>
                    <input type="number" name="numero" required="true"/>
                </div>
                <div class="field">
                    <label>Trimestre </label>
                            <select class="multi-select" name="trimestreIdtrimestre" required="true">
                                    <option> Sélectionnez un trimestre</option>
                                    <c:forEach items="${trimestres}" var="trimestre">
                                        <option value="${trimestre.idtrimestre}">Trimestre N° ${trimestre.numero}</option>
                                    </c:forEach>
                        </select>
                </div>
                <div class="field">
                    <label>Année Scolaire </label>
                            <select class="multi-select" name="anneeScolaireIdanneeScolaire" required="true">
                                    <option> Sélectionnez une année scolaire</option>
                                    <c:forEach items="${anneescolaires}" var="annee">
                                        <option value="${annee.idanneeScolaire}">Année Scolaire ${annee.dateDebut.split("-")[0]} - ${annee.dateFin.split("-")[0]}</option>
                                    </c:forEach>
                        </select>
                </div>
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <button class="ui button" type="submit">Enregistrer</button>
        </form>
        <script>
            $(document).ready(function () {
                $(".multi-select").dropdown("get value");
            });
        </script>
    </body>
</html>

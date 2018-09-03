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
        <h1 class="titre">
            Enregistrement des éleves
        </h1>
        <form:errors path="eleve.*"/>
        <form method="post" class="ui form" action="<c:url value="/eleve/create"/>">
            
                <div class="field">
                    <label>Individu</label>
                    <select class="select" name="individuIdindividu">
                        <option>Sélectionnez l'individu</option>
                            <c:forEach items="${individus}" var="individu">
                                <option value="${individu.idindividu}">${individu.noms} ${individu.prenoms}</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="field">
                    <label>Salle de classe</label>
                        <select class="select" name="salleDeClasseIdsalleDeClasse">
                            <option>Sélectionnez la salle de classe</option>
                            <c:forEach items="${classes}" var="classe">
                                <option value="${classe.idsalleDeClasse}">${classe.code}-${classe.serieIdserie.code}</option>
                            </c:forEach>
                        </select>
                </div>
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <button class="ui button" type="submit">Enregistrer</button>
        </form>
                <script>
            $(document).ready(function () {
                $(".select").dropdown("get value");
            });
        </script>
    </body>
</html>

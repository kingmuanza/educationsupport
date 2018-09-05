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
        <title>EDUCATION SUPPORT</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des matières d'un enseignant dans une classe
        </h1>
        <form:errors path="enseignantclassematiere.*"/>
        <form method="post" class="ui form" action="<c:url value="/enseignantclassematiere/create"/>">
            <div class="field">
                <label>Enseignant</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez l'enseignant</div>
                    <select id="multi-select" name="enseignantIdenseignant" required="true">
                        <option> Sélectionnez l'enseignant</option>
                        <c:forEach items="${enseignants}" var="enseignant">
                            <option value="${enseignant.idenseignant}">${enseignant.individuIdindividu.prenoms} ${enseignant.individuIdindividu.noms}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Classe matière</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez la matière d'une classe</div>
                    <select id="multi-select" name="classesMatieresIdclassesMatieres" required="true">
                        <option> Sélectionnez la matière d'une classe</option>
                        <c:forEach items="${classesMatieres}" var="classesmatiere">
                            <option value="${classesmatieres.idclassesMatieres}">${classesmatiere.matiereIdmatiere.code} ${classesmatiere.salleDeClasseIdsalleDeClasse.classeIdclasse.code} ${matiereclasse.salleDeClasseIdsalleDeClasse.serieIdserie.code}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
            <button class="ui button" type="submit">Enregistrer</button>
        </form>
        <script>
            $(document).ready(function () {
                $("#multi-select").dropdown("get value");
            });
        </script>
    </body>
</html>

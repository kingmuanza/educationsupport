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
        <title>ANNEE SCOLAIRE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des années scolaires
        </h1>
        <form:errors path="anneescolaire.*"/>
        <form method="post" class="ui form" action="<c:url value="/anneescolaire/create"/>">
            <div class="required field">
                <label>Date de début</label>
                <input type="date" name="dateDebut"/>
            </div>
            <div class="required field">
                <label>Date de fin</label>
                <input type="date" name="dateFin"/>
            </div>
            <div class="required field">
                <label>Est-ce l'année en cours</label>
                <div class="ui dropdown selection">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez une réponse</div>
                    <select id="multi-select" name="enCours">
                        <option value="0" >  NON </option>
                        <option value="1" selected>  OUI </option>
                    </select>
                </div>
            </div>
            <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
            <button class="ui button" type="submit">Enregistrer</button>
        </form>
        <script>
            $(document).ready(function () {
                $("#multi-select").dropdown("get value");
                ouvrirMenuCorrespondant("#section_params", "bouton_params", "anneescolaire");
            });
        </script>
    </body>
</html>

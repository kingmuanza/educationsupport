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
        <h1 class="titre">
            Enregistrement des évaluations
        </h1>
        <form:errors path="evaluation.*"/>
        <form method="post" class="ui form" action="<c:url value="/evaluation/create"/>">

            <div class="field">
                <label>Classe</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez la classe</div>
                    <select class="select" name="classeIdclasse" required="true">
                        <option>Sélectionnez la classe</option>
                        <c:forEach items="${classes}" var="classe">
                            <option value="${classe.idclasse}">${classe.code}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Matiere</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez la matière</div>
                    <select class="select" name="matiereIdmatiere" required="true">
                        <option>Sélectionnez la matière</option>
                        <c:forEach items="${matieres}" var="matiere">
                            <option value="${matiere.idmatiere}">${matiere.code} ${matiere.libelle}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Sequence</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez la séquence</div>
                    <select class="select" name="sequenceIdsequence" required="true">
                        <option>Sélectionnez la séquence</option>
                        <c:forEach items="${sequences}" var="sequence">
                            <option value="${sequence.idsequence}">${sequence.numero} - ${sequence.code}</option>
                        </c:forEach>
                    </select>
                </div>
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

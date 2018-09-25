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
            Enregistrement des salles de classes
        </h1>
        <form:errors path="salledeclasse.*"/>
        <form method="post" class="ui form" class="ui form" action="<c:url value="/salledeclasse/create"/>">
            
                <div class="field">
                    <label>Classe</label>
                            <select class="multi-select" name="classeIdclasse" required="true">
                                    <option> Sélectionnez une classe</option>
                                    <c:forEach items="${classes}" var="classe">
                                        <option value="${classe.idclasse}">${classe.code}${classe.libelle}</option>
                                    </c:forEach>
                        </select>
                </div>
                <div class="field">
                    <label>Série</label>
                            <select class="multi-select" name="serieIdserie" required="true">
                                    <option> Sélectionnez une serie</option>
                                    <c:forEach items="${series}" var="serie">
                                        <option value="${serie.idserie}">${serie.code} - ${serie.libelle}</option>
                                    </c:forEach>
                        </select>
                </div>
                <div class="field">
                    <label>Code</label>
                    <input type="text" name="code" required="true"/>
                </div>
                <div class="field">
                    <label>Libelle </label>
                    <input type="text" name="libelle" required="true"/>
                </div>
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <button class="ui button" type="submit">Enregistrer</button>
        </form>
        <script>
            $(document).ready(function () {
                $(".multi-select").dropdown("get value");
                ouvrirMenuCorrespondant("#section_params", "bouton_params", "sallesdeclasses");
            });
        </script>
    </body>
</html>

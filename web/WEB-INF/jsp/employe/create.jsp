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
        <title>EMPLOYE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des employés
        </h1>
        <form:errors path="employe.*"/>
        <form method="post" class="ui form" action="<c:url value="/employe/create"/>">
            <div class="field">
                <label>Individu</label>
                <div class="ui dropdown selection ">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez l'individu</div>
                    <select id="multi-select" name="individuIdindividu" required="true">
                        <option> Sélectionnez l'individu</option>
                        <c:forEach items="${individus}" var="individu">
                            <option value="${individu.idindividu}">${individu.prenoms} ${individu.noms}</option>
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
                ouvrirMenuCorrespondant("#section_params", "bouton_params", "employe");
            });
        </script>
    </body>
</html>

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
        <title>SANCTION | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des sanction
        </h1>

        <form:errors path="sanction.*"/>
        <form method="post" class="ui form" action="<c:url value="/sanction/create"/>">


            <div class="field">

                <label>Eleves sanctionnés</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez les élèves</div>
                    <select id="multi-select" multiple="true" type="text" name="eleveIdeleve" required="true">
                        <c:forEach items="${eleves}" var="eleve">
                            <option value="${eleve.ideleve}">${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Code</label>
                <input type="text" name="code" required="true"/>
            </div>
            <div class="field">
                <label>Description</label>
                <input type="text" name="description" required="true"/>
            </div>
            
            <div class="field">
                <label>Date Jour</label>
                <input type="date" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="dateJour" required="true"/>
            </div>
            <div class="field">
                <label>Motif</label>
                <input type="text" name="motif" required="true"/>
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

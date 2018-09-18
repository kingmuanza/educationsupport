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
        <title>CONVOCATION | Edit</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des convocations
        </h1>

        <form:errors path="convocation.*"/>
        <form method="post" class="ui form" action="<c:url value="/convocation/edit"/>">
            <input type="hidden" name="idconvocation" value="${convocation.idconvocation}"/>
            <div class="field">
                <label>Eleve convoqué</label>
                <select id="multi-select" type="text" name="eleveIdeleve" required="true">
                    <option>Sélectionnez l'élève</option>
                    <c:forEach items="${eleves}" var="eleve">
                        <option value="${eleve.ideleve}"
                                <c:if test="${convocation.eleveIdeleve.equals(eleve)}">
                                    selected="true"
                                </c:if>
                                >${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="field">
                <label>Code</label>
                <input type="text" name="code" value="${convocation.code}" required="true"/>
            </div>

            <div class="field">
                <label>Motif</label>
                <input type="text" name="motif" value="${convocation.motif}" required="true"/>
            </div>
            <div class="field">
                <label>Date jour</label>
                <input type="date" name="dateJour" value="<fmt:formatDate value="${convocation.dateJour}" pattern="yyyy-MM-dd"/>"/>
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

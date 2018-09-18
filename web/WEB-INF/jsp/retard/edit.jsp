<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RETARD | Create</title>
    </head>
    <body >
        <h1 class="titre">
            Enregistrement des retards
        </h1>
        <form:errors path="retard.*"/>
        <form method="post" class="ui form" action="<c:url value="/retard/edit"/>" style="padding-top: 20px;">
            <input type="hidden" value="${retard.idretard}" name="idretard"/>
                <div class="field">
                    <label>Elève (s) en retard</label>
                            <select id="multi-select" name="eleveIdeleve" multiple="true" required="true">
                                    <option> Sélectionnez l'élève </option>
                                    <c:forEach items="${eleves}" var="eleve">
                                        <option value="${eleve.ideleve}"
                                                <c:if test="${retard.eleveIdeleve.equals(eleve)}">
                                                    selected="true"
                                                </c:if>
                                        >${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms }</option>
                                    </c:forEach>
                        </select>
                </div>
                <div class="field">
                    <label>Jour retard</label>
                    <input type="date" name="jourRetard" required="true" value="<fmt:formatDate value="${retard.jourRetard}" pattern="yyyy-MM-dd"/>"/>
                </div>
                <div class="field">
                    <label>Marge </label>
                    <input type="number" name="marge" value="${retard.marge}" required="true"/>
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

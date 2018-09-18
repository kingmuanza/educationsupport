<%-- 
    Document   : edit
    Created on : 13 juil. 2018, 13:04:25
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
        <title>ABSENCE | Edit</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des absences
        </h1>
        
        <form:errors path="absence.*"/>
        <form method="post"class="ui form" action="<c:url value="/absence/edit"/>" style="padding-top: 20px;">
            <input type="hidden" name="idabsence" value="${absence.idabsence}"/>
            <div class="field">
                <label>Elèves absents</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez les élèves</div>
                    <select id="multi-select" name="eleveIdeleve" multiple="true" required="true">
                        <c:forEach items="${eleves}" var="eleve">
                            <option value="${eleve.ideleve}" 
                                <c:if test="${absence.eleveIdeleve.equals(eleve)}">
                                    selected="true"
                                </c:if>
                            >${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Jour d'absence</label>
                <input type="date" name="jourAbsence" value="<fmt:formatDate value="${absence.jourAbsence}" pattern="yyyy-MM-dd"/>" required="true"/>
            </div>
            <div class="field">
                <div class="two fields">
                    <div class="two wide field">
                        <label>Justifiée ?</label>
                        <select name="justifiee" required="true">
                            <option value="0" 
                                <c:if test="${!absence.justifiee}">
                                    selected="true"
                                </c:if>
                            > Non  
                            </option>
                            <option value="1"
                                <c:if test="${absence.justifiee}">
                                    selected="true"
                                </c:if>
                            > Oui </option>
                        </select>
                    </div>
                    <div class="fourteen wide field">
                        <label>Motif</label>
                        <input type="text" name="motif" value="${absence.motif}" />
                    </div>
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

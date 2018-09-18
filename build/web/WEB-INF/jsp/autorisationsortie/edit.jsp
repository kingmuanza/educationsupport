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
        <title>AUTORISATION SORTIE | Edit</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des autorisation de sortie
        </h1>

        <form:errors path="autorisationsortie.*"/>
        <form method="post" class="ui form" action="<c:url value="/autorisationsortie/edit"/>">

            <input type="hidden" name="idautorisationSortie" value="${autorisationsortie.idautorisationSortie}"/>
            <div class="field">

                <label>Eleves autorisés à sortir</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez les élèves</div>
                    <select id="multi-select" multiple="true" type="text" name="eleveIdeleve" required="true">
                        <c:forEach items="${eleves}" var="eleve">
                            <option value="${eleve.ideleve}"
                                    <c:if test="${autorisationsortie.eleveIdeleve.equals(eleve)}">
                                        selected="true"
                                    </c:if>
                            >${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="field">

                <label>Maladie (s)</label>
                <div class="ui dropdown selection multiple">
                    <i class="dropdown icon"></i>
                    <div class="default text">Sélectionnez les maladies</div>
                    <select id="multi-select" multiple="true" type="text" name="maladieIdmaladie">
                        <c:forEach items="${maladies}" var="maladie">
                            <option value="${maladie.idmaladie}">${maladie.nom} (${maladie.typeMaladie})</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field">
                <label>Code</label>
                <input type="text" name="code" value="${autorisationsortie.code}" required="true"/>
            </div>
            <div class="field">
                <label>Date Jour</label>
                <input type="date" value="<fmt:formatDate value="${autorisationsortie.dateJour}" pattern="yyyy-MM-dd"/>" name="dateJour" required="true"/>
            </div>
            <div class="field">
                <label>Date retour</label>
                <input type="date" value="<fmt:formatDate value="${autorisationsortie.dateRetour}" pattern="yyyy-MM-dd"/>" name="dateRetour" required="true"/>
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

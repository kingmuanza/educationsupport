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
        <title>TRIMESTRE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des individus
        </h1>
        <form:errors path="individu.*"/>
        <form method="post" class="ui form" action="<c:url value="/individu/create"/>">
            
                <div class="field">
                    <label>Matricule</label>
                    <input type="text" name="matricule" required="true"/>
                </div>
                <div class="field">
                    <label>Nom</label>
                    <input type="text" name="noms" required="true"/>
                </div>
                <div class="field">
                    <label>Prenom</label>
                    <input type="text" name="prenoms" required="true"/>
                </div>
                <div class="field">
                    <label>Date Naissance</label>
                    <input type="date" name="dateNaissance" required="true"/>
                </div>
                <div class="field">
                    <label>Lieu Naissance</label>
                    <input type="text" name="lieuNaissance" required="true"/>
                </div>
                <div class="field">
                    <label>E-mail</label>
                    <input type="email" name="numero" required="true"/>
                </div>
                <div class="field">
                    <label>Sexe</label>
                    <input type="text" name="sexe" required="true"/>
                </div>
                <div class="field">
                    <label>Telephone</label>
                    <input type="number" name="telephone" required="true"/>
                </div>
                <div class="field">
                    <label>Residence</label>
                    <input type="text" name="residence" required="true"/>
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

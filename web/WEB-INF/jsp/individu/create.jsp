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
        <title>INDIVIDU | Create</title>
    </head>
    <body>

        <div class="ui container">
            <div class="ui grid">
                <div class="ten wide column">
                    <h1 class="titre">
                        Enregistrement des individus
                    </h1>
                    <form:errors path="individu.*"/>
                    <form method="post" class="ui form" action="<c:url value="/individu/create"/>">
                        <div class="two fields">
                            <div class="field required">
                                <label>Matricule</label>
                                <input type="text" name="matricule"/>
                            </div>
                            <div class="field required">
                                <label>Sexe</label>
                                <input type="text" name="sexe"/>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="required field">
                                <label>Noms</label>
                                <input type="text" name="noms"/>
                            </div>
                            <div class="field">
                                <label>Prénoms</label>
                                <input type="text" name="prenoms"/>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="required field">
                                <label>Date Naissance</label>
                                <input type="date" name="dateNaissance"/>
                            </div>
                            <div class="field required">
                                <label>Lieu Naissance</label>
                                <input type="text" name="lieuNaissance"/>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>E-mail</label>
                                <input type="email" name="numero"/>
                            </div>

                            <div class="field required">
                                <label>Telephone</label>
                                <input type="number" name="telephone"/>
                            </div>
                        </div>
                        <div class="field">
                            <label>Residence</label>
                            <input type="text" name="residence"/>
                        </div>

                        <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                        <button class="ui button" type="submit">Enregistrer</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $("#multi-select").dropdown("get value");
            });
        </script>
    </body>
</html>

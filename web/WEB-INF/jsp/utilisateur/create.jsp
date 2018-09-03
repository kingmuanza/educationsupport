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
        <title>UTILISATEUR | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des utilisateurs
        </h1>
        <form:errors path="utilisateur.*"/>
        <form method="post" class="ui form" action="<c:url value="/utilisateur/create"/>">

            <div class="field">
                <label>Login</label>
                <input type="text" name="login" required="true"/>
            </div>
            <div class="field">
                <label>Mot de passe</label>
                <input type="passxord" name="motDePasse" required="true"/>
            </div>
            <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
            <button class="ui button" type="submit">Enregistrer</button>
        </form>

    </body>
</html>

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
        <title>MALADIE | Create</title>
    </head>
    <body>
        <h1 class="titre">
            Enregistrement des maladies
        </h1>
        <form:errors path="maladie.*"/>
        <form method="post" class="ui form" action="<c:url value="/maladie/create"/>" style="padding-top: 20px;">
            
                <div class="field">
                    <label>Nom</label>
                    <input type="text" name="nom" required="true"/>
                </div> 
                <div class="field">
                    <label>Description</label>
                    <input type="text" name="description" required="true"/>
                </div> 
                <div class="field">
                    <label>Type Maladie</label>
                    <input type="text" name="typeMaladie" required="true"/>
                </div> 
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <button class="ui button" type="submit">Enregistrer</button>
        </form>
        
    </body>
</html>

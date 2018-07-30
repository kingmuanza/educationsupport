<%-- 
    Document   : view
    Created on : 13 juil. 2018, 13:04:45
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
        <title>ELEVE | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Jour Absence</label></td>
                    <td><input type="text" name="jourAbsence" value="${eleve.jourAbsence}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>Absence Justifié</label></td>
                    <td><input type="text" name="justifee" value="${eleve.justifee}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>Motif</label></td>
                    <td><input type="text" name="motif" value="${eleve.motif}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${eleve.created}"/></td>
                    <td><input type="hidden" name="modified" value="${eleve.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${eleve.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/eleve/delete">
                            <input type="hidden" name="ideleve" value="${eleve.ideleve}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/eleve/edit/${eleve.ideleve}">Modifier</a> | <a href="/edusupport/eleve/list">Retour à la liste</a>
    </body>
</html>
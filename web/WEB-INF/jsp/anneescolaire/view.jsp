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
        <title>ANNEE SCOLAIRE | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Date Debut</label></td>
                    <td><input type="text" name="dateDebut" value="${anneescolaire.dateDebut}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Fin</label></td>
                    <td><input type="text" name="dateFin" value="${anneescolaire.dateFin}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>En Cours</label></td>
                    <td><input type="text" name="enCours" value="${anneescolaire.enCours}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${anneescolaire.created}"/></td>
                    <td><input type="hidden" name="modified" value="${anneescolaire.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${anneescolaire.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/anneescolaire/delete">
                            <input type="hidden" name="idanneescolaire" value="${anneescolaire.idanneescolaire}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/anneescolaire/edit/${anneescolaire.idanneescolaire}">Modifier</a> | <a href="/edusupport/anneescolaire/list">Retour à la liste</a>
    </body>
</html>
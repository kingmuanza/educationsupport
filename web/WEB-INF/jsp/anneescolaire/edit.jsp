<%-- 
    Document   : edit
    Created on : 13 juil. 2018, 13:04:25
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
        <title>ANNEE SCOLAIRE | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/anneescolaire/edit">
            <input type="hidden" name="idanneescolaire" value="${anneescolaire.idanneeScolaire}"/>
            <table>
                <tr>
                    <td><label>Date Début</label></td>
                    <td><input type="text" name="dateDebut" value="${anneescolaire.dateDebut}" required="true"/></td>
                    <td><label>Date Fin</label></td>
                    <td><input type="text" name="dateFin" value="${anneescolaire.dateFin}" required="true"/></td>
                    <td><label>En cours</label></td>
                    <td><input type="text" name="enCours" value="${anneescolaire.enCours}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${anneescolaire.created}"/></td>
                    <td><input type="hidden" name="modified" value="${anneescolaire.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${anneescolaire.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>
        <script>
            $(document).ready(function () {
                $("#multi-select").dropdown("get value");
                ouvrirMenuCorrespondant("#section_params", "bouton_params", "anneescolaire");
            });
        </script>
    </body>
</html>
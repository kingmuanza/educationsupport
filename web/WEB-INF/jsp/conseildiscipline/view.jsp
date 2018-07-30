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
        <title>CONSEIL DE DISCIPLINE | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" value="${conseildiscipline.code}" readonly="true"/></td>
                    <td><input type="text" name="dateDebut" value="${conseildiscipline.dateDebut}" readonly="true"/></td>
                    <td><input type="text" name="dateFin" value="${conseildiscipline.dateFin}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${conseildiscipline.created}"/></td>
                    <td><input type="hidden" name="modified" value="${conseildiscipline.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${conseildiscipline.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/conseildiscipline/delete">
                            <input type="hidden" name="idconseildiscipline" value="${conseildiscipline.idconseilDiscipline}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/conseildiscipline/edit/${conseildiscipline.idconseilDiscipline}">Modifier</a> | <a href="/edusupport/conseildiscipline/list">Retour à la liste</a>
    </body>
</html>
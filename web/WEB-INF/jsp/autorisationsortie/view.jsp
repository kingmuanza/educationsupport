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
        <title>AUTORISATION SORTIE | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" value="${autorisationsortie.code}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Jour</label></td>
                    <td><input type="text" name="dateJour" value="${autorisationsortie.dateJour}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${autorisationsortie.created}"/></td>
                    <td><input type="hidden" name="modified" value="${autorisationsortie.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${autorisationsortie.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/autorisationsortie/delete">
                            <input type="hidden" name="idautorisationsortie" value="${autorisationsortie.idautorisationSortie}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/autorisationsortie/edit/${autorisationsortie.idautorisationSortie}">Modifier</a> | <a href="/edusupport/autorisationsortie/list">Retour à la liste</a>
    </body>
</html>
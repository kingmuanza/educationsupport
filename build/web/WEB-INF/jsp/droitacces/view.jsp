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
        <title>DROIT D'ACCES | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Niveau</label></td>
                    <td><input type="text" name="niveau" value="${droitacces.niveau}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><input type="text" name="description" value="${droitacces.description}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${droitacces.created}"/></td>
                    <td><input type="hidden" name="modified" value="${droitacces.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${droitacces.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/droitacces/delete">
                            <input type="hidden" name="iddroitAcces" value="${droitacces.iddroitAcces}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/droitacces/edit/${droitacces.iddroitAcces}">Modifier</a> | <a href="/edusupport/droitacces/list">Retour à la liste</a>
    </body>
</html>
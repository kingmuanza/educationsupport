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
        <title>CONSEIL DE DISCIPLINE | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/conseildiscipline/edit">
            <input type="hidden" name="idconseildiscipline" value="${conseildiscipline.idconseildiscipline}"/>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" value="${conseildiscipline.code}" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Debut</label></td>
                    <td><input type="text" name="code" value="${conseildiscipline.dateDebut}" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Fin</label></td>
                    <td><input type="text" name="code" value="${conseildiscipline.dateFin}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${conseildiscipline.created}"/></td>
                    <td><input type="hidden" name="modified" value="${conseildiscipline.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${conseildiscipline.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
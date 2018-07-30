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
        <title>AUTORISATION SORTIE | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/autorisationsortie/edit">
            <input type="hidden" name="idautorisationsortie" value="${autorisationsortie.idautorisationSortie}"/>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" value="${autorisationsortie.code}" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Date Jour</label></td>
                    <td><input type="text" name="dateJour" value="${autorisationsortie.dateJour}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${autorisationsortie.created}"/></td>
                    <td><input type="hidden" name="modified" value="${autorisationsortie.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${autorisationsortie.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
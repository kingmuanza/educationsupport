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
        <title>DROIT D'ACCES | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/droitacces/edit">
            <input type="hidden" name="iddroitAcces" value="${droitacces.iddroitAcces}"/>
            <table>
                <tr>
                    <td><input type="text" name="jourAbsence" value="${droitacces.nvieau}" required="true"/></td>
                    <td><input type="text" name="justifee" value="${droitacces.description}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${droitacces.created}"/></td>
                    <td><input type="hidden" name="modified" value="${droitacces.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${droitacces.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
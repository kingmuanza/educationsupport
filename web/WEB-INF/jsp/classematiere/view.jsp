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
        <title>CLASSE | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="code" value="${classe.code}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${classe.created}"/></td>
                    <td><input type="hidden" name="modified" value="${classe.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${classe.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/classe/delete">
                            <input type="hidden" name="idclasse" value="${classe.idclasse}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/classe/edit/${classe.idclasse}">Modifier</a> | <a href="/edusupport/class/list">Retour à la liste</a>
    </body>
</html>
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
        <title>CONVOCATION | view</title>
    </head>
    <body>
            <table>
                <tr>
                    <td><label>Motif</label></td>
                    <td><input type="text" name="motif" value="${convocation.motif}" readonly="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${convocation.created}"/></td>
                    <td><input type="hidden" name="modified" value="${convocation.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${convocation.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form method="post" action="/edusupport/convocation/delete">
                            <input type="hidden" name="idconvocation" value="${convocation.idconvocation}"/>
                            <input type="submit" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
            </table>
            <a href="/edusupport/convocation/edit/${convocation.idconvocation}">Modifier</a> | <a href="/edusupport/convocation/list">Retour à la liste</a>
    </body>
</html>
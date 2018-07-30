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
        <title>CONVOCATION | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/convocation/edit">
            <input type="hidden" name="idconvocation" value="${convocation.idconvocation}"/>
            <table>
                <tr>
                    <td><input type="text" name="motif" value="${convocation.motif}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${convocation.created}"/></td>
                    <td><input type="hidden" name="modified" value="${convocation.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${convocation.deleted}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
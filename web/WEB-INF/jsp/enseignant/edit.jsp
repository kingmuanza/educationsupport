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
        <title>CLASSE | edit</title>
    </head>
    <body>
        <form method="post" action="/edusupport/absence/edit">
            <input type="hidden" name="idabsence" value="${absence.idabsence}"/>
            <table>
                <tr>
                    <td><label>Code</label></td>
                    <td><input type="text" name="jourAbsence" value="${absence.jourAbsence}" required="true"/></td>
                    <td><input type="text" name="justifee" value="${absence.justifee}" required="true"/></td>
                    <td><input type="text" name="motif" value="${absence.motif}" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="created" value="${absence.created}"/></td>
                    <td><input type="hidden" name="modified" value="${absence.modified}"/></td>
                    <td><input type="hidden" name="deleted" value="${absence.deleted}"/></td>
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
                ouvrirMenuCorrespondant("#section_params", "bouton_params", "enseignant");
            });
        </script>
    </body>
</html>
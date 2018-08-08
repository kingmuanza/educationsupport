<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABSENCE | Create</title>
    </head>
    <body >
        <form:errors path="absence.*"/>
        <form method="post" action="create" style="padding-top: 20px;">
            <table>
                <tr>
                    <td><label>Jour Absence</label></td>
                    <td><input type="text" name="jourAbsence" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Justifier ?</label></td>
                    <td><input type="text" name="justifee" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Motif</label></td>
                    <td><input type="text" name="motif" required="true"/></td>
                </tr>
                <c:import url="/WEB-INF/jsp/fieldsNotNull.jsp"/>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enregistrer"/></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>

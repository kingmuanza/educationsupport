<%-- 
    Document   : create
    Created on : 13 juil. 2018, 13:04:11
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
        <title>RELANCE | Create</title>
    </head>
    <body>
        <form:errors path="relance.*"/>
        <form method="post" action="<c:url value="/relance/create"/>">
            <table>
                <tr>
                    <td><label>Eleve qui nécessite être relancé</label></td>
                            <td><select  type="text" name="eleveIdeleve" required="true">
                                    <option> -- SELECT --</option>
                                    <c:forEach items="${eleves}" var="eleve">
                                            <option value="${eleve.ideleve}">${eleve.individuIdindividu.prenoms} ${eleve.individuIdindividu.noms}</option>
                                        
                                    </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Motif</label></td>
                    <td><input type="text" name="motif" /></td>
                </tr>
                <tr>
                    <td><label>Montant </label></td>
                    <td><input type="number" name="montant" required="true"/></td>
                </tr>
                <tr>
                    <td><label>Echeance</label></td>
                    <td><input type="date" name="echeance" required="true"/></td>
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

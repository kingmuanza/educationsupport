<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PREPA VOGT</title>
        <style>
            .card{
                cursor: pointer;
            }
        </style>

    </head>
    <body>
        <h1 class="titre" style="font-size: 3.0em">
            Accueil 
        </h1>
        <div style="color : #444; font-size: 1.4em; opacity: 1; padding-bottom: 25px; margin-top: -15px">
            Bienvenue sur le portail d'Education Support. 
        </div>

        <div class="ui four column grid">
            <div class="column">
                <div class="ui blue fluid card" onclick="window.location.href='#!/retards'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/A-teacher-scolding-a-student-for-late-arrival-for-the-exam.jpg"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/A-teacher-scolding-a-student-for-late-arrival-for-the-exam.jpg"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Retards</a>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="ui teal fluid card"  onclick="window.location.href='#!/absences'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/at_school.jpg"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/at_school.jpg"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Absences</a>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="ui green fluid card"  onclick="window.location.href='#!/convocations'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/sanctions.jpg"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/sanctions.jpg"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Convocations</a>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="ui olive fluid card"  onclick="window.location.href='#!/autorisationsorties'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/malade.jpg"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/malade.jpg"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Permissions</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui four column grid">

            <div class="column">
                <div class="ui yellow fluid card" onclick="window.location.href='#!/sanctions'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/castigo.jpg"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/castigo.jpg"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Sanctions</a>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="ui orange fluid card" onclick="window.location.href='#!/retards'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/conseil-classe-college-2195091-jpg_1913896_660x281.JPG"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/conseil-classe-college-2195091-jpg_1913896_660x281.JPG"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Conseils de discipline</a>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="ui red fluid card" onclick="window.location.href='#!/trimestres'">
                    <div class="ui slide masked reveal image">
                        <img class="visible noirsurblanc content" src="<c:url value="/resources/images/bulletin.JPG"/>" alt=""/>
                        <img class="hidden content" src="<c:url value="/resources/images/bulletin.JPG"/>" alt=""/>
                    </div>
                    <div class="content">
                        <a class="header">Résultats</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Education Support</title>
        <link href="<c:url value="/resources/css/semantic.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/myapp.css?id=1"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/Semantic-UI-Alert.css"/>" rel="stylesheet">
    </head>
    <body ng-app="myApp" style="height: 100vh; overflow-y: hidden; ">
        <div class="ui grid">
            <div class="noir" style="width: 6vw; height: 110vh; margin: 0px!important; padding: 0px;important">
                <div style="padding-top: 5vw;">
                    <div id="bouton_profil" onclick="gestionnaireSections('#section_profil', this)" class="section_bouton">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="calendar times outline big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>
                    <div id="bouton_pointeuse" onclick="gestionnaireSections('#section_pointeuse', this)" class="section_bouton">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="money bill alternate big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>
                    <div id="bouton_accueil" onclick="gestionnaireSections('#section_accueil', this)" class="section_bouton active">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="info circle big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>
                    <div id="bouton_visites" onclick="gestionnaireSections('#section_visites', this)" class="section_bouton">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="street view big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>
                    <div id="bouton_stats" onclick="gestionnaireSections('#section_stats', this)" class="section_bouton">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="list ol big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>

                    <div id="bouton_params" onclick="gestionnaireSections('#section_params', this)"  class="section_bouton">
                        <div style="position: relative;top: 50%; left: 30%;transform: translateY(-50%);">
                            <i class="whmcs big icon fg-white" style="z-index: 45177777;"></i>
                        </div>
                    </div>

                </div>
            </div>

            <div class="gris" style="width: 18vw; height: 110vh; padding-top: 25px;">

                <div style="padding-left: 10px; padding-right : 10px;" id="section_profil"  class="section_muanza">
                    <h1>Discipline</h1>
                    <div class="ui accordion vertical fluid following text menu">
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Abscences et retards</b>
                            </a>
                            <div class="active content menu">
                                <a class="item active" href="#!abscences">Absences </a>
                                <a class="item active" href="#!retards">Retards </a>
                                <a class="item active" href="#!permissions">Permissions </a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Conduite</b>
                            </a>
                            <div class="active content menu">
                                <a class="item active" href="#!sanctions">Sanctions </a>
                                <a class="item active" href="#!convocations">Convocations </a>
                                <a class="item active" href="#!conseils">Conseils de disciplines </a>
                            </div>
                        </div>
                    </div>

                </div>
                <div style="padding-left: 10px;" id="section_pointeuse" class="section_muanza">
                    <h1>Scolarité</h1>
                    <div class="ui accordion vertical fluid following text menu">
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Paiements</b>
                            </a>
                            <div class="active content menu">
                                <a class="item active" href="#!statistiques/collaborateur">Historique </a>
                                <a class="item active" href="#!statistiques/collaborateur">Statistiques </a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Insolvabilités</b>
                            </a>
                            <div class="active content menu">
                                <a class="item active" href="#!tempsreel">Liste des insolvables </a>
                                <a class="item active" href="#!configuration">Moratoires </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding-left: 10px;" id="section_accueil" class="section_muanza">
                    <h1>Informations</h1>
                    
                    <div class="ui accordion vertical fluid following text menu">
                        <div class="item active">
                            <a class="active title">
                                <i class="dropdown icon"></i> 
                                <b>Calendrier</b>
                            </a>
                            <div class="active content menu">
                                <a class="item" href="#!reunions">Réunions des parents</a>
                                <a class="item" href="#!calendrier">Calendrier des examens</a>
                            </div>
                        </div>
                        <div class="item active">
                            <a class="active title">
                                <i class="dropdown icon"></i> 
                                <b>Urgence </b>
                            </a>
                            <div class="active content menu">
                                <a class="item" href="#!sante">Santé</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding-left: 10px;" id="section_stats"  class="section_muanza">
                    <h1>Résultats</h1>

                    <div class="ui accordion vertical fluid following text menu">

                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Liste des examens</b>
                            </a>
                            <div class="active content menu">
                                <a class="item" href="#!statistiques">Examen 1</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding-left: 10px;" id="section_visites"  class="section_muanza">
                    <h1>Suivi</h1>

                    <div class="ui accordion vertical fluid following text menu">
                        <div class="item active">
                            <a class="active title">
                                <i class="dropdown icon"></i> 
                                <b>Individuel</b>
                            </a>
                            <div class="active content menu">
                                <a class="item" href="#!eleves">Liste des élèves</a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Global</b>
                            </a>
                            <div class="active content menu">
                                <a class="item" href="#!classes">Statistiques par classe</a>
                                <a class="item" href="#!classes">Statistiques globales</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding-left: 10px;" id="section_params"  class="section_muanza">
                    <h1>Paramètres</h1>
                    <div class="ui accordion vertical fluid following text menu">
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> <b>Gestions des utilisateurs</b>
                            </a>
                            <div class="content menu">
                                <a class="item" href="#!utilisateurs">Utilisateurs</a>
                                <a class="item" href="#!profils">Profils utilisateurs</a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Personnes et qualités</b>
                            </a>
                            <div class="content menu">
                                <a class="item" href="#!individus">Individus</a>
                                <a class="item" href="#!collaborateurs">Collaborateurs</a>
                                <a class="item" href="#!postes">Postes</a>
                                <a class="item" href="#!enseignants">Enseignants</a>
                                <a class="item" href="#!etudiants">Elèves</a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Paramètres académiques</b>
                            </a>
                            <div class="content menu">
                                <a class="item" href="#!anneeacademiques">Années scolaires</a>
                                <a class="item" href="#!filieres">Series</a>
                                <a class="item" href="#!matieres">Matières</a>
                                <a class="item" href="#!coursall">Cours</a>
                                <a class="item" href="#!classes">Classes</a>
                                <a class="item" href="#!niveaux">Trimestre</a>
                                <a class="item" href="#!sequences">Séquences</a>
                            </div>
                        </div>
                        <div class="item">
                            <a class="title">
                                <i class="dropdown icon"></i> 
                                <b>Accueil</b>
                            </a>
                            <div class="content menu">
                                <a class="item" href="#!badges">Bagdes pour visiteur</a>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <div style="width: 76vw; height: 100vh; overflow-x: hidden; overflow-y: hidden; padding-top: 20px; padding-right: 5px!important;margin-right: 10px!important;">
                <div class="ui secondary  menu">
                    <a class="item teal">
                        <i class="circle loading icon titre"></i>
                        Connecté à internet
                    </a>
                    <a id="chargement" class="item titre active ">
                        <i style="float:right" class="titre spinner loading icon"></i>
                        Chargement
                    </a>
                    <!--a class="item">
                        Exporter vers Excel
                    </a>
                    <a class="item">
                        Exporter en PDF
                    </a-->
                    <div class="right menu">
                        <div class="item">
                            <div class="ui icon input">
                                <input type="text" placeholder="Rechercher...">
                                <i class="search link icon"></i>
                            </div>
                        </div>
                        <div class="ui item dropdown">
                            ${sessionScope.utilisateur.login}
                            <i class="dropdown icon"></i>
                            <div class="menu">
                                <a href="start#!/motPasse/${sessionScope.utilisateur.idutilisateur}" class="item">Modifier le mot de passe</a>
                                <a href="DeconnexionServlet" class="item">Déconnexion</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="height: 90vh; overflow-y: scroll">
                    <div  ng-view style="min-height: 100vh; margin-top: -20px; padding-bottom: 40px;" class="espace_cotes">

                    </div>
                </div>
            </div>

        </div>




        <!-- Fichiers JS-->
        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/semantic.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/particles/particles.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Semantic-UI-Alert.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/angular.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/angular-route.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/myapp.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/routage.js?id=18"/>" type="text/javascript"></script>

        <script>
                        $(document).ready(function () {
                            $('.ui.dropdown').dropdown();
                            console.log("Fichier start ok !");
            <c:forEach items="${notifications}" var="n">

                            $.uiAlert({
                                textHead: "${n.titre}",
                                text: "${n.message}",
                                bgcolor: '${n.success ? "#004d6f":"#DB2828"} ',
                                textcolor: '#fff',
                                position: 'top-right', // top And bottom ||  left / center / right
                                icon: 'checkmark box',
                                time: 5
                            });
            </c:forEach>

                        });
                        $(document).ajaxStart(function () {
                            console.log("AJAX started")
                        });

                        $(document).ajaxStop(function () {
                            console.log("AJAX stop")
                        });
                        $(window).bind('hashchange', function () {
                            $("#chargement").fadeIn("slow", function () {
                                $("#chargement").fadeOut("slow")
                            });
                        });
        </script>
    </body>
</html>

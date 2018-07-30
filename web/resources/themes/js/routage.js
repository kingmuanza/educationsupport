/*
 *---------------------- Routage de angular JS ---------------------------------
 */

function UrlExists(url) {
    var http = new XMLHttpRequest();
    http.open('HEAD', url, false);
    http.send();
    console.log(http.status);
    if(http.status==200){
        return url;
    }else{
        return "notfound.jsp";
    }

}
var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
            .when("/", {
                templateUrl: UrlExists("aujourdhui")
            })
            .when("/absences", {
                templateUrl: UrlExists("absence/list ")
            })
            .when("/anneesscolaires", {
                templateUrl: UrlExists("anneesscolaire/list ")
            })
            .when("/autorisationsorties", {
                templateUrl: UrlExists("autorisationsortie/list ")
            })
            .when("/classes", {
                templateUrl: UrlExists("classe/list ")
            })
            .when("/conseildisciplines", {
                templateUrl: UrlExists("conseildiscipline/list ")
            })
            .when("/convocations", {
                templateUrl: UrlExists("convocation/list ")
            })
            .when("/droitsacces", {
                templateUrl: UrlExists("droitsacce/list ")
            })
            .when("/eleves", {
                templateUrl: UrlExists("eleve/list ")
            })
            .when("/elevesmaladies", {
                templateUrl: UrlExists("elevesmaladie/list ")
            })
            .when("/elevestraduits", {
                templateUrl: UrlExists("elevestraduit/list ")
            })
            .when("/employes", {
                templateUrl: UrlExists("employe/list ")
            })
            .when("/enseignants", {
                templateUrl: UrlExists("enseignant/list ")
            })
            .when("/evaluations", {
                templateUrl: UrlExists("evaluation/list ")
            })
            .when("/individus", {
                templateUrl: UrlExists("individu/list ")
            })
            .when("/maladies", {
                templateUrl: UrlExists("maladie/list ")
            })
            .when("/matieres", {
                templateUrl: UrlExists("matiere/list ")
            })
            .when("/moratoires", {
                templateUrl: UrlExists("moratoire/list ")
            })
            .when("/paiements", {
                templateUrl: UrlExists("paiement/list ")
            })
            .when("/passageinfirmeries", {
                templateUrl: UrlExists("passageinfirmerie/list ")
            })
            .when("/rapports", {
                templateUrl: UrlExists("rapport/list ")
            })
            .when("/relances", {
                templateUrl: UrlExists("relance/list ")
            })
            .when("/retards", {
                templateUrl: UrlExists("retard/list ")
            })
            .when("/reunions", {
                templateUrl: UrlExists("reunion/list ")
            })
            .when("/sanctions", {
                templateUrl: UrlExists("sanction/list ")
            })
            .when("/sequences", {
                templateUrl: UrlExists("sequence/list ")
            })
            .when("/trimestres", {
                templateUrl: UrlExists("trimestre/list ")
            })
            .when("/utilisateurs", {
                templateUrl: UrlExists("utilisateur/list ")
            })
            .when("/insolvables", {
                templateUrl: UrlExists("paiement/insolvables/list ")
            })
            .otherwise({
                redirectTo: '/'
            });
});
/*----------------------------------------------------------------------------*/



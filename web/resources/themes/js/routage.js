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
            .when("/absence", {
                templateUrl: UrlExists("absence/create ")
            })
            .when("/anneescolaires", {
                templateUrl: UrlExists("anneescolaire/list ")
            })
            .when("/anneescolaire", {
                templateUrl: UrlExists("anneescolaire/create ")
            })
            .when("/autorisationsorties", {
                templateUrl: UrlExists("autorisationsortie/list ")
            })
            .when("/autorisationsortie", {
                templateUrl: UrlExists("autorisationsortie/create ")
            })
            .when("/classes", {
                templateUrl: UrlExists("classe/list ")
            })
            .when("/classe", {
                templateUrl: UrlExists("classe/create ")
            })
            .when("/conseildisciplines", {
                templateUrl: UrlExists("conseildiscipline/list ")
            })
            .when("/conseildiscipline", {
                templateUrl: UrlExists("conseildiscipline/create ")
            })
            .when("/convocations", {
                templateUrl: UrlExists("convocation/list ")
            })
            .when("/convocation", {
                templateUrl: UrlExists("convocation/create ")
            })
            .when("/droitsacces", {
                templateUrl: UrlExists("droitacces/list ")
            })
            .when("/droitsacce", {
                templateUrl: UrlExists("droitacces/create ")
            })
            .when("/eleves", {
                templateUrl: UrlExists("eleve/list ")
            })
            .when("/eleve", {
                templateUrl: UrlExists("eleve/create ")
            })
            .when("/elevesmaladies", {
                templateUrl: UrlExists("elevesmaladie/list ")
            })
            .when("/elevesmaladie", {
                templateUrl: UrlExists("elevesmaladie/create ")
            })
            .when("/elevestraduits", {
                templateUrl: UrlExists("elevestraduit/list ")
            })
            .when("/elevestraduit", {
                templateUrl: UrlExists("elevestraduit/create ")
            })
            .when("/employes", {
                templateUrl: UrlExists("employe/list ")
            })
            .when("/employe", {
                templateUrl: UrlExists("employe/create ")
            })
            .when("/enseignants", {
                templateUrl: UrlExists("enseignant/list ")
            })
            .when("/enseignant", {
                templateUrl: UrlExists("enseignant/create ")
            })
            .when("/evaluations", {
                templateUrl: UrlExists("evaluation/list ")
            })
            .when("/evaluation", {
                templateUrl: UrlExists("evaluation/create ")
            })
            .when("/individus", {
                templateUrl: UrlExists("individu/list ")
            })
            .when("/individu", {
                templateUrl: UrlExists("individu/create ")
            })
            .when("/maladies", {
                templateUrl: UrlExists("maladie/list ")
            })
            .when("/maladie", {
                templateUrl: UrlExists("maladie/create ")
            })
            .when("/matieres", {
                templateUrl: UrlExists("matiere/list ")
            })
            .when("/matiere", {
                templateUrl: UrlExists("matiere/create ")
            })
            .when("/moratoires", {
                templateUrl: UrlExists("moratoire/list ")
            })
            .when("/moratoire", {
                templateUrl: UrlExists("moratoire/create ")
            })
            .when("/paiements", {
                templateUrl: UrlExists("paiement/list ")
            })
            .when("/paiement", {
                templateUrl: UrlExists("paiement/create ")
            })
            .when("/passageinfirmeries", {
                templateUrl: UrlExists("passageinfirmerie/list ")
            })
            .when("/passageinfirmerie", {
                templateUrl: UrlExists("passageinfirmerie/create ")
            })
            .when("/rapports", {
                templateUrl: UrlExists("rapport/list ")
            })
            .when("/rapport", {
                templateUrl: UrlExists("rapport/create ")
            })
            .when("/relances", {
                templateUrl: UrlExists("relance/list ")
            })
            .when("/relance", {
                templateUrl: UrlExists("relance/create ")
            })
            .when("/retards", {
                templateUrl: UrlExists("retard/list ")
            })
            .when("/retard", {
                templateUrl: UrlExists("retard/create ")
            })
            .when("/reunions", {
                templateUrl: UrlExists("reunion/list ")
            })
            .when("/reunion", {
                templateUrl: UrlExists("reunion/create ")
            })
            .when("/sanctions", {
                templateUrl: UrlExists("sanction/list ")
            })
            .when("/sanction", {
                templateUrl: UrlExists("sanction/create ")
            })
            .when("/sequences", {
                templateUrl: UrlExists("sequence/list ")
            })
            .when("/sequence", {
                templateUrl: UrlExists("sequence/create ")
            })
            .when("/trimestres", {
                templateUrl: UrlExists("trimestre/list ")
            })
            .when("/trimestre", {
                templateUrl: UrlExists("trimestre/create ")
            })
            .when("/utilisateurs", {
                templateUrl: UrlExists("utilisateur/list ")
            })
            .when("/utilisateur", {
                templateUrl: UrlExists("utilisateur/create ")
            })
            .when("/insolvables", {
                templateUrl: UrlExists("paiement/insolvables/list ")
            })
            .when("/insolvable", {
                templateUrl: UrlExists("paiement/insolvables/create ")
            })
            .otherwise({
                redirectTo: '/'
            });
});
/*----------------------------------------------------------------------------*/



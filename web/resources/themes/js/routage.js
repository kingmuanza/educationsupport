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
                templateUrl: UrlExists("accueil")
            })
            .when("/absences", {
                templateUrl: UrlExists("absence/list ")
            })
            .when("/absence", {
                templateUrl: UrlExists("absence/create ")
            })
            .when("/absence/:id", {
                templateUrl: function (params) {
                    return UrlExists("absence/edit/"+  params.id);
                }
            })
            .when("/anneescolaires", {
                templateUrl: UrlExists("anneescolaire/list ")
            })
            .when("/anneescolaire", {
                templateUrl: UrlExists("anneescolaire/create ")
            })
            .when("/anneescolaire/:id", {
                templateUrl: function (params) {
                    return UrlExists("anneescolaire/edit/"+  params.id);
                }
            })
            .when("/autorisationsorties", {
                templateUrl: UrlExists("autorisationsortie/list ")
            })
            .when("/autorisationsortie", {
                templateUrl: UrlExists("autorisationsortie/create ")
            })
            .when("/autorisationsortie/:id", {
                templateUrl: function (params) {
                    return UrlExists("autorisationsortie/edit/"+  params.id);
                }
            })
            .when("/classes", {
                templateUrl: UrlExists("classe/list ")
            })
            .when("/classe", {
                templateUrl: UrlExists("classe/create ")
            })
            .when("/classe/:id", {
                templateUrl: function (params) {
                    return UrlExists("classe/edit/"+  params.id);
                }
            })
            .when("/classesmatieres", {
                templateUrl: UrlExists("classematiere/list ")
            })
            .when("/classematiere", {
                templateUrl: UrlExists("classematiere/create ")
            })
            .when("/classematiere/:id", {
                templateUrl: function (params) {
                    return UrlExists("classematiere/edit/"+  params.id);
                }
            })
            .when("/conseildisciplines", {
                templateUrl: UrlExists("conseildiscipline/list ")
            })
            .when("/conseildiscipline", {
                templateUrl: UrlExists("conseildiscipline/create ")
            })
            .when("/conseildiscipline/:id", {
                templateUrl: function (params) {
                    return UrlExists("conseildiscipline/edit/"+  params.id);
                }
            })
            .when("/convocations", {
                templateUrl: UrlExists("convocation/list ")
            })
            .when("/convocation", {
                templateUrl: UrlExists("convocation/create ")
            })
            .when("/convocation/:id", {
                templateUrl: function (params) {
                    return UrlExists("convocation/edit/"+  params.id);
                }
            })
            .when("/droitsacces", {
                templateUrl: UrlExists("droitacces/list ")
            })
            .when("/droitsacce", {
                templateUrl: UrlExists("droitacces/create ")
            })
            .when("/droitsacce/:id", {
                templateUrl: function (params) {
                    return UrlExists("droitsacce/edit/"+  params.id);
                }
            })
            .when("/eleves", {
                templateUrl: UrlExists("eleve/list ")
            })
            .when("/eleve", {
                templateUrl: UrlExists("eleve/create ")
            })
            .when("/eleve/:id", {
                templateUrl: function (params) {
                    return UrlExists("eleve/edit/"+  params.id);
                }
            })
            .when("/elevesmaladies", {
                templateUrl: UrlExists("elevesmaladie/list ")
            })
            .when("/elevesmaladie", {
                templateUrl: UrlExists("elevesmaladie/create ")
            })
            .when("/elevesmaladie/:id", {
                templateUrl: function (params) {
                    return UrlExists("elevesmaladie/edit/"+  params.id);
                }
            })
            .when("/elevestraduits", {
                templateUrl: UrlExists("elevestraduit/list ")
            })
            .when("/elevestraduit", {
                templateUrl: UrlExists("elevestraduit/create ")
            })
            .when("/elevestraduit/:id", {
                templateUrl: function (params) {
                    return UrlExists("elevestraduit/edit/"+  params.id);
                }
            })
            .when("/employes", {
                templateUrl: UrlExists("employe/list ")
            })
            .when("/employe", {
                templateUrl: UrlExists("employe/create ")
            })
            .when("/employe/:id", {
                templateUrl: function (params) {
                    return UrlExists("employe/edit/"+  params.id);
                }
            })
            .when("/enseignants", {
                templateUrl: UrlExists("enseignant/list ")
            })
            .when("/enseignant", {
                templateUrl: UrlExists("enseignant/create ")
            })
            
            .when("/enseignant/:id", {
                templateUrl: function (params) {
                    return UrlExists("enseignant/edit/"+  params.id);
                }
            })
            .when("/enseignantsclassesmatieres", {
                templateUrl: UrlExists("enseignantclassematiere/list ")
            })
            .when("/enseignantclassematiere", {
                templateUrl: UrlExists("enseignantclassematiere/create ")
            })
            .when("/enseignantclassematiere/:id", {
                templateUrl: function (params) {
                    return UrlExists("enseignantclassematiere/edit/"+  params.id);
                }
            })
            .when("/evaluations", {
                templateUrl: UrlExists("evaluation/list ")
            })
            .when("/evaluation", {
                templateUrl: UrlExists("evaluation/create ")
            })
            .when("/evaluation/:id", {
                templateUrl: function (params) {
                    return UrlExists("evaluation/edit/"+  params.id);
                }
            })
            .when("/individus", {
                templateUrl: UrlExists("individu/list ")
            })
            .when("/individu", {
                templateUrl: UrlExists("individu/create ")
            })
            .when("/individu/:id", {
                templateUrl: function (params) {
                    return UrlExists("individu/edit/" + params.id)
                }
            })
            .when("/maladies", {
                templateUrl: UrlExists("maladie/list ")
            })
            .when("/maladie", {
                templateUrl: UrlExists("maladie/create ")
            })
            .when("/maladie/:id", {
                templateUrl: function (params) {
                    return UrlExists("maladie/edit/"+  params.id);
                }
            })
            .when("/matieres", {
                templateUrl: UrlExists("matiere/list ")
            })
            .when("/matiere", {
                templateUrl: UrlExists("matiere/create ")
            })
            
            .when("/matiere/:id", {
                templateUrl: function (params) {
                    return UrlExists("matiere/edit/"+  params.id);
                }
            })
            .when("/moratoires", {
                templateUrl: UrlExists("moratoire/list ")
            })
            .when("/moratoire", {
                templateUrl: UrlExists("moratoire/create ")
            })
            .when("/moratoire/:id", {
                templateUrl: function (params) {
                    return UrlExists("moratoire/edit/"+  params.id);
                }
            })
            .when("/notes", {
                templateUrl: UrlExists("note/list ")
            })
            .when("/note", {
                templateUrl: UrlExists("note/create ")
            })
            .when("/note/:id", {
                templateUrl: function (params) {
                    return UrlExists("note/edit/"+  params.id);
                }
            })
            .when("/paiements", {
                templateUrl: UrlExists("paiement/list ")
            })
            .when("/paiement", {
                templateUrl: UrlExists("paiement/create ")
            })
            .when("/paiement/:id", {
                templateUrl: function (params) {
                    return UrlExists("paiement/edit/"+  params.id);
                }
            })
            .when("/passageinfirmeries", {
                templateUrl: UrlExists("passageinfirmerie/list ")
            })
            .when("/passageinfirmerie", {
                templateUrl: UrlExists("passageinfirmerie/create ")
            })
            .when("/passageinfirmerie/:id", {
                templateUrl: function (params) {
                    return UrlExists("passageinfirmerie/edit/"+  params.id);
                }
            })
            .when("/rapports", {
                templateUrl: UrlExists("rapport/list ")
            })
            .when("/rapport", {
                templateUrl: UrlExists("rapport/create ")
            })
            
            .when("/rapport/:id", {
                templateUrl: function (params) {
                    return UrlExists("rapport/edit/"+  params.id);
                }
            })
            .when("/relances", {
                templateUrl: UrlExists("relance/list ")
            })
            .when("/relance", {
                templateUrl: UrlExists("relance/create ")
            })
            .when("/relance/:id", {
                templateUrl: function (params) {
                    return UrlExists("relance/edit/"+  params.id);
                }
            })
            .when("/retards", {
                templateUrl: UrlExists("retard/list ")
            })
            .when("/retard", {
                templateUrl: UrlExists("retard/create ")
            })
            
            .when("/retard/:id", {
                templateUrl: function (params) {
                    return UrlExists("retard/edit/"+  params.id);
                }
            })
            .when("/reunions", {
                templateUrl: UrlExists("reunion/list ")
            })
            .when("/reunion", {
                templateUrl: UrlExists("reunion/create ")
            })
            .when("/reunion/:id", {
                templateUrl: function (params) {
                    return UrlExists("reunion/edit/"+  params.id);
                }
            })
            .when("/sanctions", {
                templateUrl: UrlExists("sanction/list ")
            })
            .when("/sanction", {
                templateUrl: UrlExists("sanction/create ")
            })
            .when("/sanction/:id", {
                templateUrl: function (params) {
                    return UrlExists("sanction/edit/"+  params.id);
                }
            })
            .when("/sallesdeclasses", {
                templateUrl: UrlExists("salledeclasse/list ")
            })
            .when("/salledeclasse", {
                templateUrl: UrlExists("salledeclasse/create ")
            })
            .when("/salledeclasse/:id", {
                templateUrl: function (params) {
                    return UrlExists("salledeclasse/edit/"+  params.id);
                }
            })
            .when("/sequences", {
                templateUrl: UrlExists("sequence/list ")
            })
            .when("/sequence", {
                templateUrl: UrlExists("sequence/create ")
            })
            .when("/sequence/:id", {
                templateUrl: function (params) {
                    return UrlExists("sequence/edit/"+  params.id);
                }
            })
            .when("/trimestres", {
                templateUrl: UrlExists("trimestre/list ")
            })
            .when("/trimestre", {
                templateUrl: UrlExists("trimestre/create ")
            })
            .when("/trimestre/:id", {
                templateUrl: function (params) {
                    return UrlExists("trimestre/edit/"+  params.id);
                }
            })
            .when("/utilisateurs", {
                templateUrl: UrlExists("utilisateur/list ")
            })
            .when("/utilisateur", {
                templateUrl: UrlExists("utilisateur/create ")
            })
            .when("/utilisateur/:id", {
                templateUrl: function (params) {
                    return UrlExists("utilisateur/edit/"+  params.id);
                }
            })
            .when("/insolvables", {
                templateUrl: UrlExists("paiement/insolvables/list ")
            })
            .when("/insolvable", {
                templateUrl: UrlExists("paiement/insolvables/create ")
            })
            .when("/insolvable/:id", {
                templateUrl: function (params) {
                    return UrlExists("paiement/insolvable/edit/"+  params.id);
                }
            })
            .otherwise({
                redirectTo: '/'
            });
});
/*----------------------------------------------------------------------------*/



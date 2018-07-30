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
                templateUrl: UrlExists("classe/list")
            })
            .otherwise({
                redirectTo: '/'
            });
});
/*----------------------------------------------------------------------------*/



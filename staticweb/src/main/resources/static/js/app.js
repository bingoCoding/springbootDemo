var ngAction = angular.module("actionApp",["ngRoute"]);
ngAction.config(["$routeProvider",function ($routeProvider) {
    $routeProvider
        .when("/admin",{
            controller:"View1Controller",
            templateUrl:"view1.html",
        }).when("/directive",{
            controller:"View2Controller",
            templateUrl:"view2.html",
        });
}]);
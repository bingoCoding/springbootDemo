ngAction.controller("View1Controller",["$rootScope","$scope","$http",function ($rootScope,$scope,$http) {
    $scope.$on("$viewContentLoaded",function () {
        console.info("页面加载完成");
    })
    $scope.search=function () {
        personName=$scope.persionName;
        $http.get("/search",{params:{"personName":personName}}).success(function (data) {
            $scope.person=data;
        });
    };
}]);

ngAction.controller("View2Controller",["$rootScope","$scope","$http",function ($rootScope,$scope) {
    $scope.$on("$viewContentLoaded",function () {
        console.info("页面加载完成");
    })

}]);
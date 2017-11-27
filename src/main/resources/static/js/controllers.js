/**
 * Created by hjhuang on 2017/1/23.
 */

actionApp.controller('ViewController',['$rootScope','$scope','$http',
    function($rootScope,$scope,$http) {
        console.log('@@@@@@@@@@@@@');
        $scope.$on('$viewContentLoaded',function () {
           console.log('页面加载完成');
        });

        $scope.search = function () {
            personName = $scope.personName;
            $http.get('search',{
                data:{personName:personName}}).then(function (data) {
                console.log('@@@@@@@@@',data);
                $scope.person = data.data;
            });
        };
    }
]);

actionApp.controller('View2Controller',['$rootScope','$scope','$http',
    function($rootScope,$scope) {
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成');
        });
    }
]);

actionApp.controller('LoginController',['$scope','$http',
    function($scope,$http) {
        console.log('@@@@@@@@@@@@@2222222222');
        $scope.user = {id:"222"} ;

        $scope.login = function () {
            console.log($scope.user);
            var user = $scope.user;
            $http({url:"login",
                method:'post',
                data:{username:user.username,password:user.password}}).then(function (data) {
                console.log('@@@@@@@@@',data);
            });
        }
    }
]);

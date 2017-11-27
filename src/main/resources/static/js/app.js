/**
 * Created by hjhuang on 2017/1/22.
 */

var actionApp =  angular.module('actionApp',['ngRoute']);

actionApp.config(['$locationProvider','$routeProvider', function ($locationProvider,$routeProvider) {
    console.log('@@@@@@@@@11111');

    $locationProvider.hashPrefix('!');

    $routeProvider.when('/oper',{
        controller:'ViewController',
        templateUrl:'views/view1.html'
    }).when('/directive',{
        controller:'View2Controller',
        templateUrl:'views/view2.html'
    }).when('/login',{
        controller:'LoginController',
        templateUrl:'login.html'
    });


    
}]);
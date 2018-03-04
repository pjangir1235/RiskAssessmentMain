$(document).foundation();
var app = angular.module('module1', ['ui.router', 'angular-growl', 'angular.filter']);

app.controller('welcomeController', function ($window, $scope, $state) {
  console.log("hii");
  $state.go('schedule');
});

app.controller('loginController', function ($rootScope, $window, $scope, $state) {
  $scope.login = function () {
    $window.location.href = "./riskAssessment.html";
  }
});

app.controller('scheduleController', function ($rootScope, $window, $scope, $state) {
  $scope.startAnalysis = function () {
    $state.go('reportAnalysis')
  }
});

app.controller('reportAnalysisController', function ($rootScope, $window, $scope, $state) {
  $scope.startAnalysis = function () {
    $state.go('')
  }
});






app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {


  $urlRouterProvider.otherwise('/');

  $stateProvider

    .state('schedule', {
      url: '/schedule',
      templateUrl: 'schedule.html',
      controller: 'scheduleController'
    }).state('reportAnalysis', {
      url: '/reportAnalysis',
      templateUrl: 'reportAnalysis.html',
      controller: 'reportAnalysisController'
    })



}]);
app.config(['growlProvider', function (growlProvider) {
  growlProvider.globalDisableCountDown(true);

}]);

$(document).ready(function () {
  $('#example').DataTable();
});
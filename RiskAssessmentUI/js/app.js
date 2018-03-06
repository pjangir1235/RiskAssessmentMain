$(document).foundation();
var app = angular.module('module1', ['ui.router', 'angular-growl', 'angular.filter']);

app.controller('welcomeController', function ($window, $scope, $state) {
  var user = $window.sessionStorage.getItem('userName');
  if (user == '' || user == null)
    $window.location.href = './index,html';
  $scope.logOut = function () {
    $window.sessionStorage.removeItem('userName');
    $window.location.href = './index,html';
  }
  $state.go('schedule');
});

app.controller('loginController', function ($rootScope, $window, $scope, $state, loginVerification, growl) {
  $scope.login = function () {
    console.log('Hello');
    if ($scope.user == "" || $scope.user == null) {
      growl.warning("Enter User name", {
        ttl: 1500
      });
    }
    else if ($scope.password == "" || $scope.password == null) {
      growl.warning("Enter Password", {
        ttl: 1500
      });
    }
    else {
      var data = {
        'userName': $scope.user,
        'password': $scope.password
      }
      loginVerification.loginCheck(data).then(function (data) {
        console.log(data.data);
        if (data.data == null || data.data == '') {
          growl.error("Wrong ID and Password", {
            ttl: 1500
          });
        }
        else {
          $window.sessionStorage.setItem('userName', $scope.user);
          $window.location.href = "./home.html";
        }

      });

    }
  }

});
app.service('loginVerification', ['$http', '$window', 'growl', function ($http, $window, $state, growl) {
  this.loginCheck = function (data) {
    return (
      $http.post('/RiskAssessment/user', data).success(function (data, response) {
        return data;

      }).error(function (response, status) {

        console.log(status);
        return status;

      })
    );
  }

}]);

app.controller('scheduleController', function ($rootScope, $window, $scope, $state, scheduleService) {
  scheduleService.getLocation().then(function (data) {
    console.log(data.data);
    $scope.location = data.data;
  });





  $scope.startAnalysis = function () {
    $state.go('reportAnalysis')
  }
})

app.service('scheduleService', ['$http', '$window', 'growl', function ($http, $window, $state, growl) {
  this.getLocation = function () {
    return (
      $http.get('/RiskAssessment/airport').success(function (data, response) {
        return data;
      }).error(function (response, status) {

        console.log(status);
        return status;

      })
    );
  }
}]);

app.controller('reportAnalysisController', function ($rootScope, ow, $scope, $state) {
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
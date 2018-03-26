$(document).foundation();
var app = angular.module('module1', ['angular-loading-bar', 'ui.router', 'angular-growl', 'angular.filter']);


app.controller('welcomeController', function ($window, $scope, $state) {
  var user = $window.sessionStorage.getItem('userName');
  if (user == '' || user == null)
    $window.location.href = './index,html';
  $scope.logOut = function () {
    $window.sessionStorage.removeItem('userName');
    $window.location.href = './index,html';
  }
  $scope.userName = user;
  $state.go('schedule');
});

app.controller('loginController', function ($rootScope, $window, $scope, $state, loginVerification, growl) {
  $scope.login = function () {
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
      $scope.loginLoading = true;
      loginVerification.loginCheck(data).then(function (data) {
        $scope.loginLoading = false;
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

app.controller('scheduleController', function ($rootScope, $window, $scope, $state, scheduleService, growl) {
  $scope.scheduleLoading = true;
  $scope.table_hide = true;
  $scope.analysisButton = true;
  var dateAdd = (24 * 60 * 60 * 1000);

  scheduleService.getLocation().then(function (data) {
    $scope.scheduleLoading = false;
    $scope.location = data.data;
  });
  $scope.checkLocation = function () {
    $scope.dateValue = null;
  }
  $scope.getSchedule = function () {
    $scope.locations = [];
    $scope.table_hide = true;
    if ($scope.dateValue != null && $scope.dateValue != '' && $scope.locationValue != null && $scope.locationValue != '') {
      $scope.newdate = new Date(new Date($scope.dateValue.getTime() + dateAdd));
      $scope.newdate = $scope.newdate.toISOString().substr(0, 10);

      var data = {
        'location': $scope.locationValue,
        'date': $scope.newdate
      }
      $scope.scheduleLoading = true;
      scheduleService.getFlightSchedule(data).then(function (data) {
        $scope.scheduleLoading = false;
        if (data.data == null || data.data == '') {

          growl.error("No Flight scheduled in location " + $scope.locationValue + " on " + $scope.newdate, {
            ttl: 4000
          });
        }
        else {
          $scope.table_hide = false;
          $scope.analysisButton = false;
          $scope.schedules = data.data

        }

      });
    }
    $scope.analysis = function () {
      if ($scope.SelectedScheduleId == null || $scope.SelectedScheduleId == '')
        growl.warning("Select any one of Schedule ", {
          ttl: 2000
        });
      else {
        $window.sessionStorage.setItem('schedule', JSON.stringify($scope.schedules[$scope.SelectedScheduleId]));
        $state.go('analysisHome');
      }
    }
  }






})

app.service('scheduleService', ['$http', '$window', 'growl', function ($http, $window, $state, growl) {


  this.getLocation = function () {
    // 
    return (
      $http.get('/RiskAssessment/airport').success(function (data, response) {
        // $scope.scheduleLoading = false;
        return data;
      }).error(function (response, status) {
        // $scope.scheduleLoading = false;
        return status;

      })
    );

  }
  this.getFlightSchedule = function (data) {

    return (

      $http.post('/RiskAssessment/flightSchedule', data).success(function (data, response) {
        insertCaptains(data);
        return data;
      }).error(function (response, status) {
        console.log(status);
        return status;

      })
    );

  }
  function insertCaptains (schedules) {
    var i = 0;
    schedules.forEach(schedule => {
      var captain = schedule.pilots.find((pilot) => pilot.pilotDesignationCode == "PD1");
      if (captain) {
        schedule.captain = captain.pilotName;

      }
      else {
        schedule.captain = "NA";

      }
      var firstPilot = schedule.pilots.find((pilot) => pilot.pilotDesignationCode == "PD2");
      if (firstPilot) {
        schedule.firstPilot = firstPilot.pilotName;

      }
      else {
        schedule.firstPilot = "NA";

      }
      schedule.position = i++;
    });
  }
}]);


app.controller('analysisHomeController', function ($rootScope, $window, $scope, $state, scheduleService, growl) {
  $scope.scheduleDetail = JSON.parse($window.sessionStorage.getItem('schedule'));
  console.log($scope.scheduleDetail);
  $scope.firstPilot = $scope.scheduleDetail.firstPilot;
  $scope.aircraftCode = $scope.scheduleDetail.aircraftCode;
  $scope.captain = $scope.scheduleDetail.captain;
  $scope.sourceDate = $scope.scheduleDetail.dateOfDeparture;
  $scope.sourceLocation = $scope.scheduleDetail.sourceAirportCode;
  $scope.destinationLocation = $scope.scheduleDetail.destinationAirportCode;

})
app.controller('reportAnalysisController', function ($rootScope, $window, $scope, $state) {


});






app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {


  $urlRouterProvider.otherwise('/');

  $stateProvider

    .state('schedule', {
      url: '/schedule',
      templateUrl: 'schedule.html',
      controller: 'scheduleController',
    })
    .state('analysisHome', {
      url: '/analysisHome',
      templateUrl: 'analysisHome.html',
      controller: 'analysisHomeController',
      resolve: {
        timing: function ($timeout, $q) {
          var defer = $q.defer();
          $timeout(function () {
            defer.resolve();
          }, 3500);
          return defer.promise;
        }
      }
    })
    .state('analysisHome.aircraft', {
      url: '/aircraft',
      templateUrl: 'aircraft.html',
      // controller: 'aircraftController',

    })
    .state('analysisHome.aircraftData', {
      url: '/aircraftData',
      templateUrl: 'aircraftData.html',
      // controller: 'aircraftDataController'
    })
    .state('analysisHome.destinationAirport', {
      url: '/destinationAirport',
      templateUrl: 'destinationAirport.html',
      //   controller: 'destinationAirportController'
    })
    .state('analysisHome.environmentData', {
      url: '/environmentData',
      templateUrl: 'environmentData.html',
      // controller: 'environmentDataController'
    })
    .state('analysisHome.humanPerformance', {
      url: '/humanPerformance',
      templateUrl: 'humanPerformance.html',
      // controller: 'humanPerformanceController'
    })
    .state('analysisHome.pilotData', {
      url: '/pilotData',
      templateUrl: 'pilotData.html',
      // controller: 'pilotDataController'
    })
    .state('analysisHome.profeciency', {
      url: '/profeciency',
      templateUrl: 'profeciency.html',
      // controller: 'profeciencyController'
    })
    .state('analysisHome.result', {
      url: '/result',
      templateUrl: 'result.html',
      // controller: 'resultController'
    })
    .state('analysisHome.sourceAirport', {
      url: '/sourceAirport',
      templateUrl: 'sourceAirport.html',
      // controller: 'sourceAirportController'
    })
}]);
app.config(['growlProvider', function (growlProvider) {
  growlProvider.globalDisableCountDown(true);


}]);

$(document).ready(function () {
  $('#example').DataTable();
});
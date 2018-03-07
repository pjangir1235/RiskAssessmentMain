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

app.controller('scheduleController', function ($rootScope, $window, $scope, $state, scheduleService, growl) {
  $scope.table_hide = true;
  $scope.analysisButton = true;
  var dateAdd = (24 * 60 * 60 * 1000);
  scheduleService.getLocation().then(function (data) {
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
      scheduleService.getFlightSchedule(data).then(function (data) {
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
        $state.go('reportAnalysis');
      }
    }
  }






})

app.service('scheduleService', ['$http', '$window', 'growl', function ($http, $window, $state, growl) {
  this.getLocation = function () {
    return (
      $http.get('/RiskAssessment/airport').success(function (data, response) {

        return data;
      }).error(function (response, status) {
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

app.controller('reportAnalysisController', function ($rootScope, $window, $scope, $state) {
  $scope.scheduleDetail = JSON.parse($window.sessionStorage.getItem('schedule'));
  console.log($scope.scheduleDetail);
  $scope.firstPilot = $scope.scheduleDetail.firstPilot;
  $scope.aircraftCode = $scope.scheduleDetail.aircraftCode;
  $scope.captain = $scope.scheduleDetail.captain;
  $scope.sourceDate = $scope.scheduleDetail.dateOfDeparture;
  $scope.sourceLocation = $scope.scheduleDetail.sourceAirportCode;
  $scope.destinationLocation = $scope.scheduleDetail.destinationAirportCode;

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
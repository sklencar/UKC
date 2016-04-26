'use strict';

angular.module('clientApp')
  .controller('EventsCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {


    $scope.title = '';
    $scope.description;

    $scope.load = function () {
      var data = JSON.stringify({
        id: $routeParams['id'],
      });

      $http({
        method: 'GET',
        url: '/app/event/'+$routeParams['id']
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);

        $scope.pic = '../images/' + response.data[0].roomId + '.jpg';
        $scope.title = response.data[0].title;
        $scope.description = response.data[0].description;
        $scope.startDate = response.data[0].startDate;
        $scope.endDate = response.data[0].startDate;
        //$scope.endDate = moment(response.data[0].endDateTime).format('MM/DD/YYYY');;
        $scope.room = $scope.subjectListOptions[response.data[0].roomId];


      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });

    }

    $scope.subjectListOptions = {
      '1': 'Kuchynka',
      '2': 'Spoločenská miestnosť',
      '3': 'Klubovňa'
    };

    $scope.load();
  }]);




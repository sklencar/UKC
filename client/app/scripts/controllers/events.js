'use strict';

angular.module('clientApp')
  .controller('EventsCtrl', ['$scope', '$http', '$location', '$route', '$routeParams',  function ($scope, $http, $location, $route, $routeParams) {


    //$location.
    console.log($route.current.params);
    console.log($routeParams['id']);

    $scope.title = '';
    $scope.description;

    $scope.load = function () {

      var id = $routeParams['id'];

      $http({
        method: 'GET',
        url: '/app/event/',
        params: {
          id: '8'
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);

        $scope.title = response.data.title;
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });

    }

    $scope.load();
  }]);




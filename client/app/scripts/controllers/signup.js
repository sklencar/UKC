'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('SignupCtrl', function ($scope, $http, $log) {

    $scope.user = {};

    $scope.signup = function () {
      var data = JSON.stringify({
        fullname: $scope.user.displayName ? $scope.user.displayName : '' ,
        email: $scope.user.email ? $scope.user.email : '',
        password: $scope.user.password ? $scope.user.password : '',
      });

      $http({
        method: 'POST',
        url: '/app/signup',
        //contentType: "application/json"
        params: {
          json: data
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
        $scope.user = {};
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);

      }).finally(function () {
        console.log('request sent');
      });
    }

    /*$scope.signup = function() {
      var payload = {
        email : $scope.email,
        password : $scope.password
      };



      $http.post('app/signup', payload)
        .success(function(data) {
          $log.debug(data);
        });
    };*/
  });

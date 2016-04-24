'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('ContactCtrl', function ($scope, $http, $log) {
    $scope.signup = function() {
      var payload = {
        email : $scope.email,
        password : $scope.password
      };

      $http.post('app/contact', payload)
        .success(function(data) {
          $log.debug(data);
        });
    };
  });

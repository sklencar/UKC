'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('ContactCtrl', function ($scope, $http, $route) {


    $scope.$route = $route;

    $scope.getActiveTab = function(){
      return "contact";
    }

    $scope.resetForm = function() {
      $scope.name = '';
      $scope.body = '';
      $scope.email = '';
      $scope.subject = '';
    }

    $scope.resetForm();
    $scope.sendMail = function () {

      var data = JSON.stringify({
        name: $scope.name ? $scope.name : '',
        email: $scope.email ? $scope.email : '',
        body: $scope.body ? $scope.body : '',
        subject: $scope.subject ? $scope.subject :''
    });

      $http({
        method: 'POST',
        url: '/app/contact/',
        params: {
          json: data
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
        $scope.resetForm();
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
        $scope.isLoaded = false;
      }).finally(function () {
        console.log('request sent');
      });
    };


  });

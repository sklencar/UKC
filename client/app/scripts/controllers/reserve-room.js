'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('ReserveRoomCtrl', function ($scope, $http, $log, $timeout) {

    // date and time picker
    $scope.pickerStart = {
      date: new Date(),
      open: false
    };

    $scope.pickerEnd = {
      date: new Date(),
      open: false
    };

    $scope.openCalendar = function(e, picker) {
      $scope[picker].open = true;
    };


    /* var payload = {
       email : $scope.email,
       password : $scope.password
     };
     $http.post('app/signup', payload)
       .success(function(data) {
         $log.debug(data);
       });*/


    $scope.subjectListOptions = {
      '1': 'Kuchynka',
      '2': 'Spoločenská miestnosť',
      '3': 'Klubovňa'
    };


    $scope.createEvent = function(form) {


      var data = JSON.stringify({
          title: $scope.title,
          email: $scope.email,
          room_id: $scope.room,
          comments: $scope.comments,
          owner_id: '1',
          start_date: $scope.pickerStart.date.getTime(),
          end_date: $scope.pickerEnd.date.getTime()
        });

      $http({
        method: 'POST',
        url: '/app/reserve-room',
        //contentType: "application/json"
        params: {
          json: data
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });
    };

    $scope.getReservations = function(event_id){
      $http({
        method: 'GET',
        url: '/app/reserve-room',
        //contentType: "application/json"
        params: {
          id: event_id
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });
    };

    // Form submit handler.
    $scope.submitReservation = function (form) {
      // Trigger validation flag.
      $scope.submitted = true;

      // If form is invalid, return and let AngularJS show validation errors.
      if (form.$invalid) {
        return;
      }

      $scope.createEvent(form);

      // Default values for the request.
      var config = {
        params: {
          'callback': 'JSON_CALLBACK',
          'name': $scope.name,
          'email': $scope.email,
          'subjectList': $scope.subjectList,
          'url': $scope.url,
          'comments': $scope.comments
        },
      };

    /*  // Perform JSONP request.
      var $promise = $http.jsonp('response.json', config)
        .success(function (data, status, headers, config) {
          if (data.status == 'OK') {
            $scope.name = null;
            $scope.email = null;
            $scope.subjectList = null;
            $scope.url = null;
            $scope.comments = null;
            $scope.messages = 'Your form has been sent!';
            $scope.submitted = false;
          } else {
            $scope.messages = 'Oops, we received your request, but there was an error processing it.';
            $log.error(data);
          }
        })
        .error(function (data, status, headers, config) {
          $scope.progress = data;
          $scope.messages = 'There was a network error. Try again later.';
          $log.error(data);
        })
        .finally(function () {
          // Hide status messages after three seconds.
          $timeout(function () {
            $scope.messages = null;
          }, 3000);
        });*/

      // Track the request and show its progress to the user.
      //$scope.progress.addPromise($promise);
    };

  });

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

    ///////////////////

    $scope.beginDate = new Date();

    // date and time picker
    $scope.pickerStart = {
      date: new Date(),
      minDate: new Date(),
      open: false
    };

    $scope.pickerEnd = {
      date: new Date(),
      minDate: new Date(),
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

    /*  if ($scope.validateDate(form)) {
        return;
      }*/

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

  })

  .controller('DateTimePickerDemoCtrl',
    function ($scope, $timeout) {
      $scope.dateTimeNow = function() {
        $scope.date = new Date();
      };
      $scope.dateTimeNow();

      $scope.toggleMinDate = function() {
        var minDate = new Date();
        // set to yesterday
        minDate.setDate(minDate.getDate() - 1);
        $scope.minDate = $scope.minDate ? null : minDate;
      };

      $scope.toggleMinDate();

      $scope.dateOptions = {
        showWeeks: false
      };

      // Disable weekend selection
      $scope.disabled = function(calendarDate, mode) {
        return mode === 'day' && ( calendarDate.getDay() === 0 || calendarDate.getDay() === 6 );
      };

      $scope.open = function($event,opened) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.dateOpened = true;
      };

      $scope.dateOpened = false;
      $scope.hourStep = 1;
      $scope.format = "dd-MMM-yyyy";
      $scope.minuteStep = 15;

      $scope.timeOptions = {
        hourStep: [1, 2, 3],
        minuteStep: [1, 5, 10, 15, 25, 30]
      };

      $scope.showMeridian = true;
      $scope.timeToggleMode = function() {
        $scope.showMeridian = !$scope.showMeridian;
      };

      $scope.$watch("date", function(date) {
        // read date value
      }, true);

      $scope.resetHours = function() {
        $scope.date.setHours(1);
      };
    });

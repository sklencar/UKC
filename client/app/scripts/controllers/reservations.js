'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('ReservationsCtrl', ['$scope', '$http', '$filter', '$route', '$location', 'uiGridConstants', function ($scope, $http, $filter, $route, $location, uiGridConstants) {
    $scope.$route = $route;

    $scope.isTabActive = function(route) {
      return route === $location.path();
    }

    $scope.selections = [];
    $scope.gridOptions = {
      excludeProperties: '__metadata',
      enablePaginationControls: false,
      enableFiltering: true,
      enableSorting: true,
      enableRowSelection: true,
      selectedItems: $scope.selections,

      afterSelectionChange: function () {
        if ($scope.selections != "") {
          $scope.disabled = false;
        } else {
          $scope.disabled = true;
        }
      },
      onRegisterApi: function (gridApi) {
        $scope.gridApi = gridApi;
        //gridApi.selection.on.rowSelectionChanged($scope, callbackFunction);
        //gridApi.selection.on.rowSelectionChangedBatch($scope, callbackFunction);
      }
    }



    $scope.gridOptions.columnDefs = [
      {name: 'id', enableCellEdit: false,  enableFiltering: false, width: '10%',
        displayName: 'Link',
       /* cellTemplate:'<div>' +
        '<a href="http://stackoverflow.com"><span><i class="fa fa-arrow-circle-right"></i></span> link</a>' +
        '</div>' },*/
        cellTemplate: '<a ng-href="#event/id={{row.entity.id}}" ng-click="grid.appScope.test()">{{row.entity.id}}</a>'},
      {name: 'title', enableCellEdit: false, displayName: 'Názov', width: '35%'},
      {name: 'startDate', displayName: 'Začiatok', enableCellEdit: false, width: '20%'},
      {name: 'endDate', displayName: 'Koniec', enableCellEdit: false, width: '20%'},
      {name: 'room.name', displayName: 'Miestnosť', enableCellEdit: false ,width: '15%'}
    /*  ,
      {name: 'title', enableCellEdit: false, displayName: 'Názov', width: '40%',
        cellTemplate:'<div>' +
        '<a href="http://stackoverflow.com"></a>' +
        '</div>' },*/

    ];


    $scope.load = function () {

      $http({
        method: 'GET',
        url: '/app/reservations',
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
        $scope.gridOptions.data = response.data;
      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });

    }

    $scope.load();
  }]);




'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('ReservationsCtrl', ['$scope', '$http', '$filter', 'uiGridConstants', function ($scope, $http, $filter, uiGridConstants) {
    $scope.sort = [];
    $scope.filter = [];
    $scope.pagination = {
      pageSize: 5,
      pageNumber: 1,
      totalItems: null,
      getTotalPages: function () {
        return Math.ceil(this.totalItems / this.pageSize);
      },
      nextPage: function () {
        if (this.pageNumber < this.getTotalPages()) {
          this.pageNumber++;
          $scope.load();
        }
      },
      previousPage: function () {
        if (this.pageNumber > 1) {
          this.pageNumber--;
          $scope.load();
        }
      }
    };

    $scope.gridOptions = {
      excludeProperties: '__metadata',
      enablePaginationControls: false,
      enableFiltering: true,
      enableSorting: true,

    };

    $scope.gridOptions.columnDefs = [
      {name: 'id', enableCellEdit: false, width: '5%'},
      {name: 'title', enableCellEdit: false, displayName: 'Názov', width: '40%'},
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

        var json = [{"id":7,"title":"bb","startDate":"Apr 23, 2016 4:11:08 PM","endDate":"Apr 23, 2016 4:11:08 PM","description":"eee","roomId":1,"ownerId":1}];
        $scope.gridOptions.data = response.data;


      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
      }).finally(function () {
        console.log('request sent');
      });

    }

    $scope.load();
    console.log('Debug');
  }]);




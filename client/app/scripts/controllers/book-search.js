'use strict';

angular.module('clientApp')
  .controller('BookSearchCtrl', function ($scope, $http, $log, $timeout) {

      $scope.isLoaded = false;
    //$scope.gridOptions.data = [];

    $scope.gridOptions = {
      excludeProperties: '__metadata',
      enablePaginationControls: false,
      enableFiltering: true,
      enableSorting: true,
      onRegisterApi: function( gridApi ) {
        $scope.grid1Api = gridApi;
      }
    };

    $scope.gridOptions.columnDefs = [
      {name: 'surname', displayName: 'Autor', enableCellEdit: false, width: '20%'},
      {name: 'title', displayName: 'Názov', enableCellEdit: false,  width: '40%'},
      {name: 'genre', displayName: 'Žáner', enableCellEdit: false, width: '20%'},
      {name: 'rented', displayName: 'Požičaná', enableCellEdit: false,  width: '10%'},
      /*  ,
       {name: 'title', enableCellEdit: false, displayName: 'Názov', width: '40%',
       cellTemplate:'<div>' +
       '<a href="http://stackoverflow.com"></a>' +
       '</div>' },*/

    ];

    $scope.genreListOptions = {
      '0': '-',
      '1': 'Kuchynka',
      '2': 'Spoločenská miestnosť',
      '3': 'Klubovňa'
    };




    $scope.search = function(form) {

      var data = JSON.stringify({
        author: $scope.author ? $scope.author : '' ,
        title: $scope.title ? $scope.title : '',
        genre: $scope.genre ? $scope.genre : '',
      });

      $http({
        method: 'GET',
        url: '/app/book-search/',
        params: {
          json: data
        }
      }).then(function successCallback(response) {
        console.log('successCallback: ' + response);
        $scope.gridOptions.data = response.data;
        $scope.isLoaded = true;
        $scope.gridOptions.onRegisterApi = function(gridApi) {
          $scope.gridApi = gridApi;
        };
        //$scope.gridOptions.gridApi.core.refresh()

      }, function errorCallback(response) {
        console.log('errorCallback: ' + response);
        $scope.isLoaded = false;
      }).finally(function () {
        console.log('request sent');
      });
    };

    // Form submit handler.
    $scope.submitSearch = function (form) {
      // Trigger validation flag.
      $scope.submitted = true;

     /* // If form is invalid, return and let AngularJS show validation errors.
      if (form.$invalid) {
        return;
      }*/

      $scope.search(form);

      // TODO
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

    };

  });

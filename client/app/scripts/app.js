'use strict';

/**
 * @ngdoc overview
 * @name clientApp
 * @description
 * # clientApp
 *
 * Main module of the application.
 */
angular
  .module('clientApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'ui.bootstrap.datetimepicker',
    'ngMaterial',
    'ui.grid',
    'ui.grid.edit'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl',
        controllerAs: 'contact'
      })
      .when('/book-search', {
        templateUrl: 'views/book-search.html',
        controller: 'BookSearchCtrl',
        controllerAs: 'book-search'
      })
      .when('/reservations', {
        templateUrl: 'views/reservations.html',
        controller: 'ReservationsCtrl',
        controllerAs: 'reservations'
      })
      .when('/reserve-room', {
        templateUrl: 'views/reserve-room.html',
        controller: 'ReserveRoomCtrl',
        controllerAs: 'reserve-room'
      })
      .when('/signup', {
        templateUrl: 'views/signup.html',
        controller: 'SignupCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

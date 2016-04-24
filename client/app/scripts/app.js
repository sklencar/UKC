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
    'ui.bootstrap.dateparser',
    'ui.bootstrap.datepicker',
    'ui.bootstrap.timepicker',
    'ngMaterial',
    'ui.grid',
    'ui.grid.edit',
    'ui.grid.infiniteScroll'
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
      .when('/event/id=?:id', {
        templateUrl: 'views/event.html',
        controller: 'EventsCtrl',
        controllerAs: 'events'
      })
      .when('/signup', {
        templateUrl: 'views/signup.html',
        controller: 'SignupCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

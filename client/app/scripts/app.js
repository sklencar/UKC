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
    'ui.grid.infiniteScroll',
    'satellizer'
  ])
  .config(function ($routeProvider, $authProvider) {
    // TODO migrate to ui router
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main',
        activetab: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about',
        activetab: 'about'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl',
        controllerAs: 'contact',
        activetab: 'contact'
      })
      .when('/book-search', {
        templateUrl: 'views/book-search.html',
        controller: 'BookSearchCtrl',
        controllerAs: 'book-search',
        activetab: 'book-search'
      })
      .when('/reservations', {
        templateUrl: 'views/reservations.html',
        controller: 'ReservationsCtrl',
        controllerAs: 'reservations'
      })
      .when('/reserve-room', {
        templateUrl: 'views/reserve-room.html',
        controller: 'ReserveRoomCtrl',
        controllerAs: 'reserve-room',
        activetab: 'reserve-room'
      })
      .when('/event/id=?:id', {
        templateUrl: 'views/event.html',
        controller: 'EventsCtrl',
        controllerAs: 'events',
        activetab: 'reservations'
      })
     /* .when('/signup', {
        templateUrl: 'views/signup.html',
        controller: 'SignupCtrl',
        controllerAs: 'signup',
        activetab: 'signup'
      })*/
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
        /*resolve: {
          skipIfLoggedIn: skipIfLoggedIn
        }*/
      })
      .when('/signup', {
        templateUrl: 'views/signup.html',
        controller: 'SignupCtrl'
        /*resolve: {
          skipIfLoggedIn: skipIfLoggedIn
        }*/
      })
      .when('logout', {
        url: '/logout',
        template: null,
        controller: 'LogoutCtrl'
      })
      .otherwise({
        redirectTo: '/reserve-room'
      });

    $authProvider.httpInterceptor = function() { return true; },
      $authProvider.withCredentials = true;
    $authProvider.tokenRoot = null;
    $authProvider.cordova = false;
    $authProvider.baseUrl = '/';
    $authProvider.loginUrl = '/api/auth/login';
    $authProvider.signupUrl = '/api/auth/signup';
    $authProvider.unlinkUrl = '/api/auth/unlink/';
    $authProvider.tokenName = 'token';
    $authProvider.tokenPrefix = 'satellizer';
    $authProvider.authHeader = 'Authorization';
    $authProvider.authToken = 'Bearer';
    $authProvider.storageType = 'localStorage';

    function skipIfLoggedIn($q, $auth) {
      var deferred = $q.defer();
      if ($auth.isAuthenticated()) {
        deferred.reject();
      } else {
        deferred.resolve();
      }
      return deferred.promise;
    }

    function loginRequired($q, $location, $auth) {
      var deferred = $q.defer();
      if ($auth.isAuthenticated()) {
        deferred.resolve();
      } else {
        $location.path('/login');
      }
      return deferred.promise;
    }
  })
  .run(function($rootScope, $window, $auth) {
    if ($auth.isAuthenticated()) {
      $rootScope.currentUser = JSON.parse($window.localStorage.currentUser);
    }});

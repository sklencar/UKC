angular.module('clientApp')
  .controller('LoginCtrl', function($scope, $location, $auth) {
    $scope.login = function() {
      $auth.login($scope.user)
        .then(function() {
          $location.path('/');
        })
        .catch(function(error) {
        });
    };
    $scope.authenticate = function(provider) {
      $auth.authenticate(provider)
        .then(function() {
          $location.path('/');
        })
        .catch(function(error) {
          if (error.error) {
            // Popup error - invalid redirect_uri, pressed cancel button, etc.
          } else if (error.data) {
            // HTTP response error from server
          } else {
          }
        });
    };
  });

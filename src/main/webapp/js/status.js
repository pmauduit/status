(function() {
  var module = angular.module('status', []);
  module.controller('InstanceController', [
    '$scope',
    '$http',
    function($scope, $http) {
        var instancesUrl = './app/instances';

        $http.get(instancesUrl).success(function(data) {
          $scope.instances = data.instances;
        });

      }]);
})();
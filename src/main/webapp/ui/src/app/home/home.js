angular.module('study.home', [
	'ui.router',
	'service.homeservice'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.home', {
		url: '/home',
		templateUrl: 'home/home.tpl.html',
		controller: 'HomeCtrl',
		data: {
			roles: [ 'Admin' ]
		}
	});
})

.controller('HomeCtrl', function ($window, $scope, HomeService, $state, ApiConstants) {
	$window.console.log('In HomeCtrl');
	$scope.updateMenu();
	
 	HomeService.listitem().then(function (items) {
		$scope.items = items;
	});
    
    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "Not started";
		}
		return new Date(oldDate).toLocaleString();
	};
})

;

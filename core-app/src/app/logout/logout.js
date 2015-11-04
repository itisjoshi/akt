angular.module('study.logout', [
	'security.authentication',
	'ui.router'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.logout', {
		url: '/logout',
		templateUrl: 'logout/logout.tpl.html',
		controller: 'LogoutCtrl',
		data: {
			pageTitle: 'Logout',
			roles: [ 'Admin']
		}
	});
})

.controller('LogoutCtrl', function ($window, $scope, $state, AuthenticationService) {
	$window.console.log('In LogoutCtrl');
	
	AuthenticationService.logout()
		.then(function (isLoggedOut) {
			$state.go('study.login');
		}, function () {
			// do nothing
		});
})

;

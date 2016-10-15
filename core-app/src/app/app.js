angular.module('study', [
	'templates-app',
	'templates-common',
	'study.login',
	'study.logout',
	'study.patient',
	'study.patientvisit',
	'study.patientimmunization',
	'study.patientprofile',
	'security',
	'service.httprequesttracker',
	'ui.router'
])

.constant('ApiConstants', {

	BaseUrl: 'http://localhost:8081/ROOT/api/',
})

.config(function myAppConfig ($stateProvider, $urlRouterProvider, $provide) {
	$urlRouterProvider.otherwise('/login');

	$provide.decorator('$state', function ($delegate, $rootScope) {
		$rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
			$delegate.next = toState;
			$delegate.toParams = toParams;
		});
		return $delegate;
	});

	$stateProvider.state('study', {
		abstract: true,
		templateUrl: 'app.tpl.html',
		controller: 'RootCtrl',
		data: {
			pageTitle: 'Brindha clinic',
			roles: [ 'Anonymous' ]
		},
		resolve: {
			user: function (AuthorizationService, $q, $state) {
				var deferred = $q.defer();

				AuthorizationService.checkAuthorized($state.next)
					.then(function (authorized) {
						deferred.resolve(authorized);
					}, function (error) {
						deferred.reject(error);
					});

				return deferred.promise;
			}
		}
	});
})

.run(function run () {
})

.controller('AppCtrl', function ($window, $scope, $location) {
	$scope.pageTitle = 'Ctrl Threads';
	$window.console.log('In AppCtrl');
	$scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
		if (angular.isDefined(toState.data.pageTitle)) {
			$scope.pageTitle = toState.data.pageTitle + ' | Invent - CtrlThreads' ;
		}
	});
})

.controller('HeaderCtrl', function ($window, $scope, $state) {
	$window.console.log('In HeaderCtrl');

	$scope.menuItems = [
		{
			state: 'study.login',
			name: 'Login'
		}
	];

	$scope.goHome = function() {
		$state.go('study.login');
	};

	$scope.$on('updateMenuItems', function (event, menuItems) {
		$scope.menuItems = menuItems;
	});
})

.controller('FooterCtrl', function ($window, $scope) {
	$window.console.log('In FooterCtrl');
})

.controller('RootCtrl', function ($window, $scope, $rootScope, httpRequestTracker, AuthenticationService) {
	$window.console.log('In RootCtrl');

	$scope.updateMenu = function () {
		var anonymousMenuItems = [
			{
				state: 'study.login',
				name: 'Login'
			}
		];
		
		var adminMenuItems = [
			{
				state: 'study.patient',
				name: 'Patients'
			},
			{
				state: 'study.logout',
				name: 'Logout'
			}
		];
		
		
		if (AuthenticationService.currentUser.roles.indexOf('Admin') !== -1) {
			$rootScope.$broadcast('updateMenuItems', adminMenuItems);
		} 
	};

	$scope.isLoading = function () {
		return httpRequestTracker.hasPendingRequests();
	};
})

;

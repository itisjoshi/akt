angular.module('security.authentication', [
	'ui.router'
])

.factory('AuthenticationService', function ($window, $http, $q, ApiConstants, Security, $state) {
	var service = {
		currentUser: null
	};

	service.homePage = function () {
		var state = Security.DefaultHomeState;
		angular.forEach(Security.Roles, function (Role) {
			if (service.currentUser && service.currentUser.roles.indexOf(Role.role) !== -1) {
				state = Role.homeState;
			}
		});
		return state;
	};

	service.login = function (username, password) {
		var reqeust = $http({
			method: 'POST',
			url: ApiConstants.BaseUrl + 'login',
			data: 'username=' + username + '&password=' + password,
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			withCredentials: true
		});

		return reqeust.then(function (response) {
			if (response.status === 200) {
				return service.requestCurrentUser().then(function (response) {
					return true;
				}, function (response) {
					return false;
				});
			}
			return false;
		}, function (response) {
			return false;
		});
	};

	service.logout = function () {
		return $http.get(ApiConstants.BaseUrl + 'logout').then(function (response) {
			if (response.status === 200) {
				service.currentUser = null;
				return true;
			}
			return false;
		}, function (response) {
			return false;
		});
	};

	service.forgotPassword = function (user) {
		return $http.post(ApiConstants.BaseUrl + 'forgotpassword', user)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				}
				return false;
			});
	};

	service.changePassword = function (passwords) {
		return $http.put(ApiConstants.BaseUrl + 'currentuser/changepassword', passwords)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				}
				return false;
			});
	};

	service.verifyUser = function (params) {
		return $http.get(ApiConstants.BaseUrl + 'verifyuser/' + params.email + '/' + params.hashcode)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				}
				return false;
			}, function (response) {
				return false;
			});
	};

	service.setPassword = function (loginParams) {
		return $http.put(ApiConstants.BaseUrl + 'verifyuser/setpassword', loginParams)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				}
				return false;
			}, function (response) {
				return false;
			});
	};

	service.getUserDetails = function () {
		return $http.get(ApiConstants.BaseUrl + 'currentuser/details')
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				}
				return {};
			});
	};

	service.updateUserDetails = function (userDetails) {
		return $http.put(ApiConstants.BaseUrl + 'currentuser/details/update', userDetails)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				}
				return false;
			});
	};

	service.isAuthenticated = function () {
		return !!service.currentUser;
	};

	service.requestCurrentUser = function () {
		if (service.isAuthenticated()) {
			return $q.when(service.currentUser);
		} else {
			return $http.get(ApiConstants.BaseUrl + 'currentuser')
				.then(function (response) {
					if (response.status === 200) {
						service.currentUser = response.data;
						return service.currentUser;
					}
					return null;
				}, function (response) {
					return null;
				});
		}
	};

	return service;
})

;

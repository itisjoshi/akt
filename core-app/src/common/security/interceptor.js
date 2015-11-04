angular.module('security.interceptor', [
	'ui.router'
])

.factory('securityInterceptor', function ($injector, ApiConstants, Security) {
	return {
		request: function(config) {
			if (config.url.indexOf(ApiConstants.BaseUrl) !== -1) {
				config.withCredentials = true;
			}
			return config;
		},
		responseError: function(response) {
			var state = $injector.get('$state');
			var service;
			if (response.status === 401) {
				// All pages requests for session. If the person
				// is not authenticated then it creates loop in
				// redirection. So do nothing.
				service = $injector.get('$window');
				// service.location.href = Security.AuthFailedUrl;
			} else if (response.status === 403) {
				service = $injector.get('AuthenticationService');
				state.go(service.homePage());
			}
			return response;
		}
	};
})

.config(function ($httpProvider) {
	$httpProvider.interceptors.push('securityInterceptor');
})

;

angular.module('service.homeservice', [
])

.factory('HomeService', ['$window', '$http', 'ApiConstants', function ($window, $http, ApiConstants) {
	var service = {};

	service.listitem = function () {
		return $http.get(ApiConstants.BaseUrl + 'item/list')
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	return service;
}])

;

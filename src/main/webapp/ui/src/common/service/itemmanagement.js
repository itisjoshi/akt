angular.module('service.itemmanagement', [
])

.factory('ItemManagementService', function ($http, ApiConstants) {
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

	service.deleteitem = function (item) {
		return $http.post(ApiConstants.BaseUrl + 'item/delete', item)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.edititem = function (item) {
		return $http.post(ApiConstants.BaseUrl + 'item/edit', item)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.createitem = function (item) {
		return $http.post(ApiConstants.BaseUrl + 'item/create', item)
			.then(function (response) {
				if (response.status === 201) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.searchitem = function (searchterm) {
		return $http.get(ApiConstants.BaseUrl + 'item/search/' + searchterm)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	return service;
})

;

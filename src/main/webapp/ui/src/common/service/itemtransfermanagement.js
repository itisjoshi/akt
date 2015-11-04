angular.module('service.itemtransfermanagement', [
])

.factory('ItemTransferManagementService', function ($http, ApiConstants) {
	var service = {};

	service.getitemtransfer = function (id) {
		return $http.get(ApiConstants.BaseUrl + 'itemtransfer/'+ id)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.listitemtransfer = function () {
		return $http.get(ApiConstants.BaseUrl + 'itemtransfer/list')
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.listitemtransferbyitem = function (itemId) {
		return $http.get(ApiConstants.BaseUrl + 'itemtransfer/list/'+ itemId)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.searchitemtransfer = function (search) {
		return $http.get(ApiConstants.BaseUrl + 'itemtransfer/search/' + search)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.deleteitemtransfer = function (itemTransfer) {
		return $http.post(ApiConstants.BaseUrl + 'itemtransfer/delete', itemTransfer)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.deleteitemtransferDetails = function (itemTransferDetail) {
		return $http.post(ApiConstants.BaseUrl + 'itemtransfer/detail/delete', itemTransferDetail)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.edititemtransfer = function (itemTransfer) {
		return $http.post(ApiConstants.BaseUrl + 'itemtransfer/edit', itemTransfer)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.createitemtransfer = function (itemTransfer) {
		return $http.post(ApiConstants.BaseUrl + 'itemtransfer/create', itemTransfer)
			.then(function (response) {
				if (response.status === 201) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];
				}
			});
	};

	service.createitemtransferdetail = function (itemTransferDetail) {
		return $http.post(ApiConstants.BaseUrl + 'itemtransfer/detail/create', itemTransferDetail)
			.then(function (response) {
				if (response.status === 201) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];
				}
			});
	};

	return service;
})

;
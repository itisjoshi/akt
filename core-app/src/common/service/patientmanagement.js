angular.module('service.patientmanagement', [
])

.factory('PatientManagementService', function ($http, ApiConstants) {
	var service = {};

	service.listpatient = function () {
		return $http.get(ApiConstants.BaseUrl + 'patient/list')
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.deletepatient = function (patient) {
		return $http.post(ApiConstants.BaseUrl + 'patient/delete', patient)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.editpatient = function (patient) {
		return $http.post(ApiConstants.BaseUrl + 'patient/edit', patient)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.createpatient = function (patient) {
		return $http.post(ApiConstants.BaseUrl + 'patient/create', patient)
			.then(function (response) {
				if (response.status === 201) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.getpatient = function (id) {
		return $http.get(ApiConstants.BaseUrl + 'patient/get/' + id)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.searchpatient = function (searchterm) {
		return $http.get(ApiConstants.BaseUrl + 'patient/search/' + searchterm)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};


	service.listpatientimmunization = function (id) {
		return $http.get(ApiConstants.BaseUrl + 'patientimmunization/' + id)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.editpatientimmunization = function (patientImmunizationWebs) {
		return $http.post(ApiConstants.BaseUrl + 'patientimmunization/edit', patientImmunizationWebs)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.listpatientprofile = function (id) {
		return $http.get(ApiConstants.BaseUrl + 'patientprofile/' + id)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.editpatientprofile = function (patientProfileWebs) {
		return $http.post(ApiConstants.BaseUrl + 'patientprofile/edit', patientProfileWebs)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.listpatientvisit = function (id) {
		return $http.get(ApiConstants.BaseUrl + 'patientvisit/list/' +id)
			.then(function (response) {
				if (response.status === 200) {
					return response.data;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.deletepatientvisit = function (patientvisit) {
		return $http.post(ApiConstants.BaseUrl + 'patientvisit/delete', patientvisit)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.editpatientvisit = function (patientvisit) {
		return $http.post(ApiConstants.BaseUrl + 'patientvisit/edit', patientvisit)
			.then(function (response) {
				if (response.status === 200) {
					return true;
				} else if(response.status === 400) {
					return response.data[0];					
				}
			});
	};

	service.createpatientvisit = function (patientvisit) {
		return $http.post(ApiConstants.BaseUrl + 'patientvisit/create', patientvisit)
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

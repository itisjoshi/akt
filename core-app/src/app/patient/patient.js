angular.module('study.patient', [
	'service.patientmanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.patient', {
		url: '/patient',
		templateUrl: 'patient/patient.tpl.html',
		controller: 'PatientCtrl',
		data: {
			pageTitle: 'patient',
			roles: ['Admin']
		}
	});
})

.controller('PatientCtrl', function ($window, $scope, $state, $stateParams, $modal, PatientManagementService) {
	$window.console.log('In patientCtrl');

	$scope.updateMenu();

	PatientManagementService.listpatient()
		.then(function (patients) {
			$scope.patients = patients;
		});

	$scope.search = function () {
		if($scope.searchterm !== '') {
			PatientManagementService.searchpatient($scope.searchterm)
				.then(function (patients) {
					$scope.patients = patients;
				});			
		} else {
			PatientManagementService.listpatient()
				.then(function (patients) {
					$scope.patients = patients;
				});			
		}
	};

    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "-";
		}
		return new Date(oldDate).toLocaleDateString();
	};
	
	$scope.openModal = function (options) {
		var modalInstance = $modal.open(options);

		modalInstance.result.then(function () {
				$state.reload();
			}, function () {
				// Do nothing.
			});
	};

	$scope.addPatientModal = function () {
		var options = {
			animation: true,
			templateUrl: 'patient/patient.modal.tpl.html',
			controller: 'PatientAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.updatePatientModal = function (patient) {
		var options = {
			animation: true,
			templateUrl: 'patient/patient.modal.tpl.html',
			controller: 'PatientUpdateCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Update';
				},
				patient: function () {
					return patient;
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deletePatientModal = function (patient) {
		var options = {
			animation: true,
			templateUrl: 'patient/patientdelete.modal.tpl.html',
			controller: 'PatientDeleteCtrl',
			resolve: {
				patient: function () {
					return patient;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('PatientAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, operation) {
	$window.console.log('In PatientAddCtrl');
	
	$scope.patient = {};

	$scope.operation = operation;
	$scope.diasbledvalue = true;

	$scope.datepickerFormat = "d/M/yyyy";
	$scope.datepickerOptions = {
		formatYear: 'yyyy',
		startingDay: 1,
		initDate: new Date('01-01-2000')
	};
	$scope.openCal = function (event, date) {
		event.preventDefault();
		event.stopPropagation();

		if (date === 'startDate') {
			$scope.startDateOpened = true;
		}
	};
        

	$scope.save = function () {
		PatientManagementService.createpatient($scope.patient)
			.then(function (isAdded) {
				if (isAdded === true) {
					$modalInstance.close(true);
				} else {
					$scope.registerError = true;
					$scope.registerErrorMessage = isAdded.defaultMessage;
				}
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
	
})

.controller('PatientUpdateCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, operation, patient) {
	$window.console.log('In PatientUpdateCtrl');
	
	$scope.patient = patient;

	$scope.operation = operation;
	$scope.diasbledvalue = true;

	$scope.datepickerFormat = "d/M/yyyy";
	$scope.datepickerOptions = {
		formatYear: 'yyyy',
		startingDay: 1,
		initDate: new Date('01-01-2000')
	};
	$scope.openCal = function (event, date) {
		event.preventDefault();
		event.stopPropagation();

		if (date === 'startDate') {
			$scope.startDateOpened = true;
		}
	};
        

	$scope.save = function () {
		PatientManagementService.editpatient($scope.patient)
			.then(function (isAdded) {
				if (isAdded === true) {
					$modalInstance.close(true);
				} else {
					$scope.registerError = true;
					$scope.registerErrorMessage = isAdded.defaultMessage;
				}
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
	
})

.controller('PatientDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, patient) {
	$window.console.log('In formEditCtrl');
	
	$scope.patient = patient;
	$scope.delete = function () {
		PatientManagementService.deletepatient($scope.patient)
			.then(function (deleted) {
				if (deleted) {
					$modalInstance.close(true);
				} else {
				}
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
})

;
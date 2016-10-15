angular.module('study.patientvisit', [
	'service.patientmanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.patientvisit', {
		url: '/patientvisit/{patientid:int}',
		templateUrl: 'patientvisit/patientvisit.tpl.html',
		controller: 'PatientVisitCtrl',
		data: {
			pageTitle: 'PatientVisit',
			roles: ['Admin']
		}
	});
})

.controller('PatientVisitCtrl', function ($window, $scope, $state, $stateParams, $modal, PatientManagementService) {
	$window.console.log('In PatientVisitCtrl');

	$scope.updateMenu();
  	$scope.toggleCustom = function(patientvisit) {
            patientvisit.custom = patientvisit.custom === false ? true: false;
        };

	PatientManagementService.listpatientvisit($stateParams.patientid)
		.then(function (PatientVisits) {
			angular.forEach(PatientVisits, function(PatientVisits, key) {
				PatientVisits.custom = false;						
   			});
			$scope.patientVisits = PatientVisits;
		});
       
	PatientManagementService.getpatient($stateParams.patientid)
		.then(function (patient) {
			$scope.patient = patient;
		});

        
    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "";
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

	$scope.addPatientVisitModal = function () {
		var options = {
			animation: true,
			templateUrl: 'patientvisit/patientvisit.modal.tpl.html',
			controller: 'PatientVisitAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.updatePatientVisitModal = function (patientVisit) {
		var options = {
			animation: true,
			templateUrl: 'patientvisit/patientvisit.modal.tpl.html',
			controller: 'PatientVisitUpdateCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Update';
				},
				patientVisit: function () {
					return patientVisit;
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deletePatientVisitModal = function (patientVisit) {
		var options = {
			animation: true,
			templateUrl: 'patientvisit/patientvisitdelete.modal.tpl.html',
			controller: 'PatientVisitDeleteCtrl',
			resolve: {
				patientVisit: function () {
					return patientVisit;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('PatientVisitAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, operation) {
	$window.console.log('In PatientVisitAddCtrl');
	
	$scope.patientVisit = {};

	$scope.operation = operation;
	$scope.diasbledvalue = true;

	$scope.datepickerFormat = "d/M/yyyy";
	$scope.datepickerOptions = {
		formatYear: 'yyyy',
		startingDay: 1,
		initDate: new Date()
	};
	$scope.openCal = function (event, date) {
		event.preventDefault();
		event.stopPropagation();

		if (date === 'startDate') {
			$scope.startDateOpened = true;
		}
	};
	$scope.patientVisit.patientId = $stateParams.patientid;
	$scope.save = function () {
		PatientManagementService.createpatientvisit($scope.patientVisit)
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

.controller('PatientVisitUpdateCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, operation, patientVisit) {
	$window.console.log('In PatientVisitUpdateCtrl');
	
	$scope.patientVisit = patientVisit;

	$scope.operation = operation;
	$scope.diasbledvalue = true;

	$scope.datepickerFormat = "d/M/yyyy";
	$scope.datepickerOptions = {
		formatYear: 'yyyy',
		startingDay: 1,
		initDate: new Date()
	};
	$scope.openCal = function (event, date) {
		event.preventDefault();
		event.stopPropagation();

		if (date === 'startDate') {
			$scope.startDateOpened = true;
		}
	};

	$scope.save = function () {
		delete $scope.patientVisit.custom;
		PatientManagementService.editpatientvisit($scope.patientVisit)
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

.controller('PatientVisitDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, patientVisit) {
	$window.console.log('In formEditCtrl');
	
	$scope.PatientVisit = patientVisit;
	$scope.delete = function () {
		delete $scope.patientvisit.custom;
		PatientManagementService.deletepatientvisit($scope.PatientVisit)
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
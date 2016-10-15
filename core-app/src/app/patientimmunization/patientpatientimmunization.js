angular.module('study.patientimmunization', [
	'service.patientmanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.patientimmunization', {
		url: '/patientimmunization/{patientid:int}',
		templateUrl: 'patientimmunization/patientimmunization.tpl.html',
		controller: 'patientimmunizationCtrl',
		data: {
			pageTitle: 'patientimmunization',
			roles: ['Admin']
		}
	});
})

.controller('patientimmunizationCtrl', function ($window, $scope, $state, $stateParams, $modal, PatientManagementService) {
	$window.console.log('In patientimmunizationCtrl');

	$scope.updateMenu();

	PatientManagementService.listpatientimmunization($stateParams.patientid)
		.then(function (patientimmunizations) {
			$scope.patientimmunizations = patientimmunizations;
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

	$scope.addPatientImmunizationModal = function (patientimmunization) {
		var options = {
			animation: true,
			templateUrl: 'patientimmunization/patientimmunization.modal.tpl.html',
			controller: 'PatientImmunizationAddCtrl',
			size: 'lg',
			resolve: {
				patientimmunization: function () {
					return patientimmunization;
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deletePatientImmunizationModal = function (patientimmunization) {
		var options = {
			animation: true,
			templateUrl: 'patientimmunization/patientimmunizationdelete.modal.tpl.html',
			controller: 'PatientImmunizationDeleteCtrl',
			resolve: {
				patientimmunization: function () {
					return patientimmunization;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('PatientImmunizationAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, patientimmunization) {
	$window.console.log('In PatientImmunizationAddCtrl');
	
	$scope.patientimmunization = patientimmunization;

	$scope.operation = "Update";
	$scope.diasbledvalue = true;

	$scope.datepickerFormat = "d/M/yyyy";
	$scope.datepickerOptions = {
		formatYear: 'yyyy',
		startingDay: 1
	};
	$scope.openCal = function (event, date) {
		event.preventDefault();
		event.stopPropagation();

		if (date === 'dateGiven') {
			$scope.dateGivenOpened = true;
		}
		else if (date === 'dateToBeGiven') {
			$scope.dateToBeGivenOpened = true;
		}
	};

	$scope.save = function () {
		var profile = [];
		profile.push($scope.patientimmunization);
		PatientManagementService.editpatientimmunization(profile)
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

;
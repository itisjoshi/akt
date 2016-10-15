angular.module('study.patientprofile', [
	'service.patientmanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.patientprofile', {
		url: '/patientprofile/{patientid:int}',
		templateUrl: 'patientprofile/patientprofile.tpl.html',
		controller: 'PatientProfileCtrl',
		data: {
			pageTitle: 'patientprofile',
			roles: ['Admin']
		}
	});
})

.controller('PatientProfileCtrl', function ($window, $scope, $state, $stateParams, $modal, PatientManagementService) {
	$window.console.log('In PatientProfileCtrl');

	$scope.updateMenu();

	PatientManagementService.listpatientprofile($stateParams.patientid)
		.then(function (patientprofiles) {
			$scope.patientprofiles = patientprofiles;
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

	$scope.addPatientProfileModal = function (patientprofile) {
		var options = {
			animation: true,
			templateUrl: 'patientprofile/patientprofile.modal.tpl.html',
			controller: 'PatientProfileAddCtrl',
			size: 'lg',
			resolve: {
				patientprofile: function () {
					return patientprofile;
				}
			}
		};
		$scope.openModal(options);
	};
})

.controller('PatientProfileAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, patientprofile) {
	$window.console.log('In PatientProfileAddCtrl');
	
	$scope.patientprofile = patientprofile;

	$scope.operation = "UPDATE";
	$scope.diasbledvalue = true;

	$scope.save = function () {
		var profile = [];
		profile.push($scope.patientprofile);
		PatientManagementService.editpatientprofile(profile)
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

.controller('PatientProfileDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, PatientManagementService, patientprofile) {
	$window.console.log('In formEditCtrl');
	
	$scope.patientprofile = patientprofile;
	$scope.delete = function () {
		PatientManagementService.deletepatientprofile($scope.patientprofile)
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
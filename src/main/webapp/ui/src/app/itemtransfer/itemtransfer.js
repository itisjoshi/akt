angular.module('study.itemtransfer', [
	'service.itemtransfermanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.itemtransfer', {
		url: '/itemtransfer',
		templateUrl: 'itemtransfer/itemtransfer.tpl.html',
		controller: 'ItemTransferCtrl',
		data: {
			pageTitle: 'ItemTransfer',
			roles: ['Admin']
		}
	});
})

.controller('ItemTransferCtrl', function ($window, $scope, $state, $stateParams, $modal, ItemTransferManagementService) {
	$window.console.log('In ItemTransferCtrl');

	$scope.updateMenu();

	ItemTransferManagementService.listitemtransfer()
		.then(function (itemTransfers) {
			$scope.itemTransfers = itemTransfers;
		});

	$scope.search = function () {
		if($scope.searchterm !== '') {
			ItemTransferManagementService.searchitemtransfer($scope.searchterm)
				.then(function (itemTransfers) {
					$scope.itemTransfers = itemTransfers;
				});			
		}
	};

        
    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "Not started";
		}
		return new Date(oldDate).toLocaleString();
	};
	
	$scope.openModal = function (options) {
		var modalInstance = $modal.open(options);

		modalInstance.result.then(function () {
				$state.reload();
			}, function () {
				// Do nothing.
			});
	};

	$scope.addTransferModal = function () {
		var options = {
			animation: true,
			templateUrl: 'itemtransfer/itemtransfer.modal.tpl.html',
			controller: 'TransferAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deleteTransferModal = function (itemtransfer) {
		var options = {
			animation: true,
			templateUrl: 'itemtransfer/itemtransferdelete.modal.tpl.html',
			controller: 'TransferDeleteCtrl',
			resolve: {
				itemtransfer: function () {
					return itemtransfer;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('TransferAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemTransferManagementService, operation, ItemManagementService) {
	$window.console.log('In TransferAddCtrl');
	
	$scope.itemtransfer = {};

	$scope.operation = operation;
	$scope.diasbledvalue = true;

	$scope.save = function () {
		$scope.itemTransfer.itemTranferDetailsStatus = "RECEIVE";
		ItemTransferManagementService.createitemtransfer($scope.itemTransfer)
			.then(function (isAdded) {
				if (isAdded === true) {
					$modalInstance.close(true);
				} else {
					$scope.registerError = true;
					$scope.registerErrorMessage = isAdded.defaultMessage;
				}
			});
	};

	ItemManagementService.listitem()
		.then(function (items) {
			$scope.items = items;
		});

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
	
})

.controller('TransferDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemTransferManagementService, itemtransfer) {
	$window.console.log('In formEditCtrl');
	
	$scope.itemtransfer = itemtransfer;
	$scope.delete = function () {
		ItemTransferManagementService.deleteitemtransfer($scope.itemtransfer)
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
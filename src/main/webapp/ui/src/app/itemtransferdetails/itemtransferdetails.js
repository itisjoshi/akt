angular.module('study.itemtransferdetails', [
	'service.itemtransfermanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.itemtransferdetails', {
		url: '/itemtransfer/{itemtransferId:int}',
		templateUrl: 'itemtransferdetails/itemtransferdetails.tpl.html',
		controller: 'ItemTransferDetailCtrl',
		data: {
			pageTitle: 'ItemTransferDetail',
			roles: ['Admin']
		}
	});
})

.controller('ItemTransferDetailCtrl', function ($window, $scope, $state, $stateParams, $modal, ItemTransferManagementService) {
	$window.console.log('In ItemTransferDetailCtrl');

	$scope.updateMenu();

        
    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "Not started";
		}
		return new Date(oldDate).toLocaleString();
	};

	ItemTransferManagementService.getitemtransfer($stateParams.itemtransferId)
		.then(function (itemTransfer) {
			$scope.itemTransfers = itemTransfer;
		});

	$scope.openModal = function (options) {
		var modalInstance = $modal.open(options);

		modalInstance.result.then(function () {
				$state.reload();
			}, function () {
				// Do nothing.
			});
	};

	$scope.addTransferDetailsModal = function () {
		var options = {
			animation: true,
			templateUrl: 'itemtransferdetails/itemtransferdetails.modal.tpl.html',
			controller: 'TransferDetailAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.addTransferReturnDetailsModal = function (transfer) {
		var options = {
			animation: true,
			templateUrl: 'itemtransferdetails/itemreturn.modal.tpl.html',
			controller: 'TransferReturnAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				},
				transferObject: function () {
					return transfer;
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deleteTransferDetailModal = function (itemtransfer) {
		var options = {
			animation: true,
			templateUrl: 'itemtransferdetails/itemtransferdelete.modal.tpl.html',
			controller: 'ItemTransferDetailDeleteCtrl',
			resolve: {
				itemtransfer: function () {
					return itemtransfer;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('TransferReturnAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemTransferManagementService, operation, ItemManagementService, transferObject) {
	$window.console.log('In TransferReturnAddCtrl');
	
	$scope.itemtransferDetail = {};

	$scope.operation = operation;
	$scope.diasbledvalue = true;
	$scope.itemtransferDetail.itemTranferDetailsStatus = "RETURN";
	$scope.itemtransferDetail.name = transferObject.name;
	$scope.itemtransferDetail.recipient = transferObject.recipient;
	
	
	ItemTransferManagementService.getitemtransfer($stateParams.itemtransferId)
		.then(function (itemTransfer) {
			$scope.itemtransferDetail.itemTransfer = itemTransfer;
		});

	$scope.save = function () {
		recipient = transferObject.recipient;
		if($scope.itemtransferDetail.quantity > transferObject.quantity) {
			$scope.registerError = true;
		} else {
			ItemTransferManagementService.createitemtransferdetail($scope.itemtransferDetail)
				.then(function (isAdded) {
					if (isAdded === true) {
						$modalInstance.close(true);
					} else {
						$scope.registerError = true;
						$scope.registerErrorMessage = isAdded.defaultMessage;
					}
				});			
		}
	};


	ItemManagementService.listitem()
		.then(function (items) {
			$scope.items = items;
		});

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
	
})


.controller('TransferDetailAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemTransferManagementService, operation, ItemManagementService) {
	$window.console.log('In TransferDetailAddCtrl');
	
	$scope.itemtransferDetail = {};

	$scope.operation = operation;
	$scope.diasbledvalue = true;
	$scope.itemtransferDetail.itemTranferDetailsStatus = "ISSUE";

	ItemTransferManagementService.getitemtransfer($stateParams.itemtransferId)
		.then(function (itemTransfer) {
			$scope.itemtransferDetail.itemTransfer = itemTransfer;
		});

	$scope.save = function () {
		ItemTransferManagementService.createitemtransferdetail($scope.itemtransferDetail)
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

.controller('ItemTransferDetailDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemTransferManagementService, itemtransfer) {
	$window.console.log('In ItemTransferDetailDeleteCtrl');
	
	$scope.itemtransfer = itemtransfer;
	$scope.delete = function () {
		ItemTransferManagementService.deleteitemtransferDetails($scope.itemtransfer)
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
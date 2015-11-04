angular.module('study.item', [
	'service.itemmanagement',
	'directives.hovereditdelete',
	'ui.router'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.item', {
		url: '/item',
		templateUrl: 'invent/item/item.tpl.html',
		controller: 'ItemCtrl',
		data: {
			pageTitle: 'Item',
			roles: ['Admin']
		}
	});
})

.controller('ItemCtrl', function ($window, $scope, $state, $stateParams, $modal, ItemManagementService) {
	$window.console.log('In ItemCtrl');
	
	$scope.updateMenu();
	
	ItemManagementService.listitem()
		.then(function (items) {
			$scope.items = items;
		});

	$scope.search = function () {
		if($scope.searchterm !== '') {
			ItemManagementService.searchitem($scope.searchterm)
				.then(function (items) {
					$scope.items = items;
			});			
		}
	};

	$scope.openModal = function (options) {
		var modalInstance = $modal.open(options);

		modalInstance.result.then(function () {
				$state.reload();
			}, function () {
				// Do nothing.
			});
	};

	$scope.addItemModal = function () {
		var options = {
			animation: true,
			templateUrl: 'invent/item/item.modal.tpl.html',
			controller: 'ItemAddCtrl',
			size: 'lg',
			resolve: {
				operation: function () {
					return 'Create';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.updateItemModal = function (item) {
		var options = {
			animation: true,
			templateUrl: 'invent/item/item.modal.tpl.html',
			controller: 'ItemEditCtrl',
			size: 'lg',
			resolve: {
				item: function () {
					return item;
				},
				operation: function () {
					return 'Update';
				}
			}
		};
		$scope.openModal(options);
	};

	$scope.deleteItemModal = function (item) {
		var options = {
			animation: true,
			templateUrl: 'invent/item/itemdelete.modal.tpl.html',
			controller: 'ItemDeleteCtrl',
			resolve: {
				item: function () {
					return item;
				}
			}
		};
		$scope.openModal(options);
	};

})

.controller('ItemAddCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemManagementService, operation) {
	$window.console.log('In ItemAddCtrl');
	
	$scope.item = {};

	$scope.operation = operation;
	$scope.save = function () {
		ItemManagementService.createitem($scope.item)
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

.controller('ItemEditCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemManagementService, item, operation) {
	$window.console.log('In itemEditCtrl');

	$scope.operation = operation;	
	$scope.item = item;
	$scope.save = function () {
		ItemManagementService.edititem($scope.item)
			.then(function (isAdded) {
				if (isAdded) {
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

.controller('ItemDeleteCtrl', function ($window, $scope, $state, $stateParams, $modalInstance, ItemManagementService, item) {
	$window.console.log('In formEditCtrl');
	
	$scope.item = item;
	$scope.delete = function () {
		ItemManagementService.deleteitem($scope.item)
			.then(function (deleted) {
				if (deleted) {
					$modalInstance.close(true);
				} else {
					$scope.registerError = true;
					$scope.registerErrorMessage = deleted.defaultMessage;
				}
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('Cancelled');
	};
})
;

angular.module('study.itemfull', [
	'service.itemtransfermanagement',
	'ui.router',
	'ui.bootstrap'
])

.config(function ($stateProvider) {
	$stateProvider.state('study.itemfull', {
		url: '/invent/{itemId:int}/fullreport',
		templateUrl: 'invent/itemfull/itemfull.tpl.html',
		controller: 'ItemFullCtrl',
		data: {
			pageTitle: 'Full Report',
			roles: ['Admin']
		}
	});
})

.controller('ItemFullCtrl', function ($window, $scope, $state, $stateParams, $modal, ItemTransferManagementService) {
	$window.console.log('In ItemFullCtrl');

	$scope.updateMenu();

	$scope.itemId = $stateParams.itemId;

        
    $scope.parseDate = function (oldDate) {
		if(oldDate === null) {
			return "Not started";
		}
		return new Date(oldDate).toLocaleString();
	};
	
	ItemTransferManagementService.listitemtransferbyitem($scope.itemId)
		.then(function (itemTransfers) {
			angular.forEach(itemTransfers, function(itemTransfer, key) {
				itemTransfer.custom = false;						
   			});
			$scope.itemTransfers = itemTransfers;
		});

  	$scope.toggleCustom = function(itemTransfer) {
        itemTransfer.custom = itemTransfer.custom === false ? true: false;
    };

})

;

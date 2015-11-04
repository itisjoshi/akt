angular.module('directives.multiselect', [
])

.directive('trMultiselect', ['$window', function ($window) {
	return {
		restrict: 'A',
		scope: {
			btnText: '@btnText',
			btnWidth: '@btnWidth',
			dataProvider: '=dataProvider',
			dataSelected: '=dataSelected',
			onDataChange: '&onDataChange'
		},
		link: function (scope, element, attrs, controllers) {
			var optns = {
				onChange: function (option, checked, select) {
					scope.dataSelected.splice(0, scope.dataSelected.length);
					scope.$apply(function () {
						angular.forEach(scope.dataProvider, function (item) {
							if (item.value === angular.element(option).val()) {
								if (checked) {
									item.selected = true;
								} else {
									item.selected = false;
								}
							}
							if (item.selected) {
								scope.dataSelected.push(item.value);
							}
						});
					});
					if (attrs.onDataChange !== null && attrs.onDataChange !== "") {
						scope.onDataChange();
					}
				}
			};

			if (scope.btnWidth !== undefined) {
				optns.buttonWidth = scope.btnWidth;
			}
			if (scope.btnText !== undefined) {
				optns.buttonText = function (options, select) {
					if (options.length === 0) {
						return scope.btnText;
					} else if (options.length > 3) {
						return options.length + ' selected';
					} else {
						var labels = [];
						angular.forEach(options, function (option) {
							if (angular.element(option).attr('label') !== undefined) {
								labels.push(angular.element(option).attr('label'));
							} else {
								labels.push(angular.element(option).html());
							}
						});
						return labels.join(', ') + '';
					}
				};
			}
			element.multiselect(optns);

			scope.$watch('dataProvider', function () {
				if (scope.dataProvider !== undefined && scope.dataProvider.length !== 0) {
					element.multiselect('dataprovider', scope.dataProvider);
				}
			});
		}
	};
}])

;
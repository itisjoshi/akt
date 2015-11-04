angular.module('directives.slider', [
])

.directive('trSlider', ['$window', function ($window) {
	return {
		restrict: 'A',
		scope: {
			sliderValue: '=trSliderValue',
			onChange: '&onChange',
			onSlideStop: '&onSlideStop',
			range: '@range',
			enabled: '=enabled'
		},
		link: function (scope, element, attrs, controllers) {
			var optns = {
				tooltip: 'hide'
			};

			if (scope.range !== null && scope.range === 'true') {
				optns.range = 'true';
			}

			var slider = angular.element(element).slider(optns);
			slider.data('slider').setValue(scope.sliderValue);

			slider.on('change', function (object) {
				scope.$apply(function () {
					scope.sliderValue = object.value.newValue;
				});
				if (attrs.onChange !== null) {
					scope.onChange();
				}
			});
			slider.on('slideStop', function (object) {
				if (attrs.onSlideStop !== null) {
					scope.onSlideStop();
				}
			});

			scope.$watch('sliderValue', function () {
				if (scope.sliderValue === null) { return; }
				if (scope.sliderValue instanceof Array) {
					slider.data('slider').setValue(scope.sliderValue);
				} else {
					slider.data('slider').setValue(scope.sliderValue);
				}
			});
			scope.$watch('enabled', function () {
				if (scope.enabled) {
					slider.data('slider').enable();
				} else {
					slider.data('slider').disable();
				}
			});
		}
	};
}])

;
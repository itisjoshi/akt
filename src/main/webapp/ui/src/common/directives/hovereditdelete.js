angular.module('directives.hovereditdelete', [
])

.directive('trHoverEditDelete', ['$window', function ($window) {
	return {
		restrict: 'A',
		scope: {
			editMethod: '&',
			deleteMethod: '&'
		},
		link: function (scope, element, attrs, controllers) {
			element.hover(function () {
				var editIcon, deleteIcon;
				if (attrs.editMethod !== undefined) {
					editIcon = angular.element("<span class='trhed fa fa-pencil'></span>").click(function (event) {
						event.preventDefault();
						scope.editMethod();
					});
					element.append(editIcon);
				}
				if (attrs.deleteMethod !== undefined) {
					deleteIcon = angular.element("<span class='trhed fa fa-trash-o'></span>").click(function (event) {
						event.preventDefault();
						scope.deleteMethod();
					});
					element.append(deleteIcon);
				}
			}, function () {
				element.find('.trhed').remove();
			});
		}
	};
}])

;

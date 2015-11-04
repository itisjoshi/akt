angular.module('templates-app', ['app.tpl.html', 'footer.tpl.html', 'header.tpl.html', 'home/home.tpl.html', 'invent/item/item.modal.tpl.html', 'invent/item/item.tpl.html', 'invent/item/itemdelete.modal.tpl.html', 'invent/itemfull/itemfull.tpl.html', 'itemtransfer/itemtransfer.modal.tpl.html', 'itemtransfer/itemtransfer.tpl.html', 'itemtransfer/itemtransferdelete.modal.tpl.html', 'itemtransferdetails/itemreturn.modal.tpl.html', 'itemtransferdetails/itemtransferdelete.modal.tpl.html', 'itemtransferdetails/itemtransferdetails.modal.tpl.html', 'itemtransferdetails/itemtransferdetails.tpl.html', 'login/login.tpl.html', 'logout/logout.tpl.html']);

angular.module("app.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("app.tpl.html",
    "<header data-ng-include=\"'header.tpl.html'\" data-ng-controller=\"HeaderCtrl\"></header>\n" +
    "<section class=\"container-fluid headerNextSection footerPrevSection\" data-ui-view=\"\"></section>\n" +
    "<footer class=\"container-fluid loggedInFooter\" data-ng-include=\"'footer.tpl.html'\" data-ng-controller=\"FooterCtrl\"></footer>\n" +
    "<div class=\"loadingIndicator\" data-ng-show=\"isLoading()\">\n" +
    "	<span class=\"fa fa-spinner fa-spin\"></span>\n" +
    "</div>\n" +
    "");
}]);

angular.module("footer.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("footer.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"col-xs-6 col-sm-4 footerIcons\">\n" +
    "		<a target=\"_blank\" href=\"http://www.ctrlthreads.co.in\"><img src=\"assets/images/favicon.ico\" height=\"40\" width=\"50\"></a>\n" +
    "		<a target=\"_blank\" href=\"https://www.facebook.com/joshifriends\"><span class=\"fa fa-facebook\"></span></a>\n" +
    "		<a target=\"_blank\" href=\"https://www.twitter.com/Im__Joshi\"><span class=\"fa fa-twitter\"></span></a>\n" +
    "		<a target=\"_blank\" href=\"https://www.linkedin.com/in/pmjoshi\"><span class=\"fa fa-linkedin\"></span></a>\n" +
    "			<span class=\"fa fa-envelope-o\"> Write to support@ctrlthreads.co.in for any help.</span>\n" +
    "	</div>	\n" +
    "	<div class=\"hidden-xs col-sm-4\"></div>\n" +
    "	<div class=\"col-xs-6 col-sm-4 text-right\">\n" +
    "		<i><span>Copyright &copy; 2015 CTRL THREADS.</span></i>\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("header.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("header.tpl.html",
    "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
    "	<div class=\"container-fluid\">\n" +
    "		<div class=\"navbar-header\">\n" +
    "			<button class=\"navbar-toggle collapsed\" aria-controls=\"navbar\" aria-expanded=\"false\" data-target=\"#navbar\" data-toggle=\"collapse\" type=\"button\">\n" +
    "				<span class=\"sr-only\">Toggle navigation</span>\n" +
    "				<span class=\"icon-bar\"></span>\n" +
    "				<span class=\"icon-bar\"></span>\n" +
    "				<span class=\"icon-bar\"></span>\n" +
    "			</button>\n" +
    "			<a class=\"navbar-brand\" data-ng-click=\"goHome()\">\n" +
    "				<img src=\"assets/images/favicon.jpeg\" alt=\"Inventry From Ctrl Threads\" height=\"45\" />\n" +
    "			</a>\n" +
    "		</div>\n" +
    "		<div class=\"navbar-collapse collapse\" id=\"navbar\">\n" +
    "			<ul class=\"nav navbar-nav navbar-right\">\n" +
    "				<li data-ng-repeat=\"menu in menuItems\">\n" +
    "					<a data-ui-sref=\"{{menu.state}}\" data-ui-sref-opts=\"{reload: true}\">{{menu.name}}</a>\n" +
    "				</li>\n" +
    "			</ul>\n" +
    "		</div>\n" +
    "	</div>\n" +
    "</nav>\n" +
    "");
}]);

angular.module("home/home.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("home/home.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container-fluid classContainer\">\n" +
    "		<div class=\"row\">\n" +
    "			<h3 class=\"col-sm-9 col-md-10\">Balance of Items</h3>\n" +
    "		</div>\n" +
    "		<hr />\n" +
    "		<table class=\"table table-striped\">\n" +
    "			<thead>\n" +
    "				<tr>\n" +
    "					<th>Name</th>\n" +
    "					<th>Short Code</th>\n" +
    "					<th>Balance</th>\n" +
    "					<th>Last Checked</th>\n" +
    "				</tr>\n" +
    "			</thead>\n" +
    "			<tbody>\n" +
    "				<tr data-ng-repeat=\"item in items\">\n" +
    "					<td>\n" +
    "						<span>{{item.name}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "						<span>{{item.shortCode}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "						<span>{{item.balance || 0}} {{item.measureType}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "						{{parseDate(item.lastmodified)}}\n" +
    "					</td>\n" +
    "				</tr>\n" +
    "			</tbody>\n" +
    "		</table>\n" +
    "	</div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("invent/item/item.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("invent/item/item.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">{{operation}} Item</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<form name=\"classForm\">\n" +
    "		<div class=\"alert alert-danger\" role=\"alert\" data-ng-show=\"registerError\">\n" +
    "		  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>\n" +
    "		  <span class=\"sr-only\">Error:</span>\n" +
    "		  		{{registerErrorMessage || 'Enter all fields'}}\n" +
    "		</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<div class=\"form-group\">\n" +
    "						<label class=\"control-label\" for=\"facultyDescription\">Name*</label>\n" +
    "						<div class=\"input-group\">\n" +
    "					  		<span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  		<input type=\"text\" class=\"form-control\" placeholder=\"Name of Item \" data-ng-model=\"item.name\" aria-describedby=\"	basic-addon1\">\n" +
    "						</div>\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"formName\">ShortCode*</label>\n" +
    "					<input type=\"text\" name=\"formName\" data-ng-model=\"item.shortCode\" placeholder=\"Short Code\"\n" +
    "							class=\"form-control\" aria-describedby=\"Form Name\">\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"formName\">How to Measure*</label>\n" +
    "					<input type=\"text\" name=\"formName\" data-ng-model=\"item.measureType\" placeholder=\"Litres, Packets, Bags, Kg etc..\"\n" +
    "							class=\"form-control\" aria-describedby=\"Form Name\">\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</form>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-success\" data-ng-click=\"save()\">Save</button>\n" +
    "	<button class=\"btn btn-warning\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("invent/item/item.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("invent/item/item.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container-fluid formContainer\">\n" +
    "		<div class=\"row\">\n" +
    "			<h3 class=\"col-md-8 col-sm-8\">Items</h3>\n" +
    "			<div style=\"margin: 12px 0px 10px 0px;\" class=\"col-md-4 col-sm-4\">\n" +
    "				<div class=\"form-group has-feedback\" style=\"margin: 0px;\">\n" +
    "					<input type=\"text\" class=\"form-control\" data-ng-model=\"searchterm\" data-ng-change=\"search()\" placeholder=\"Search\" />\n" +
    "					<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\"></span>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "		<hr />\n" +
    "		<div style=\"margin-bottom: 5px;\">\n" +
    "			<button type=\"button\"\n" +
    "					class=\"btn btn-primary btn-sm\"\n" +
    "					data-ng-click=\"addItemModal()\">\n" +
    "				<span class=\"fa fa-user-plus\"></span> Create Item\n" +
    "			</button>\n" +
    "		</div>\n" +
    "		<div class=\"classgroupBlock\">\n" +
    "			<div class=\"row\">\n" +
    "				<div class=\"col-sm-6 col-md-4\" data-ng-repeat=\"item in items\">\n" +
    "					<div class=\"operRegion resource\" data-tr-hover-edit-delete\n" +
    "						data-edit-method=\"updateItemModal(item)\" data-delete-method=\"deleteItemModal(item)\">\n" +
    "						<a><h5 data-ui-sref=\"study.itemfull({itemId: item.id})\">{{$index + 1}}. {{item.name || 'Name'}}<span class=\"badge pull-right\">{{item.balance || 0}} {{item.measureType}}</span></h5></a>\n" +
    "						<div><span>Short Code: <i>{{item.shortCode || 'Short Code for Item'}}</i></span></div>\n" +
    "						<div><span>Measured in: <i>{{item.measureType || 'Measured In'}}</i></span></div>\n" +
    "						<div><span>Created By: <i>{{item.createdBy || 'Creator for Item'}}</i></span></div>\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("invent/item/itemdelete.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("invent/item/itemdelete.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Delete Item</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<div class=\"row\">\n" +
    "		<div class=\"col-sm-12 col-md-12\">\n" +
    "			Deleting Item will also delete its associated contents. Are you sure want to delete this item?\n" +
    "		</div>\n" +
    "	</div>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-danger\" data-ng-click=\"delete()\">Delete</button>\n" +
    "	<button class=\"btn btn-info\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("invent/itemfull/itemfull.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("invent/itemfull/itemfull.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container-fluid formContainer\">\n" +
    "		<div class=\"row\">\n" +
    "			<h3 class=\"col-md-8 col-sm-8\">Item History</h3>\n" +
    "		</div>\n" +
    "		<hr />\n" +
    "		<div style=\"margin-bottom: 5px;\">\n" +
    "			<a class=\"pull-right\" data-ui-sref=\"study.item\"><span class=\"fa fa-long-arrow-left\"></span> Back to items</a>\n" +
    "		</div>\n" +
    "		<table class=\"table table-striped\">\n" +
    "			<thead>\n" +
    "				<tr>\n" +
    "					<th>Name</th>\n" +
    "					<th>From</th>\n" +
    "					<th>Item Name</th>\n" +
    "				</tr>\n" +
    "			</thead>\n" +
    "			<tbody>\n" +
    "				<tr data-ng-repeat=\"itemTransfer in itemTransfers\">\n" +
    "					<td>\n" +
    "						<div class=\"panel panel-default\">\n" +
    "							<div class=\"panel-heading\">\n" +
    "						    	<a><span data-ng-click=\"toggleCustom(itemTransfer)\" class=\"fa fa-cogs\" class=\"panel-title\"> {{$index + 1}}.</span>\n" +
    "						    	<span data-ng-click=\"toggleCustom(itemTransfer)\">{{itemTransfer.name}}</span></a>\n" +
    "						    	<span class=\"pull-right\" data-ng-click=\"toggleCustom(itemTransfer)\">{{parseDate(itemTransfer.created)}}</span>						  	\n" +
    "						 	</div>\n" +
    "							 <div id=\"collapseOne\" data-ng-show=\"itemTransfer.custom\" class=\"panel-collapse collapse in\">\n" +
    "								<div class=\"panel-body\">\n" +
    "									<table class=\"table table-striped\">\n" +
    "										<thead>\n" +
    "											<tr>\n" +
    "												<th>Status</th>\n" +
    "												<th>Quantity</th>\n" +
    "												<th>Date</th>\n" +
    "											</tr>\n" +
    "										</thead>\n" +
    "										<tbody>\n" +
    "											<tr data-ng-repeat=\"itemTransferDetail in itemTransfer.itemTransferDetails\">\n" +
    "												<td>\n" +
    "													{{itemTransferDetail.itemTranferDetailsStatus}}\n" +
    "												</td>\n" +
    "												<td>\n" +
    "													{{itemTransferDetail.quantity}} {{itemTransfer.item.measureType}}.\n" +
    "												</td>\n" +
    "												<td>\n" +
    "													{{parseDate(itemTransferDetail.created)}}\n" +
    "												</td>\n" +
    "											</tr>\n" +
    "										</tbody>\n" +
    "									</table>\n" +
    "								</div>\n" +
    "							</div>\n" +
    "						</div>\n" +
    "						<td>\n" +
    "							<span>{{itemTransfer.buyer}}</span>\n" +
    "						</td>\n" +
    "						<td>\n" +
    "						   	<span>{{itemTransfer.item.name}}</span>\n" +
    "						</td>    	\n" +
    "					</td>\n" +
    "				</tr>\n" +
    "			</tbody>\n" +
    "		</table>			\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("itemtransfer/itemtransfer.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransfer/itemtransfer.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Issue Item</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<form name=\"classForm\">\n" +
    "	<div class=\"alert alert-danger\" role=\"alert\" data-ng-show=\"registerError\">\n" +
    "			  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>\n" +
    "			  <span class=\"sr-only\">Error:</span>\n" +
    "			  		{{registerErrorMessage || 'Enter all fields'}}\n" +
    "			</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"item\">Item</label>\n" +
    "						<select name=\"item\" class=\"form-control\" data-ng-model=\"itemTransfer.item\" data-ng-options=\"item.name for item in items track by item.id\">\n" +
    "					</select>\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Name</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"Name for this arrival\" data-ng-model=\"itemTransfer.name\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Sender</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"Example: Pallava Mills\" data-ng-model=\"itemTransfer.buyer\" aria-describedby=\"basic-addon2\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon2\">Company</span>\n" +
    "					</div>				\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Quantity in {{itemTransfer.item.measureType}}</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"How much {{itemTransfer.item.measureType}} came?\" data-ng-model=\"itemTransfer.quantity\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</form>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-success\" data-ng-click=\"save()\">Save</button>\n" +
    "	<button class=\"btn btn-warning\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("itemtransfer/itemtransfer.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransfer/itemtransfer.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container-fluid formContainer\">\n" +
    "		<div class=\"row\">\n" +
    "			<h3 class=\"col-md-8 col-sm-8\">Item History</h3>\n" +
    "			<div style=\"margin: 12px 0px 10px 0px;\" class=\"col-md-4 col-sm-4\">\n" +
    "				<div class=\"form-group has-feedback\" style=\"margin: 0px;\">\n" +
    "					<input type=\"text\" class=\"form-control\" data-ng-model=\"searchterm\" data-ng-change=\"search()\" placeholder=\"Search\" />\n" +
    "					<span class=\"glyphicon glyphicon-search form-control-feedback\" aria-hidden=\"true\"></span>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "		<hr />\n" +
    "		<div style=\"margin-bottom: 5px;\">\n" +
    "			<button type=\"button\"\n" +
    "					class=\"btn btn-primary btn-sm\"\n" +
    "					data-ng-click=\"addTransferModal()\">\n" +
    "				<span class=\"fa fa-user-plus\"></span> Create Load Receive\n" +
    "			</button>\n" +
    "		</div>\n" +
    "		<table class=\"table table-striped\">\n" +
    "			<thead>\n" +
    "				<tr>\n" +
    "					<th>Name</th>\n" +
    "					<th>From</th>\n" +
    "					<th>Item Name</th>\n" +
    "					<th>Received On</th>\n" +
    "					<th></th>\n" +
    "				</tr>\n" +
    "			</thead>\n" +
    "			<tbody>\n" +
    "				<tr data-ng-repeat=\"itemTransfer in itemTransfers\">\n" +
    "					<td>\n" +
    "					   	<a data-ui-sref=\"study.itemtransferdetails({itemtransferId: itemTransfer.id})\"><span class=\"fa fa-cogs\"> {{$index + 1}}.</span>\n" +
    "					   	<span>{{itemTransfer.name}}</span></a>\n" +
    "					<td>\n" +
    "					   	<span>{{itemTransfer.buyer}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "					   	<span>{{itemTransfer.item.name}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "					   	<span>{{parseDate(itemTransfer.created)}}</span>						  	\n" +
    "					\n" +
    "					</td>\n" +
    "					<td class=\"deleteWidth text-right\">\n" +
    "						<a data-ng-click=\"deleteTransferModal(itemTransfer)\"><span class=\"fa fa-trash-o\"></span></a>\n" +
    "					</td>\n" +
    "				</tr>\n" +
    "			</tbody>\n" +
    "		</table>			\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("itemtransfer/itemtransferdelete.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransfer/itemtransferdelete.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Delete Exam</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<div class=\"row\">\n" +
    "		<div class=\"col-sm-12 col-md-12\">\n" +
    "			Deleting Exam will also delete its associated contents. Are you sure want to delete this exam?\n" +
    "		</div>\n" +
    "	</div>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-danger\" data-ng-click=\"delete()\">Delete</button>\n" +
    "	<button class=\"btn btn-info\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("itemtransferdetails/itemreturn.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransferdetails/itemreturn.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Return Item</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<form name=\"classForm\" novalidate data-ng-submit=\"save()\">\n" +
    "	<div class=\"alert alert-danger\" role=\"alert\" data-ng-show=\"registerError\">\n" +
    "			  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>\n" +
    "			  <span class=\"sr-only\">Error:</span>\n" +
    "			  		{{registerErrorMessage || 'Check Quantity Value'}}\n" +
    "			</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Name</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"Name the transfer\" data-ng-model=\"itemtransferDetail.name\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Receiver</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"To\" data-ng-model=\"itemtransferDetail.recipient\" aria-describedby=\"basic-addon2\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon2\">College</span>\n" +
    "					</div>				\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Quantity</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"How much?\" data-ng-model=\"itemtransferDetail.quantity\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</form>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-success\" data-ng-click=\"save()\">Save</button>\n" +
    "	<button class=\"btn btn-warning\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("itemtransferdetails/itemtransferdelete.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransferdetails/itemtransferdelete.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Delete</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<div class=\"row\">\n" +
    "		<div class=\"col-sm-12 col-md-12\">\n" +
    "			Deleting Entry will also delete its associated contents. Are you sure want to delete this entry?\n" +
    "		</div>\n" +
    "	</div>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-danger\" data-ng-click=\"delete()\">Delete</button>\n" +
    "	<button class=\"btn btn-info\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("itemtransferdetails/itemtransferdetails.modal.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransferdetails/itemtransferdetails.modal.tpl.html",
    "<div class=\"modal-header\">\n" +
    "	<h3 class=\"modal-title\">Issue Item</h3>\n" +
    "</div>\n" +
    "<div class=\"modal-body\">\n" +
    "	<form name=\"classForm\" novalidate data-ng-submit=\"save()\">\n" +
    "	<div class=\"alert alert-danger\" role=\"alert\" data-ng-show=\"registerError\">\n" +
    "			  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>\n" +
    "			  <span class=\"sr-only\">Error:</span>\n" +
    "			  		{{registerErrorMessage || 'Check Quantity Value'}}\n" +
    "			</div>\n" +
    "		<div class=\"row\">\n" +
    "			<div class=\"col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1\">\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Name</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"Name the transfer\" data-ng-model=\"itemtransferDetail.name\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Receiver</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"To\" data-ng-model=\"itemtransferDetail.recipient\" aria-describedby=\"basic-addon2\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon2\">College</span>\n" +
    "					</div>				\n" +
    "				</div>\n" +
    "				<div class=\"form-group\">\n" +
    "					<label class=\"control-label\" for=\"facultyDescription\">Quantity</label>\n" +
    "					<div class=\"input-group\">\n" +
    "					  <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\n" +
    "					  <input type=\"text\" class=\"form-control\" placeholder=\"How much?\" data-ng-model=\"itemtransferDetail.quantity\" aria-describedby=\"basic-addon1\">\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</div>\n" +
    "	</form>\n" +
    "</div>\n" +
    "<div class=\"modal-footer\">\n" +
    "	<button class=\"btn btn-success\" data-ng-click=\"save()\">Save</button>\n" +
    "	<button class=\"btn btn-warning\" data-ng-click=\"cancel()\">Cancel</button>\n" +
    "</div>");
}]);

angular.module("itemtransferdetails/itemtransferdetails.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("itemtransferdetails/itemtransferdetails.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container-fluid formContainer\">\n" +
    "		<div class=\"row\">\n" +
    "			<h3 class=\"col-md-8 col-sm-8\">Item History</h3>\n" +
    "		</div>\n" +
    "		<hr />\n" +
    "		<div style=\"margin-bottom: 5px;\">\n" +
    "			<button type=\"button\"\n" +
    "					class=\"btn btn-primary btn-sm\"\n" +
    "					data-ng-click=\"addTransferDetailsModal()\">\n" +
    "				<span class=\"fa fa-user-plus\"></span> Create Transfer\n" +
    "			</button>\n" +
    "		</div>\n" +
    "		<table class=\"table table-striped\">\n" +
    "			<thead>\n" +
    "				<tr>\n" +
    "					<th>Name</th>\n" +
    "					<th>To</th>\n" +
    "					<th>Quantity</th>\n" +
    "					<th>Status</th>\n" +
    "					<th>Date</th>\n" +
    "					<th></th>\n" +
    "					<th></th>\n" +
    "				</tr>\n" +
    "			</thead>\n" +
    "			<tbody>\n" +
    "				<tr data-ng-repeat=\"itemTransfer in itemTransfers.itemTransferDetails\">\n" +
    "					<td>\n" +
    "					   	<span class=\"fa fa-cogs\"> {{$index + 1}}.</span>\n" +
    "					   	<span>{{itemTransfer.name}}</span>\n" +
    "					<td>\n" +
    "					   	<span>{{itemTransfer.recipient || 'ADMIN'}}</span>\n" +
    "					</td>\n" +
    "					<td>\n" +
    "					   	<span>{{itemTransfer.quantity}}</span>						  						\n" +
    "					</td>\n" +
    "					<td>\n" +
    "					   	<span>{{itemTransfer.itemTranferDetailsStatus}}</span>						  						\n" +
    "					</td>\n" +
    "					<td>\n" +
    "					   	<span>{{parseDate(itemTransfer.created)}}</span>						  						\n" +
    "					</td>\n" +
    "					<td class=\"deleteWidth text-right\" data-ng-hide=\"!itemTransfer.recipient\">\n" +
    "						<span class=\"deleteWidth text-right\" data-ng-hide=\"itemTransfer.itemTranferDetailsStatus === 'RETURN'\">\n" +
    "							<a data-ng-click=\"addTransferReturnDetailsModal(itemTransfer)\"><span class=\"fa fa-exchange\"></span></a>\n" +
    "						</span>\n" +
    "					</td>\n" +
    "					<td class=\"text-right\" data-ng-show=\"!itemTransfer.recipient\">\n" +
    "						\n" +
    "					</td>\n" +
    "					<td class=\"deleteWidth text-right\" data-ng-hide=\"!itemTransfer.recipient\">\n" +
    "						<span class=\"deleteWidth text-right\" data-ng-hide=\"itemTransfer.itemTranferDetailsStatus === 'ISSUE'\">\n" +
    "							<a data-ng-click=\"deleteTransferDetailModal(itemTransfer)\"><span class=\"fa fa-trash-o\"></span></a>\n" +
    "						</span>\n" +
    "					</td>\n" +
    "					<td class=\"text-right\" data-ng-show=\"!itemTransfer.recipient\">\n" +
    "						\n" +
    "					</td>\n" +
    "				</tr>\n" +
    "			</tbody>\n" +
    "		</table>			\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("login/login.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("login/login.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container loginContainer\">\n" +
    "		<form name=\"loginForm\" novalidate data-ng-submit=\"doLogin();\">\n" +
    "			<div class=\"row\">\n" +
    "				<div class=\"col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2\">\n" +
    "					<div class=\"alert alert-danger\" role=\"alert\" data-ng-show=\"loginFailed\">\n" +
    "					  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>\n" +
    "					  <span class=\"sr-only\">Error:</span>\n" +
    "					  		User Name/Password mismatch\n" +
    "					</div>\n" +
    "					<div class=\"form-group\">\n" +
    "						<label class=\"control-label\" for=\"studentDescription\">User Name</label>\n" +
    "						<div class=\"input-group\">\n" +
    "						  <input type=\"text\" class=\"form-control\" placeholder=\"Name of the User\" data-ng-model=\"credentials.username\" aria-describedby=\"basic-addon2\">\n" +
    "						  <span class=\"input-group-addon\" id=\"basic-addon2\">@example.com</span>\n" +
    "						</div>				\n" +
    "					</div>\n" +
    "					<div class=\"form-group\">\n" +
    "						<label class=\"control-label\" for=\"studentDescription\">Password</label>\n" +
    "							<div class=\"input-group\">\n" +
    "							  <span class=\"input-group-addon\" id=\"basic-addon1\"><i class=\"fa fa-key\"></i></span>\n" +
    "							  <input type=\"password\" class=\"form-control\" placeholder=\"Password of user\" data-ng-model=\"credentials.password\" aria-describedby=\"basic-addon1\">\n" +
    "							</div>\n" +
    "					</div>\n" +
    "					<div class=\"form-group\">\n" +
    "						<button class=\"btn btn-success\"><span class=\"fa fa-sign-in fa-1x\"></span> \n" +
    "						Login</button>\n" +
    "					</div>\n" +
    "					<div class=\"form-group\">\n" +
    "						<a href=\"assets/documents/Talent.pdf\"><span class=\"fa fa-download\"></span> Download Talent Product Brochure</a>\n" +
    "					</div>\n" +
    "				</div>\n" +
    "			</div>\n" +
    "		</form>\n" +
    "	</div>\n" +
    "</div>");
}]);

angular.module("logout/logout.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("logout/logout.tpl.html",
    "<div class=\"row\">\n" +
    "	<div class=\"container\">\n" +
    "		<div><i class=\"fa fa-sign-out\"></i>Please wait while you are being logged out...</div>\n" +
    "	</div>\n" +
    "</div>");
}]);

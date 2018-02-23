/** created */
var app = angular.module("demoApp", []);

app.controller("demoCtrl", function($scope) {
	$scope.message = "Angular JS";
	
	$scope.testAngular = function(){
		   alert("Test angular");
	   };
	
});



	
	
	




/**
 * 
 */

/** created */
var app = angular.module("demoApp", []);

app.controller("demoCtrl", function($scope){

	   $scope.message = " demo angular";   
	
	   $scope.testCart = function(){
		   alert("Test angular");
	   };
	   
	  
});	 




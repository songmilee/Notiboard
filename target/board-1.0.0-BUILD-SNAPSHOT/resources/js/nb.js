var app = angular.module('noti', ['ngRoute']);

app.controller('blistController', function($scope, $window, $http){
	$scope.moveToWritePage = function(user){
		$http({
			method : "POST",
			url : "/write",
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			data : $.param({ name : user})
		}).then(function success(res){
			console.log(res.data);
		}), function fail(res){
			alert("Sorry, Internal Error");
		}
	}
});
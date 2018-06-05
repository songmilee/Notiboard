var app = angular.module('noti', ['ngRoute']);

app.controller('blistController', function($scope, $window, $http){
	$scope.moveToWritePage = function(user){
		$http({
			method : "POST",
			url : "/write",
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			data : $.param({ name : user})
		}).then(function success(res){
			console.log(res.data.result);
			
			if(res.data.result == "true"){
				$window.location.href = "/write";
			} else {
				alert("sorry, Internal Error! back to home!");
				$window.location.href="/";
			}
		}), function fail(res){
			alert("Sorry, Internal Error");
		}
	}
});
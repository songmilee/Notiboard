var app = angular.module('noti', ['ngRoute']);

var currentPage = 0;

app.config(function($locationProvider, $routeProvider){
	  $locationProvider.html5Mode({
	    enabled: true,
	    requireBase: false
	  });
});

app.controller('blistController', function($scope, $window, $http){
	$scope.result = [];
	//controller page에 접속 되었을 때
	$http({
		method: "POST",
		url : "/request/listboard",
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		data : $.param({ curpage : currentPage })		
	}).then(function success(res){
		$scope.result = res.data;		
	}), function fail(res){				
		alert("Sorry, Internal Error");
	}
	
	$scope.writePage = function(){
		$window.location.href="/write";
	}
});

app.controller('writeController', function($scope, $window, $http){
	$scope.submit = function(){		
		if($scope.name == "" || ($scope.name) == null 
				|| $scope.title == "" || $scope.title == null 
				|| $scope.detail == "" || $scope.detail == null){
			alert("모든 내용을 입력해 주시길 바랍니다.");
		}
		else{
			var notiTxt = {
					name : $scope.name,
					title : $scope.title,
					detail : $scope.detail					
			}
			
			$http({
				method : "POST",
				url : "/request/write",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param(notiTxt)
			}).then(function success(res){
				console.log(res.data.result);
				
				if(res.data.result == "true"){
					$window.location.href = "/blist";
				} else {
					alert("sorry, Internal Error! back to home!");
					$window.location.href="/";
				}
			}), function fail(res){				
				alert("Sorry, Internal Error");
			}
			
			
			console.log(notiTxt);
		}
				
	}
});
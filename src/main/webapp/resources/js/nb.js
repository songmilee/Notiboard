var app = angular.module('noti', ['ngRoute']);

var curpage = 1;
app.config(function($locationProvider, $routeProvider){
	  $locationProvider.html5Mode({
	    enabled: true,
	    requireBase: false
	  });
});

app.controller('blistController', function($scope, $window, $http, $location){
	$scope.result = [];

	$scope.writePage = function(){
		$window.location.href="/write?user_name="+$location.search().user_name;
	}
	
	$scope.getID = function(x){
		user_name = $location.search().user_name;
		no = x;
		
		tempPage = $location.search().curpage;
		if(!(tempPage == undefined))
			curpage = tempPage;
		
		$window.location.href="/view?user_name="+user_name+"&curpage="+curpage+"&no="+no;
	}
	
	$scope.paging = function(x){
		user_name = $location.search().user_name;
		curpage = x;
		
		$window.location.href="/blist?user_name="+user_name+"&curpage="+curpage;
	}
	
});

app.controller('writeController', function($scope, $window, $http, $location){
	$scope.name = $location.search().user_name;
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
				url : "/write",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param(notiTxt)
			}).then(function success(res){
				console.log(res.data.result);
				
				if(res.data.result == 1){
					$window.location.href = "/blist?user_name="+notiTxt.name;
				} else {
					alert("sorry, Internal Error! back to home!");
					$window.location.href="/blist?user_name="+notiTxt.name;
				}
			}), function fail(res){				
				alert("Sorry, Internal Error");
			}
			
			
			console.log(notiTxt);
		}
				
	}
});

app.controller('viewController', function($scope, $http, $window, $location){
	no = $location.search().no;
	
	$scope.writeComment = function(){
		
	};
	
	$scope.goList = function(){
		tempPage = $location.search().curpage;
		if(!(tempPage == undefined))
			curpage = tempPage;
		
		$window.location.href = "/blist?user_name="+$location.search().user_name+"&curpage="+curpage;
	};
	
	$scope.goNext = function(total){
		next = Number(no) + 1;
		user_name = $location.search().user_name;
		
		if(total >= next){
			$window.location.href="/view?user_name="+user_name+"&no="+next;
		} else {
			alert("목록의 마지막 입니다.");
		}
	}
	
	$scope.goPrev = function(){
		prev = Number(no) - 1;
		user_name = $location.search().user_name;
		
		if(prev > 0){
			$window.location.href="/view?user_name="+user_name+"&no="+prev;
		} else {
			alert("목록의 마지막 입니다.");
		}
	}
});

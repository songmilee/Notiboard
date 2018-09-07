var app = angular.module('noti', ['ngRoute', 'angular-md5']);

var curpage = 1;
app.config(function($locationProvider, $routeProvider){
	  $locationProvider.html5Mode({
	    enabled: true,
	    requireBase: false
	  });
});

app.controller('homeController', function($scope, $window, md5, $http){
	
	$scope.login = function(){
		if(!$scope.id || !$scope.pwd) alert("폼을 채워 주세요.");		
		else{
			pd = md5.createHash($scope.pwd || "");
			login = {
					id : $scope.id,
					pwd : pd
			}
			
			$scope.disableBtn = true;
			
			$http({
				method : "POST",				
				url : "/",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param(login)
			}).then(function success(res){
				result = res.data.result;
				if(result == "1000"){
					alert("로그인에 성공하셨습니다.");
					$window.location.href="/blist";
				} else if(result == "2000"){
					alert("로그인에 실패하셨습니다. ID/비밀번호를 다시 한 번 확인해주세요.");
				}
			}), function fail(res){
				alert("내부적 오류입니다. 다시 시도해 주세요");
			}
		}
	}
		
});

app.controller('registerController', function($scope, $window, $http, md5){
	$scope.register = function(){
		if(!$scope.id || !$scope.pwd || !$scope.name) alert("폼을 채워주세요.");
		else{
			mdpwd = md5.createHash($scope.pwd || "");
			
			member = {
					id : $scope.id,
					pwd : mdpwd,
					name : name
			}
			
			$http({
				method : "POST",
				url : "/register",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param(member)
			}).then(function success(res){
				result = res.data.result;
				if(result == "3000"){
					alert("정보가 등록 되었습니다.");
					$window.location.href="/";
				} else if(result == "4000"){
					alert("등록에 실패하셨습니다. ID가 중복됩니다.");
				}
			}), function fail(res){
				alert("내부적 오류입니다. 다시 시도 부탁드립니다.");
			}
		}
	}
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

			$scope.disableBtn = true;
			
			$http({
				method : "POST",
				url : "/write",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param(notiTxt)
			}).then(function success(res){
				
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

function go(path){
	console.log(path);
	window.location.href = path;
}
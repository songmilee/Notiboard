<html>
<%@ include file="./partial/header.html" %>
<body ng-app="noti">
	<div class="row" id="enter-view" ng-controller="homeController">
		<div style="padding-top : 30px; margin:0 auto;">
			<form ng-submit="login()" class="table-responsive">
				<table class="table table-borderless">
					<tr>
						<td>ID</td>
						<td><input type="text" ng-model="id" placeholder="Enter your name"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" ng-model="pwd" placeholder="Enter your password"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-default btn-primary" style="width : 100%" value="Enter"></td>
					</tr>
					<tr>
						<td colspan="2"><button class="btn btn-default btn-primary" style="width : 100%" ng-click="moveReg()">Register</button></td>
					</tr>
				</table>															
			</form>																	
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

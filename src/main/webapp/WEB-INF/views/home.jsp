<html>
<%@ include file="./partial/header.html" %>
<body ng-app="noti">
	<div class="row" id="enter-view" ng-controller="homeController">
		<div style="padding-top : 30px; margin:0 auto;">
			<div class="table-responsive">
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
						<td colspan="2"><button type="submit" class="btn btn-default btn-primary max-width" ng-click="login()">Login</button></td>
					</tr>
					<tr>
						<td colspan="2"><button class="btn btn-default btn-primary max-width" onclick="go('/register')">Register</button></td>
					</tr>
				</table>															
			</div>																	
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

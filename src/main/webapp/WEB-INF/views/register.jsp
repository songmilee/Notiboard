<html>
<%@ include file="./partial/header.html" %>
<body ng-app="noti">
	<div class="content" ng-controller="registerController">
		<div>
			<form ng-submit="register()" role="form" class="table-responsive">
				<table class="table table-borderless">
					<tr>
						<td>ID</td>
						<td><input class="max-width" type="text" name="id" ng-model="id"/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pwd" ng-model="pwd" class="max-width"/></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" ng-model="name" class="max-width"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-default btn-primary max-width" ng-init="disableBtn=false" ng-disabled="disableBtn">Register</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

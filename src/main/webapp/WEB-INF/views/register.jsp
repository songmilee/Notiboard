<html>
<%@ include file="./partial/header.html" %>
<body>
	<div class="content">
		<div>
			<form role="form" class="table-responsive">
				<table class="table table-borderless">
					<tr>
						<td>ID</td>
						<td><input class="max-width" type="text" name="id" id="id"/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pwd" id="pwd" class="max-width"/></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" id="name" class="max-width"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-default btn-primary max-width">Register</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@ include file="./partial/header.html" %>
<body>
	<div class="row" id="enter-view">
		<div class="container">
			<div class="outer">
				<form action="/blist">
					<input type="text" name="user_name" placeholder="Enter your name">								
					<input type="submit" class="btn btn-default btn-primary" value="Enter">
				</form>	
				<button class="btn btn-default btn-primary">Register</button>					
				<p><br>The time on the server is ${serverTime}. </p>								
			</div>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

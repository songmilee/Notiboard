<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@ include file="./partial/header.html" %>
<body>
	<div class="row" id="enter-view">
		<div class="container">
			<div class="outer">								
				<a href="/blist"><button class="btn btn-default btn-primary">Click this Button !</button></a>						
				<p><br>The time on the server is ${serverTime}. </p>								
			</div>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

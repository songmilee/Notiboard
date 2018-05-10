<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@ include file="./partial/header.html" %>
<body>
	<div class="row">
		<div class="main-view" id="enter-view">
			<form class="form-inline">			  
			  <div class="form-group mx-sm-3 mb-2">
			    <label for="user_name">User Name</label>
			    <input type="text" class="form-control" id="user_name">
			    <button type="submit" class="btn btn-primary mb-2">Confirm</button>
			  </div>			  
			</form>			
			<P><br><br>The time on the server is ${serverTime}. </P>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

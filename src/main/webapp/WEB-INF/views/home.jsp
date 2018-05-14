<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<%@ include file="./partial/header.html" %>
<body>
	<div class="row" id="enter-view">
		<div class="container">
			<div class="outer">								
				<form:form action="/blist" modelAttribute="user" method="post">			  
				  <div class="row col-md-12" style="padding-bottom : 10px;">
				    <form:label path="user_name">User Name</form:label>
				    <form:input type="text" path="user_name" class="form-control"/>				    						    
				  </div>
				  <button type="submit" class="btn btn-primary">Confirm</button>				  				  		  		  
				</form:form>
						
				<p><br>The time on the server is ${serverTime}. </p>								
			</div>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>

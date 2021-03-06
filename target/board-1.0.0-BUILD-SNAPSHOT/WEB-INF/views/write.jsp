<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body>

	<div class="container">
		<form role="form">
			<div class="form-group">
				<div class="row">
					<label for="title">제목</label>
	  				<input type="text" class="form-control bottom-space" id="title"></input>
				</div>
				
				<div class="row bottom-space">
					<label for="detail">내용</label>
	  				<textarea class="form-control" rows="10" id="detail"></textarea>
				</div>
				
				<div class="row float-right">
					<button type="submit" class="btn btn-default btn-primary">작성</button>
				</div>
			</div>
		</form>	
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>
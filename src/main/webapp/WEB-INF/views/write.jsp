<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body ng-app="noti">

	<div class="container" ng-controller="writeController">
		<form role="form" ng-submit="submit()">
			<div class="form-group">
				<div class="row">
					<label for="title">제목</label>
	  				<input type="text" class="form-control bottom-space" ng-model="title" id="title"></input>
				</div>
				
				<div class="row">
					<label for="name">작성자</label>
					<input type="text" class="form-control bottom-space" id="name" ng-model="name"/>
				</div>
				
				<div class="row bottom-space">
					<label for="detail">내용</label>
	  				<textarea class="form-control" rows="10" id="detail" ng-model="detail"></textarea>
				</div>
				
				<div class="row float-right" ng-init="disableBtn=false">
					<button type="submit" class="btn btn-default btn-primary" ng-disabled="disableBtn">작성</button>
				</div>
			</div>
		</form>	
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>
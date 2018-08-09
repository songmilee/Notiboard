<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body ng-app="noti" ng-controller="viewController">
	<div class="container">
	
		<!-- buttom list -->
		<div class="bottom-space">
			<button class="btn btn-default btn-primary" ng-click="goList()">목록</button>
			<div class="float-right">
				<button class="btn btn-default" ng-click="goNext(${total })">다음글</button>
				<button class="btn btn-default" ng-click="goPrev()">이전글</button>
			</div>			
		</div>
		
		<!-- board detail -->
		<div class="bottom-space">
		
			<div class="card">
				<div class="card-header">${ result.title }</div>
			</div>	
			<div class="card-body bottom-space">
				<p class="text-right bottom-space">날짜 : ${ result.created} 조회수 : ${result.hit}</p>			
				<p class="card-text">${result.detail}</p>
			</div>
			
			<div class="card-footer bottom-space">
				<div class="text-right">작성자 : ${result.name}</div>
			</div>
			<div style="padding-left:15px; padding-right:15px;">
			
			<form action="writeComment()">
				<div class="form-group">					
					<div class="row bottom-space">
						<label for="comment">comment</label>
		  				<textarea class="form-control" rows="3" id="comment"></textarea>
					</div>
					
					<div class="row float-right bottom-space">
						<button type="submit" class="btn btn-default btn-primary">작성</button>
					</div>
				</div>
			</form>
			</div>
		</div>	
		
		<!-- comment list -->
		<div class="table-responsive">
			<table class="table table-hover" id="comment">
				<tr>
					<td>
						<div class="row" style="margin-left:15px; margin-right:15px">
							<p class="float-left">no. 이름</p>
							<p class="float-right">날짜</p>
						</div>
						
						<div class="row" style="margin-left:15px; margin-right:15px">
							<p>comment</p>
						</div>		
									
					</td>
				</tr>			
			</table>
		</div>
		
		<!-- comment form -->
		<div class="bottom-space">
			
		</div>		
		
		<!-- button list -->
		<div class="bottom-space">
			<button class="btn btn-default btn-primary" ng-click="goList()">목록</button>
			<div class="float-right">
				<button class="btn btn-default" ng-click="goNext(${total })">다음글</button>
				<button class="btn btn-default" ng-click="goPrev()">이전글</button>
			</div>			
		</div>
					
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>
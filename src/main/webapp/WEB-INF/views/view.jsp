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
				<p class="text-right small-font bottom-space">날짜 : ${ result.created}    조회수 : ${result.hit}</p>			
				<p class="card-text">${result.detail}</p>
			</div>
			
			<div class="card-footer bottom-space">
				<div class="text-right">작성자 : ${result.name}</div>
			</div>
		</div>	
		
		<div class="bottom-space comment-write">
			<!-- Comment Form -->
			<form action="view" method="post">
				<div class="form-group comment-write-form">					
					<div class="row bottom-space">
						<label for="detail">comment</label>
		  				<textarea class="form-control" rows="3" cols="40" id="detail" name="detail"></textarea>
		  				<input type="hidden" name="no" id="no" value="<%= request.getParameter("no") %>" />
					</div>
					
					<div class="row right95">
						<button type="submit" class="btn btn-default btn-primary">작성</button>
					</div>
				</div>
			</form>
		</div>
		
		<!-- comment list -->
		<div class="bottom-space">
			<div id="comment">
				<c:choose>
					<c:when test="${fn:length(comment) > 0}">
						<c:forEach items="${comment }" var="com" varStatus="status">
							<div class = "comment-box bottom-space">
								<div class="row" >
									<p style="bold">NO. ${ status.index + 1 }   </p>
								</div>
								<div class="row">
									<p>${com.detail }</p>
								</div>
								<div class="small-font">
									<p class="text-right">${com.created }</p>
								</div>
							</div>
						</c:forEach>
					</c:when>
					
					<c:otherwise>
						<div class="comment-box"">
							<p class="text-center">등록된 댓글이 없습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
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
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
			
			
			
			<!-- Comment Form -->
			<form action="view" method="post">
				<div class="form-group">					
					<div class="row bottom-space">
						<label for="detail">comment</label>
		  				<textarea class="form-control" rows="3" cols="40" id="detail" name="detail"></textarea>
		  				<input type="hidden" name="no" id="no" value="<%= request.getParameter("no") %>" />
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
			<table class="table" id="comment">
				<tbody>
					<c:choose>
						<c:when test="${fn:length(comment) > 0}">
							<c:forEach items="${comment }" var="com">
								<tr>
									<td>
										<div class="row" style="margin-left:15px; margin-right:15px">
											<p class="float-left">${com.pk }</p>
											<p class="float-right">${com.created }</p>
										</div>
										
										<div class="row" style="margin-left:15px; margin-right:15px">
											<p>${com.detail }</p>
										</div>		
													
									</td>
								</tr>
							</c:forEach>
						</c:when>
						
						<c:otherwise>
							<tr>
								<td>등록된 댓글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
							
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
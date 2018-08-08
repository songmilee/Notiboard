<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body>
	<div ng-app="noti" ng-controller="blistController" class="row">
		<div class="container">			
			<p>Hello! <%= request.getParameter("user_name") %></p>
			<div id="writeData" class="row" style="padding-top:20px; padding-bottom:10px;">
				<button ng-click="writePage()" class="btn btn-primary">글 쓰기</button>
			</div>
			
			<div class="row table-responsive">
				<table class="table" id="board">
					<colgroup>
						<col width="10%" />
						<col width = "*"/>
						<col width = "15%"/>
						<col width = "15%"/>
						<col width = "10%"/>
					</colgroup>
					<thead class="thead-dark">
						<tr>
							<th scope="col">no</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
					<!-- tr ng-repeat="x in result" ng-click=getID(x)>
							<th scope="row">{{ x.no }}</th>
							<td>{{x.title}}</td>
							<td>{{x.name}}</td>
							<td>{{x.created}}</td>
							<td>{{x.hit}}</td>
						</tr-->
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list }" var="row">
									<tr ng-click=getID('${row.no }')>
										<td>${row.no }</td>
										<td>${row.title }</td>
										<td>${row.name } </td>
										<td>${row.created } </td>
										<td>${row.hit }</td>	
									</tr>
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<tr>
									<td>조회된 결과가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>						
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>
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
			<p>전체 게시글 : ${total }</p>
			
			<div id="writeData" class="row" style="padding-top:20px; padding-bottom:10px;">
				<button ng-click="writePage()" class="btn btn-primary">글 쓰기</button>
			</div>
			
			<div class="row table-responsive">
				<table class="table table-hover" id="board">
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
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list }" begin="${ page.startIndex }" end="${page.startIndex + page.pageSize - 1 }" var="row">
									<tr class='clickable-row' ng-click=getID('${row.no }')>
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
			
			<div class = "page">
				<c:if test="${page.curBlock ne 1 }">
					<a href="#" ng-click="paging(1)">[처음]</a>
				</c:if>
				<c:if test="${page.curPage ne 1 }">
					<a href="#" ng-click="paging('${page.prevPage }')">[이전]</a>
				</c:if>
				
				<c:forEach var="pageNum" begin="${page.startPage }" end="${page.endPage }">
					<c:choose>
						<c:when test="${pageNum eq page.curPage }">
							<span style="font-weight:bold;"><a href="#" >${pageNum }</a>
						</c:when>
						<c:otherwise>
							<a href="#" ng-click="paging('${pageNum}')">${pageNum }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${page.curPage ne page.totalPage && page.totalPage > 0 }">
					<a href="#" ng-click="paging('${page.nextPage }')">[다음]</a>
				</c:if>
				<c:if test="${page.curBlock ne page.totalBlock && page.totalBlock > 0 }">
					<a href="#" ng-click="paging('${page.totalPage }')">[끝]</a>
				</c:if>
			</div>
		</div>
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>